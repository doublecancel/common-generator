package opt.entity;

import org.joda.time.DateTime;

/**
* Created by Administrator on 2017-10-20 15:11:15
* 该类由代码生成工具生成，只替换不要修改
* 如果需要拓展该类，请使用继承
* 对应表：ucpaas.tb_ucpaas_admin
*/
public class TbUcpaasAdminDomain {

    private String sid;//管理员sid

    private String email;//邮箱

    private String password;//密码

    private String mobile;//手机号

    private String realname;//真实姓名

    private String status;//管理员状态：0删除，1正常

    private DateTime create_date;//创建时间

    private DateTime update_date;//更新时间

    private DateTime login_date;//最近登录时间

    private Integer login_count;//登录次数



    public void setSid(String sid){
        this.sid = sid;
    }
    public String getSid(){
        return this.sid;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return this.mobile;
    }
    public void setRealname(String realname){
        this.realname = realname;
    }
    public String getRealname(){
        return this.realname;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setCreate_date(DateTime create_date){
        this.create_date = create_date;
    }
    public DateTime getCreate_date(){
        return this.create_date;
    }
    public void setUpdate_date(DateTime update_date){
        this.update_date = update_date;
    }
    public DateTime getUpdate_date(){
        return this.update_date;
    }
    public void setLogin_date(DateTime login_date){
        this.login_date = login_date;
    }
    public DateTime getLogin_date(){
        return this.login_date;
    }
    public void setLogin_count(Integer login_count){
        this.login_count = login_count;
    }
    public Integer getLogin_count(){
        return this.login_count;
    }



}