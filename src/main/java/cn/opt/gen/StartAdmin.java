package cn.opt.gen;

import lombok.Data;

/**
 * Created by Administrator on 2017/9/20.
 */
@Data
public class StartAdmin {

    private  String domainPackageName = "com.ucpaas.admin.domain.base";
    private  String servicePackageName = "opt.service";
    private  String serviceImplPackageName = "opt.service";
    private  String controllerPackageName = "opt.controller";
    private  String daoPackageName = "com.ucpaas.admin.dao.master";

    private  String domainClassSuffix = "Domain";
    private  String daoClassSuffix = "Dao";
    private  String serviceClassSuffix = "Service";
    private  String serviceImplClassSuffix = "ServiceImpl";
    private  String controllerClassSuffix = "Controller";

    private  String ftlPath = "F:\\github\\generate-code\\src\\main\\resources\\ftl";

    private  String DB = "ucpaas";

    private  String paramsMap = "com.ucpaas.admin.dao.ParamsMap";

    public static void main(String[] args) {
        CommanStart.init(new StartAdmin()).generate();
    }


}
