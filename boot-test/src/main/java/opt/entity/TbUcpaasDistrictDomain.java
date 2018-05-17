package opt.entity;

import java.time.LocalDateTime;
/**
* Created by Administrator on 2017-10-31 11:49:19
* 该类由代码生成工具生成，只替换不要修改
* 如果需要拓展该类，请使用继承
* 对应表：test.tb_ucpaas_district
*/
public class TbUcpaasDistrictDomain {

    private Integer id;//

    private Integer cityId;//

    private String name;//

    private String postCode;//



    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    public void setCityId(Integer cityId){
        this.cityId = cityId;
    }
    public Integer getCityId(){
        return this.cityId;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPostCode(String postCode){
        this.postCode = postCode;
    }
    public String getPostCode(){
        return this.postCode;
    }

    //------------------------------------------------------------------------------
    public TbUcpaasDistrictDomain id(Integer id){
        this.id = id;
        return this;
    }
    public TbUcpaasDistrictDomain cityId(Integer cityId){
        this.cityId = cityId;
        return this;
    }
    public TbUcpaasDistrictDomain name(String name){
        this.name = name;
        return this;
    }
    public TbUcpaasDistrictDomain postCode(String postCode){
        this.postCode = postCode;
        return this;
    }

    //----------------------------------------------------------------------------------
    public static class Field {
        public static final String ID = "id";
        public static final String CITYID = "cityId";
        public static final String NAME = "name";
        public static final String POSTCODE = "postCode";
    }



}