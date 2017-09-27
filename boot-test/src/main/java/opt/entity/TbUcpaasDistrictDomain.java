package opt.entity;

/**
* Created by Administrator on 2017-09-27 17:37:24
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



}