package cn.opt.gen;

import cn.opt.gen.bean.Column;
import cn.opt.gen.bean.Table;
import cn.opt.gen.config.JooqConfig;
import cn.opt.gen.utils.Commons;
import cn.opt.gen.utils.ReadProp;
import com.google.common.base.Preconditions;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GenerateControllerAndService {


    private String ftlPath = "F:\\github\\generate-code\\src\\main\\resources\\ftl";

    private String controllerPath = ReadProp.configProp.getControllerpath();

    private static DSLContext context = JooqConfig.getContext();

    private static final String DB = "";

    public static void main(String[] args) {



    }

    private void generateController(){

    }

    private void generateService(){

    }

    private void generateVO(){

    }

    private void generateDto(){

    }


    private String setMethodName(String column){
        char[] cs = column.toCharArray();
        cs[0] = Character.toUpperCase(cs[0]);
        return "set" + new String(cs);
    }

    private String getMethodName(String column){
        char[] cs = column.toCharArray();
        cs[0] = Character.toUpperCase(cs[0]);
        return "get" + new String(cs);
    }


    static Pattern p = Pattern.compile("\\s*|\t|\r|\n");

    public List<Column> getColumnInfos(String tableName){
        Result<Record> result = context.fetch("show full fields from " + tableName);
        List<Column> columns = result.stream().map(a -> {
            Column column = Column.create();
            column.setField(a.get("Field").toString());
            column.setSetMethodName(setMethodName(a.get("Field").toString()));
            column.setGetMethodName(getMethodName(a.get("Field").toString()));
            column.setUPfield(a.get("Field").toString().toUpperCase());
            column.setComment(p.matcher(a.get("Comment").toString()).replaceAll(""));
            String type = a.get("Type").toString();

            type = ReadProp.mapping.get(resolve(type));
            Preconditions.checkNotNull(type, String.format("数据库类型：%s找不到对应的java类型", a.get("Type").toString()));
            column.setType(type);
            column.setNUll(Optional.ofNullable(a.get("Null")).map(t -> t.toString().equals("YES")).orElse(false));
            column.setKey(Optional.ofNullable(a.get("Key")).map(t -> t.toString().equals("PRI")).orElse(false));

//            System.out.println(column.toString());
            return column;
        }).collect(Collectors.toList());

        return columns;
    }


    private String resolve(String mysqlType){
        int index = mysqlType.indexOf("(");
        if(index < 0) return mysqlType;
        return mysqlType.substring(0, index);
    }


    private List<String> getTableInfoFromDb(){
        Result<Record> result = context.fetch("select * from information_schema.TABLES where table_schema = '" + DB + "'");
        return result.stream()
                .map(a -> a.get("TABLE_NAME").toString())
                .collect(Collectors.toList());
    }


    private void process(List<Column> columns, Table table, String ftl, String targetPath) {
        final String templatePath = ftlPath;
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        try {

            FileTemplateLoader loader = new FileTemplateLoader(new File(templatePath));
            configuration.setTemplateLoader(loader);
            Template template = configuration.getTemplate(ftl, "UTF-8");
            FileOutputStream os = new FileOutputStream(targetPath);
            Map<String, Object> map = Commons.newHashMap("columns", columns,
                    "table", table,
                    "now", Commons.nowAsString());
            template.process(map, new OutputStreamWriter(os));
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }


}
