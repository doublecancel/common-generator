package cn.opt.gen;

import cn.opt.gen.bean.Column;
import cn.opt.gen.bean.Table;
import cn.opt.gen.config.JooqConfig;
import cn.opt.gen.utils.Commons;
import cn.opt.gen.utils.ReadProp;
import com.google.common.base.CaseFormat;
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

/**
 * Created by Administrator on 2017/9/20.
 */
public class StartGuan {


    private static final String domainPackageName = "com.ucpaas.entity.base";
    private static final String servicePackageName = "com.ucpaas.opt.service";
    private static final String serviceImplPackageName = "com.ucpaas.opt.service";
    private static final String controllerPackageName = "opt.controller";
    private static final String daoPackageName = "com.ucpaas.dao";

    private static final String domainClassSuffix = "Domain";
    private static final String daoClassSuffix = "Dao";
    private static final String serviceClassSuffix = "Service";
    private static final String serviceImplClassSuffix = "ServiceImpl";
    private static final String controllerClassSuffix = "Controller";


    private static final String ftlPath = "F:\\github\\generate-code\\src\\main\\resources\\ftl";

    private static final String DB = "ucpaas";

    private static DSLContext context = JooqConfig.getContext();

    public static StartGuan create(){
        return new StartGuan();
    }

    public static void main(String[] args) {

        create().generate();

    }

    private void generate(){
        List<String> tables =  getTableInfoFromDb();
        tables.forEach(a -> {

            List<Column> columns = getColumnInfos(a);
            Table table = getTableInfo(a);

            System.out.println(a);
            //生成实体类
            generateDomain(columns, table);
            //生成mapper文件
            gererateMapper(columns, table);
            //生成dao
            generateDao(columns, table);
            //生成service接口
            generateService(columns, table);
            //生成serviceimpl实现类
            generateServiceImpl(columns, table);
            //生成controller
            generateController(columns, table);
            //生成配置类
            generateConfig();
            //生成test测试类
            generateTest();
            //生成jsp文件
            generateJsp();
            //生成自定义的mapper空文件
            generateEmptyMapper();

        });
    }

    private void generateEmptyMapper() {
    }

    private void generateJsp() {

    }

    private void generateTest() {
    }

    private void generateConfig() {
    }

    private void generateController(List<Column> columns, Table table) {
        createDirIfNotExists(ReadProp.configProp.getBasepath());//创建跟目录
        createDirIfNotExists(ReadProp.configProp.getControllerpath());//创建父级目录

        String target = ReadProp.configProp.getControllerpath() + "//" + table.getControllerClassName() + ".java";
        process(columns, table, "controller.ftl", target);//serviceImpl
    }

    private void generateServiceImpl(List<Column> columns, Table table) {
        createDirIfNotExists(ReadProp.configProp.getBasepath());//创建跟目录
        createDirIfNotExists(ReadProp.configProp.getServiceImplpath());//创建父级目录

        String target = ReadProp.configProp.getServiceImplpath() + "//" + table.getServiceImplClassName() + ".java";
        process(columns, table, "serviceImpl.ftl", target);//serviceImpl
    }

    private void generateService(List<Column> columns, Table table) {
        createDirIfNotExists(ReadProp.configProp.getBasepath());//创建跟目录
        createDirIfNotExists(ReadProp.configProp.getServicepath());//创建父级目录

        String target = ReadProp.configProp.getServicepath() + "//" + table.getServiceClassName() + ".java";
        process(columns, table, "iservice.ftl", target);
    }

    private void generateDao(List<Column> columns, Table table) {
        createDirIfNotExists(ReadProp.configProp.getBasepath());//创建跟目录
        createDirIfNotExists(ReadProp.configProp.getDaopath());//创建父级目录

        String target = ReadProp.configProp.getDaopath() + "//" + table.getDaoClassName() + ".java";
        process(columns, table, "dao.ftl", target);

    }

    private void gererateMapper(List<Column> columns, Table table) {
        //设置table中的primaryKey和primaryType
        initPrimaryInfo(table, columns);

        createDirIfNotExists(ReadProp.configProp.getBasepath());//创建跟目录
        createDirIfNotExists(ReadProp.configProp.getMapperpath());//创建父级目录
        String target = ReadProp.configProp.getMapperpath() + "//" + table.getDaoClassName() + "Mapper.xml";
        process(columns, table, "mapper.ftl", target);
    }


    private void generateDomain(List<Column> columns, Table table){
        createDirIfNotExists(ReadProp.configProp.getBasepath());
        createDirIfNotExists(ReadProp.configProp.getDomainpath());
        String target = ReadProp.configProp.getDomainpath() + "//" + table.getDomainClassName() + ".java";
        process(columns, table, "domain.ftl", target);
    }

    private void initPrimaryInfo(Table table, List<Column> columns){
        String id = columns.stream().filter(a -> a.getKey()).findFirst().map(a -> a.getField()).orElse("id");
        String type = columns.stream().filter(a -> a.getKey()).findFirst().map(a -> a.getType()).orElse("Long");
        table.setPrimaryKey(id);
        table.setPrimaryType(type);
    }

    private List<String> getTableInfoFromDb(){
        Result<Record> result = context.fetch("select * from information_schema.TABLES where table_schema = '" + DB + "'");
        return result.stream()
                .filter(a -> !(a.get("TABLE_TYPE").toString().equalsIgnoreCase("VIEW")))
                .map(a -> a.get("TABLE_NAME").toString())
                .filter(a -> !a.startsWith("tb_srv_file_"))
                .filter(a -> !a.startsWith("tb_bill_client_acct_"))
                .filter(a -> !a.startsWith("tb_user_balance_"))
                .filter(a -> !a.startsWith("tb_ucpaas_today_consume_"))
                .collect(Collectors.toList());
    }

    private Table getTableInfo(String tableName){
        Table table = new Table();
        table.setDomainClassName(className(tableName) + domainClassSuffix);
        table.setDaoClassName(className(tableName) + daoClassSuffix);
        table.setServiceClassName(className(tableName) + serviceClassSuffix);
        table.setServiceImplClassName(className(tableName) + serviceImplClassSuffix);
        table.setControllerClassName(className(tableName) + controllerClassSuffix);

        table.setDaoPackageName(daoPackageName);
        table.setDomainPackageName(domainPackageName);
        table.setServicePackageName(servicePackageName);
        table.setServiceIMplPackageName(serviceImplPackageName);
        table.setControllerPackageName(controllerPackageName);

        table.setDesc("对应表：" + DB + "." +tableName);
        table.setTableName(tableName);
        table.setDB(DB);
        return table;
    }

    private void process(List<Column> columns, Table table, String ftl, String targetPath){
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


    private void createDirIfNotExists(String dir){
        File file = new File(dir);
        if(!file.exists()){
            file.mkdir();
        }
    }

    static Pattern p = Pattern.compile("\\s*|\t|\r|\n");

    public List<Column> getColumnInfos(String tableName){
        Result<Record> result = context.fetch("show full fields from " + tableName);
        List<Column> columns = result.stream().map(a -> {
            Column column = Column.create();
            column.setField(a.get("Field").toString());
            column.setSetMethodName(setMethodName(a.get("Field").toString()));
            column.setGetMethodName(getMethodName(a.get("Field").toString()));

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


    private String className(String tableName){
        String a = tableName.substring(tableName.indexOf(".") + 1);
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, a);
    }

    private String fieldName(String column){
        String aaa = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, column);
        return aaa;
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







}
