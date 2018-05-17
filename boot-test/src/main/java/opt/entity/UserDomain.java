package opt.entity;

import java.time.LocalDateTime;
/**
* Created by Administrator on 2017-10-31 11:49:20
* 该类由代码生成工具生成，只替换不要修改
* 如果需要拓展该类，请使用继承
* 对应表：test.user
*/
public class UserDomain {

    private Long id;//

    private String username;//

    private String password;//

    private Integer status;//



    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setStatus(Integer status){
        this.status = status;
    }
    public Integer getStatus(){
        return this.status;
    }

    //------------------------------------------------------------------------------
    public UserDomain id(Long id){
        this.id = id;
        return this;
    }
    public UserDomain username(String username){
        this.username = username;
        return this;
    }
    public UserDomain password(String password){
        this.password = password;
        return this;
    }
    public UserDomain status(Integer status){
        this.status = status;
        return this;
    }

    //----------------------------------------------------------------------------------
    public static class Field {
        public static final String ID = "id";
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
        public static final String STATUS = "status";
    }



}