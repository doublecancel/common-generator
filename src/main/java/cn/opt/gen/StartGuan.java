package cn.opt.gen;

import cn.opt.gen.config.JooqConfig;
import lombok.Data;
import org.jooq.DSLContext;
import org.springframework.beans.BeanUtils;

/**
 * Created by Administrator on 2017/9/20.
 */
@Data
public class StartGuan {


    private  String domainPackageName = "com.ucpaas.entity.base";
    private  String servicePackageName = "com.ucpaas.opt.service";
    private  String serviceImplPackageName = "com.ucpaas.opt.service";
    private  String controllerPackageName = "opt.controller";
    private  String daoPackageName = "com.ucpaas.dao";

    private  String domainClassSuffix = "Domain";
    private  String daoClassSuffix = "Dao";
    private  String serviceClassSuffix = "Service";
    private  String serviceImplClassSuffix = "ServiceImpl";
    private  String controllerClassSuffix = "Controller";


    private  String ftlPath = "F:\\github\\generate-code\\src\\main\\resources\\ftl";

    private  String paramsMap = "com.opt2016.core.ParamsMap";

    private  String DB = "ucpaas";

    private static DSLContext context = JooqConfig.getContext();

    public static StartGuan create(){
        return new StartGuan();
    }

    public static void main(String[] args) {
        CommanStart.init(new StartGuan()).generate();
    }

}
