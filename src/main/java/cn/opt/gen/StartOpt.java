package cn.opt.gen;

import cn.opt.gen.config.JooqConfig;
import lombok.Data;
import org.jooq.DSLContext;

/**
 * Created by Administrator on 2017/9/20.
 */
@Data
public final class StartOpt {


    private  String domainPackageName = "com.ucpaas.opt.domain";
    private  String servicePackageName = "com.ucpaas.opt.service";
    private  String serviceImplPackageName = "com.ucpaas.opt.service";
    private  String controllerPackageName = "opt.controller";
    private  String daoPackageName = "com.ucpaas.opt.dao.master";

    private  String domainClassSuffix = "Domain";
    private  String daoClassSuffix = "Dao";
    private  String serviceClassSuffix = "Service";
    private  String serviceImplClassSuffix = "ServiceImpl";
    private  String controllerClassSuffix = "Controller";

    private  String paramsMap = "com.ucpaas.opt.common.ParamsMap";//paramsMap的全路径配置


    private  String ftlPath = "F:\\github\\generate-code\\src\\main\\resources\\ftl";

    private  String DB = "ucpaas";

    private static DSLContext context = JooqConfig.getContext();

    public static StartOpt create(){
        return new StartOpt();
    }

    public static void main(String[] args) {
        CommanStart.init(new StartOpt()).generate();
    }


}
