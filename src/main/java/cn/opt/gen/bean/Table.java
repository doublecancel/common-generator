package cn.opt.gen.bean;

import lombok.Data;

/**
 * Created by Administrator on 2017/9/20.
 */
@Data
public class Table {
    private String domainClassName;
    private String daoClassName;
    private String serviceClassName;
    private String serviceImplClassName;
    private String controllerClassName;

    private String domainPackageName;
    private String daoPackageName;
    private String servicePackageName;
    private String serviceIMplPackageName;
    private String controllerPackageName;

    private String createDate;
    private String desc;
    private String author;
    private String tableName;
    private String DB;

    private String primaryKey;
    private String primaryType;
}
