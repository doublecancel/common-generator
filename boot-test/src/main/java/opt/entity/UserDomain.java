package opt.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import opt.utils.OptDateDerialize;
import opt.utils.OptDateSerialize;
import opt.utils.OptLocalDateTime;

/**
* Created by Administrator on 2017-09-24 16:20:53
* 该类由代码生成工具生成，只替换不要修改
* 如果需要拓展该类，请使用继承
* 对应表：test.user
*/
public class UserDomain {

    private Long id;//

    private String name;//姓名

    private Integer age;//年龄

    private String gender;//性别

    private String email;//邮箱

    private String phone;//手机号码

    @JsonSerialize(using = OptDateSerialize.class)
    @JsonDeserialize(using = OptDateDerialize.class)
    private OptLocalDateTime create_date;//创建时间

    private Long create_user;//创建者

    @JsonSerialize(using = OptDateSerialize.class)
    @JsonDeserialize(using = OptDateDerialize.class)
    private OptLocalDateTime modify_date;//修改时间

    private Long modify_user;//修改人

    private Integer status;//状态

    private Integer version;//版本



    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public Integer getAge(){
        return this.age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setCreate_date(OptLocalDateTime create_date){
        this.create_date = create_date;
    }
    public OptLocalDateTime getCreate_date(){
        return this.create_date;
    }
    public void setCreate_user(Long create_user){
        this.create_user = create_user;
    }
    public Long getCreate_user(){
        return this.create_user;
    }
    public void setModify_date(OptLocalDateTime modify_date){
        this.modify_date = modify_date;
    }
    public OptLocalDateTime getModify_date(){
        return this.modify_date;
    }
    public void setModify_user(Long modify_user){
        this.modify_user = modify_user;
    }
    public Long getModify_user(){
        return this.modify_user;
    }
    public void setStatus(Integer status){
        this.status = status;
    }
    public Integer getStatus(){
        return this.status;
    }
    public void setVersion(Integer version){
        this.version = version;
    }
    public Integer getVersion(){
        return this.version;
    }



}