package opt.entity;

import java.time.LocalDateTime;
/**
* Created by Administrator on 2017-10-31 11:49:20
* 该类由代码生成工具生成，只替换不要修改
* 如果需要拓展该类，请使用继承
* 对应表：test.tb_ucpaas_menu
*/
public class TbUcpaasMenuDomain {

    private Integer menu_id;//菜单ID

    private String menu_name;//菜单名称

    private String remark;//备注

    private String menu_url;//菜单路径

    private String menu_class;//菜单样式

    private String menu_type;//菜单类型，1:正常菜单，2:功能点

    private Integer level;//级别，从1开始

    private String parent_id;//父菜单ID，第1级为0，使用,分割

    private Integer sort;//排序

    private String status;//状态：1生效，0失效

    private Integer web_id;//菜单属于哪个系统1:ucpaas-admin2:ucpaas-operate;3:ucpaas-operate2016



    public void setMenu_id(Integer menu_id){
        this.menu_id = menu_id;
    }
    public Integer getMenu_id(){
        return this.menu_id;
    }
    public void setMenu_name(String menu_name){
        this.menu_name = menu_name;
    }
    public String getMenu_name(){
        return this.menu_name;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return this.remark;
    }
    public void setMenu_url(String menu_url){
        this.menu_url = menu_url;
    }
    public String getMenu_url(){
        return this.menu_url;
    }
    public void setMenu_class(String menu_class){
        this.menu_class = menu_class;
    }
    public String getMenu_class(){
        return this.menu_class;
    }
    public void setMenu_type(String menu_type){
        this.menu_type = menu_type;
    }
    public String getMenu_type(){
        return this.menu_type;
    }
    public void setLevel(Integer level){
        this.level = level;
    }
    public Integer getLevel(){
        return this.level;
    }
    public void setParent_id(String parent_id){
        this.parent_id = parent_id;
    }
    public String getParent_id(){
        return this.parent_id;
    }
    public void setSort(Integer sort){
        this.sort = sort;
    }
    public Integer getSort(){
        return this.sort;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setWeb_id(Integer web_id){
        this.web_id = web_id;
    }
    public Integer getWeb_id(){
        return this.web_id;
    }

    //------------------------------------------------------------------------------
    public TbUcpaasMenuDomain menu_id(Integer menu_id){
        this.menu_id = menu_id;
        return this;
    }
    public TbUcpaasMenuDomain menu_name(String menu_name){
        this.menu_name = menu_name;
        return this;
    }
    public TbUcpaasMenuDomain remark(String remark){
        this.remark = remark;
        return this;
    }
    public TbUcpaasMenuDomain menu_url(String menu_url){
        this.menu_url = menu_url;
        return this;
    }
    public TbUcpaasMenuDomain menu_class(String menu_class){
        this.menu_class = menu_class;
        return this;
    }
    public TbUcpaasMenuDomain menu_type(String menu_type){
        this.menu_type = menu_type;
        return this;
    }
    public TbUcpaasMenuDomain level(Integer level){
        this.level = level;
        return this;
    }
    public TbUcpaasMenuDomain parent_id(String parent_id){
        this.parent_id = parent_id;
        return this;
    }
    public TbUcpaasMenuDomain sort(Integer sort){
        this.sort = sort;
        return this;
    }
    public TbUcpaasMenuDomain status(String status){
        this.status = status;
        return this;
    }
    public TbUcpaasMenuDomain web_id(Integer web_id){
        this.web_id = web_id;
        return this;
    }

    //----------------------------------------------------------------------------------
    public static class Field {
        public static final String MENU_ID = "menu_id";
        public static final String MENU_NAME = "menu_name";
        public static final String REMARK = "remark";
        public static final String MENU_URL = "menu_url";
        public static final String MENU_CLASS = "menu_class";
        public static final String MENU_TYPE = "menu_type";
        public static final String LEVEL = "level";
        public static final String PARENT_ID = "parent_id";
        public static final String SORT = "sort";
        public static final String STATUS = "status";
        public static final String WEB_ID = "web_id";
    }



}