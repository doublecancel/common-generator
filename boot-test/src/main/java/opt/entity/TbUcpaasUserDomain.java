package opt.entity;

import java.time.LocalDateTime;
/**
* Created by Administrator on 2017-10-31 11:49:20
* 该类由代码生成工具生成，只替换不要修改
* 如果需要拓展该类，请使用继承
* 对应表：test.tb_ucpaas_user
*/
public class TbUcpaasUserDomain {

    private String id;//主账号sid

    private String token;//主账号token

    private String username;//昵称

    private String email;//邮件

    private String password;//密码

    private String user_type;//用户类型1:个人开发者,2:企业开发者，配置tb_ucpaas_params.param_type=user_type

    private String status;//用户状态：0:注册未激活,1:注册完成,2:邮箱已激活,6:关闭,配置tb_ucpaas_params.param_type=user_status

    private String oauth_status;//认证状态：2:待认证,3:证件已认证(正常)4：认证不通过，配置tb_ucpaas_params.param_type=oauth_status

    private LocalDateTime oauth_date;//认证时间

    private String mobile;//手机

    private Integer province;//省编号

    private Integer city;//城市编号

    private String address;//联系地址/公司地址

    private String realname;//真实姓名/公司名称

    private String id_type;//1:身份证,2:护照

    private String id_nbr;//个人需填,证件号码

    private String org_id;//组织机构号

    private String legal_person;//法定代表人(公司需填)

    private String company_nbr;//公司电话

    private String web_site;//公司需填,非必填项

    private LocalDateTime create_date;//

    private LocalDateTime update_date;//

    private Integer login_times;//

    private String revisability;//安全校验1：可以修改资质

    private String random_nbr;//生成子账户的随机4位码

    private Integer is_contract;//是否合约用户1是0否

    private Integer is_heavybuyer;//是否是大客户0:不是大客户1:是大客户

    private Integer channel_id;//渠道id

    private String auth_type;//第三方账号登录的类型，1：明道

    private String auth_id;//第三方账号登录的用户id

    private Integer is_proxy;//是否代理商,0不是,1是

    private Integer intern_rate;//国际费率折扣率

    private String chat_type;//1:QQ,2:gtalk,3:移动应用,4:其他

    private String chat_nbr;//

    private String national;//

    private String o_con_type1;//1:手机号,2:qq,3:gtalk,4:固话

    private String o_con_nbr1;//

    private String o_con_type2;//1:手机号,2:qq,3:gtalk,4:固话

    private String o_con_nbr2;//

    private String o_con_type3;//1:手机号,2:qq,3:gtalk,4:固话

    private String o_con_nbr3;//

    private Integer guide;//新手指引0：显示1：关闭

    private String post_address;//邮寄地址

    private Integer is_proxy_record_fee;//代理商使用录音是否需要扣费0不扣费1扣费

    private Integer user_tag;//开发者标记，0：老开发者；1：新开发者

    private Integer channel_type;//渠道类型

    private Long channel_leader_id;//渠道总表id,tb_ucpaas_channel_leader表id



    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return this.token;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
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
    public void setUser_type(String user_type){
        this.user_type = user_type;
    }
    public String getUser_type(){
        return this.user_type;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setOauth_status(String oauth_status){
        this.oauth_status = oauth_status;
    }
    public String getOauth_status(){
        return this.oauth_status;
    }
    public void setOauth_date(LocalDateTime oauth_date){
        this.oauth_date = oauth_date;
    }
    public LocalDateTime getOauth_date(){
        return this.oauth_date;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return this.mobile;
    }
    public void setProvince(Integer province){
        this.province = province;
    }
    public Integer getProvince(){
        return this.province;
    }
    public void setCity(Integer city){
        this.city = city;
    }
    public Integer getCity(){
        return this.city;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setRealname(String realname){
        this.realname = realname;
    }
    public String getRealname(){
        return this.realname;
    }
    public void setId_type(String id_type){
        this.id_type = id_type;
    }
    public String getId_type(){
        return this.id_type;
    }
    public void setId_nbr(String id_nbr){
        this.id_nbr = id_nbr;
    }
    public String getId_nbr(){
        return this.id_nbr;
    }
    public void setOrg_id(String org_id){
        this.org_id = org_id;
    }
    public String getOrg_id(){
        return this.org_id;
    }
    public void setLegal_person(String legal_person){
        this.legal_person = legal_person;
    }
    public String getLegal_person(){
        return this.legal_person;
    }
    public void setCompany_nbr(String company_nbr){
        this.company_nbr = company_nbr;
    }
    public String getCompany_nbr(){
        return this.company_nbr;
    }
    public void setWeb_site(String web_site){
        this.web_site = web_site;
    }
    public String getWeb_site(){
        return this.web_site;
    }
    public void setCreate_date(LocalDateTime create_date){
        this.create_date = create_date;
    }
    public LocalDateTime getCreate_date(){
        return this.create_date;
    }
    public void setUpdate_date(LocalDateTime update_date){
        this.update_date = update_date;
    }
    public LocalDateTime getUpdate_date(){
        return this.update_date;
    }
    public void setLogin_times(Integer login_times){
        this.login_times = login_times;
    }
    public Integer getLogin_times(){
        return this.login_times;
    }
    public void setRevisability(String revisability){
        this.revisability = revisability;
    }
    public String getRevisability(){
        return this.revisability;
    }
    public void setRandom_nbr(String random_nbr){
        this.random_nbr = random_nbr;
    }
    public String getRandom_nbr(){
        return this.random_nbr;
    }
    public void setIs_contract(Integer is_contract){
        this.is_contract = is_contract;
    }
    public Integer getIs_contract(){
        return this.is_contract;
    }
    public void setIs_heavybuyer(Integer is_heavybuyer){
        this.is_heavybuyer = is_heavybuyer;
    }
    public Integer getIs_heavybuyer(){
        return this.is_heavybuyer;
    }
    public void setChannel_id(Integer channel_id){
        this.channel_id = channel_id;
    }
    public Integer getChannel_id(){
        return this.channel_id;
    }
    public void setAuth_type(String auth_type){
        this.auth_type = auth_type;
    }
    public String getAuth_type(){
        return this.auth_type;
    }
    public void setAuth_id(String auth_id){
        this.auth_id = auth_id;
    }
    public String getAuth_id(){
        return this.auth_id;
    }
    public void setIs_proxy(Integer is_proxy){
        this.is_proxy = is_proxy;
    }
    public Integer getIs_proxy(){
        return this.is_proxy;
    }
    public void setIntern_rate(Integer intern_rate){
        this.intern_rate = intern_rate;
    }
    public Integer getIntern_rate(){
        return this.intern_rate;
    }
    public void setChat_type(String chat_type){
        this.chat_type = chat_type;
    }
    public String getChat_type(){
        return this.chat_type;
    }
    public void setChat_nbr(String chat_nbr){
        this.chat_nbr = chat_nbr;
    }
    public String getChat_nbr(){
        return this.chat_nbr;
    }
    public void setNational(String national){
        this.national = national;
    }
    public String getNational(){
        return this.national;
    }
    public void setO_con_type1(String o_con_type1){
        this.o_con_type1 = o_con_type1;
    }
    public String getO_con_type1(){
        return this.o_con_type1;
    }
    public void setO_con_nbr1(String o_con_nbr1){
        this.o_con_nbr1 = o_con_nbr1;
    }
    public String getO_con_nbr1(){
        return this.o_con_nbr1;
    }
    public void setO_con_type2(String o_con_type2){
        this.o_con_type2 = o_con_type2;
    }
    public String getO_con_type2(){
        return this.o_con_type2;
    }
    public void setO_con_nbr2(String o_con_nbr2){
        this.o_con_nbr2 = o_con_nbr2;
    }
    public String getO_con_nbr2(){
        return this.o_con_nbr2;
    }
    public void setO_con_type3(String o_con_type3){
        this.o_con_type3 = o_con_type3;
    }
    public String getO_con_type3(){
        return this.o_con_type3;
    }
    public void setO_con_nbr3(String o_con_nbr3){
        this.o_con_nbr3 = o_con_nbr3;
    }
    public String getO_con_nbr3(){
        return this.o_con_nbr3;
    }
    public void setGuide(Integer guide){
        this.guide = guide;
    }
    public Integer getGuide(){
        return this.guide;
    }
    public void setPost_address(String post_address){
        this.post_address = post_address;
    }
    public String getPost_address(){
        return this.post_address;
    }
    public void setIs_proxy_record_fee(Integer is_proxy_record_fee){
        this.is_proxy_record_fee = is_proxy_record_fee;
    }
    public Integer getIs_proxy_record_fee(){
        return this.is_proxy_record_fee;
    }
    public void setUser_tag(Integer user_tag){
        this.user_tag = user_tag;
    }
    public Integer getUser_tag(){
        return this.user_tag;
    }
    public void setChannel_type(Integer channel_type){
        this.channel_type = channel_type;
    }
    public Integer getChannel_type(){
        return this.channel_type;
    }
    public void setChannel_leader_id(Long channel_leader_id){
        this.channel_leader_id = channel_leader_id;
    }
    public Long getChannel_leader_id(){
        return this.channel_leader_id;
    }

    //------------------------------------------------------------------------------
    public TbUcpaasUserDomain id(String id){
        this.id = id;
        return this;
    }
    public TbUcpaasUserDomain token(String token){
        this.token = token;
        return this;
    }
    public TbUcpaasUserDomain username(String username){
        this.username = username;
        return this;
    }
    public TbUcpaasUserDomain email(String email){
        this.email = email;
        return this;
    }
    public TbUcpaasUserDomain password(String password){
        this.password = password;
        return this;
    }
    public TbUcpaasUserDomain user_type(String user_type){
        this.user_type = user_type;
        return this;
    }
    public TbUcpaasUserDomain status(String status){
        this.status = status;
        return this;
    }
    public TbUcpaasUserDomain oauth_status(String oauth_status){
        this.oauth_status = oauth_status;
        return this;
    }
    public TbUcpaasUserDomain oauth_date(LocalDateTime oauth_date){
        this.oauth_date = oauth_date;
        return this;
    }
    public TbUcpaasUserDomain mobile(String mobile){
        this.mobile = mobile;
        return this;
    }
    public TbUcpaasUserDomain province(Integer province){
        this.province = province;
        return this;
    }
    public TbUcpaasUserDomain city(Integer city){
        this.city = city;
        return this;
    }
    public TbUcpaasUserDomain address(String address){
        this.address = address;
        return this;
    }
    public TbUcpaasUserDomain realname(String realname){
        this.realname = realname;
        return this;
    }
    public TbUcpaasUserDomain id_type(String id_type){
        this.id_type = id_type;
        return this;
    }
    public TbUcpaasUserDomain id_nbr(String id_nbr){
        this.id_nbr = id_nbr;
        return this;
    }
    public TbUcpaasUserDomain org_id(String org_id){
        this.org_id = org_id;
        return this;
    }
    public TbUcpaasUserDomain legal_person(String legal_person){
        this.legal_person = legal_person;
        return this;
    }
    public TbUcpaasUserDomain company_nbr(String company_nbr){
        this.company_nbr = company_nbr;
        return this;
    }
    public TbUcpaasUserDomain web_site(String web_site){
        this.web_site = web_site;
        return this;
    }
    public TbUcpaasUserDomain create_date(LocalDateTime create_date){
        this.create_date = create_date;
        return this;
    }
    public TbUcpaasUserDomain update_date(LocalDateTime update_date){
        this.update_date = update_date;
        return this;
    }
    public TbUcpaasUserDomain login_times(Integer login_times){
        this.login_times = login_times;
        return this;
    }
    public TbUcpaasUserDomain revisability(String revisability){
        this.revisability = revisability;
        return this;
    }
    public TbUcpaasUserDomain random_nbr(String random_nbr){
        this.random_nbr = random_nbr;
        return this;
    }
    public TbUcpaasUserDomain is_contract(Integer is_contract){
        this.is_contract = is_contract;
        return this;
    }
    public TbUcpaasUserDomain is_heavybuyer(Integer is_heavybuyer){
        this.is_heavybuyer = is_heavybuyer;
        return this;
    }
    public TbUcpaasUserDomain channel_id(Integer channel_id){
        this.channel_id = channel_id;
        return this;
    }
    public TbUcpaasUserDomain auth_type(String auth_type){
        this.auth_type = auth_type;
        return this;
    }
    public TbUcpaasUserDomain auth_id(String auth_id){
        this.auth_id = auth_id;
        return this;
    }
    public TbUcpaasUserDomain is_proxy(Integer is_proxy){
        this.is_proxy = is_proxy;
        return this;
    }
    public TbUcpaasUserDomain intern_rate(Integer intern_rate){
        this.intern_rate = intern_rate;
        return this;
    }
    public TbUcpaasUserDomain chat_type(String chat_type){
        this.chat_type = chat_type;
        return this;
    }
    public TbUcpaasUserDomain chat_nbr(String chat_nbr){
        this.chat_nbr = chat_nbr;
        return this;
    }
    public TbUcpaasUserDomain national(String national){
        this.national = national;
        return this;
    }
    public TbUcpaasUserDomain o_con_type1(String o_con_type1){
        this.o_con_type1 = o_con_type1;
        return this;
    }
    public TbUcpaasUserDomain o_con_nbr1(String o_con_nbr1){
        this.o_con_nbr1 = o_con_nbr1;
        return this;
    }
    public TbUcpaasUserDomain o_con_type2(String o_con_type2){
        this.o_con_type2 = o_con_type2;
        return this;
    }
    public TbUcpaasUserDomain o_con_nbr2(String o_con_nbr2){
        this.o_con_nbr2 = o_con_nbr2;
        return this;
    }
    public TbUcpaasUserDomain o_con_type3(String o_con_type3){
        this.o_con_type3 = o_con_type3;
        return this;
    }
    public TbUcpaasUserDomain o_con_nbr3(String o_con_nbr3){
        this.o_con_nbr3 = o_con_nbr3;
        return this;
    }
    public TbUcpaasUserDomain guide(Integer guide){
        this.guide = guide;
        return this;
    }
    public TbUcpaasUserDomain post_address(String post_address){
        this.post_address = post_address;
        return this;
    }
    public TbUcpaasUserDomain is_proxy_record_fee(Integer is_proxy_record_fee){
        this.is_proxy_record_fee = is_proxy_record_fee;
        return this;
    }
    public TbUcpaasUserDomain user_tag(Integer user_tag){
        this.user_tag = user_tag;
        return this;
    }
    public TbUcpaasUserDomain channel_type(Integer channel_type){
        this.channel_type = channel_type;
        return this;
    }
    public TbUcpaasUserDomain channel_leader_id(Long channel_leader_id){
        this.channel_leader_id = channel_leader_id;
        return this;
    }

    //----------------------------------------------------------------------------------
    public static class Field {
        public static final String ID = "id";
        public static final String TOKEN = "token";
        public static final String USERNAME = "username";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String USER_TYPE = "user_type";
        public static final String STATUS = "status";
        public static final String OAUTH_STATUS = "oauth_status";
        public static final String OAUTH_DATE = "oauth_date";
        public static final String MOBILE = "mobile";
        public static final String PROVINCE = "province";
        public static final String CITY = "city";
        public static final String ADDRESS = "address";
        public static final String REALNAME = "realname";
        public static final String ID_TYPE = "id_type";
        public static final String ID_NBR = "id_nbr";
        public static final String ORG_ID = "org_id";
        public static final String LEGAL_PERSON = "legal_person";
        public static final String COMPANY_NBR = "company_nbr";
        public static final String WEB_SITE = "web_site";
        public static final String CREATE_DATE = "create_date";
        public static final String UPDATE_DATE = "update_date";
        public static final String LOGIN_TIMES = "login_times";
        public static final String REVISABILITY = "revisability";
        public static final String RANDOM_NBR = "random_nbr";
        public static final String IS_CONTRACT = "is_contract";
        public static final String IS_HEAVYBUYER = "is_heavybuyer";
        public static final String CHANNEL_ID = "channel_id";
        public static final String AUTH_TYPE = "auth_type";
        public static final String AUTH_ID = "auth_id";
        public static final String IS_PROXY = "is_proxy";
        public static final String INTERN_RATE = "intern_rate";
        public static final String CHAT_TYPE = "chat_type";
        public static final String CHAT_NBR = "chat_nbr";
        public static final String NATIONAL = "national";
        public static final String O_CON_TYPE1 = "o_con_type1";
        public static final String O_CON_NBR1 = "o_con_nbr1";
        public static final String O_CON_TYPE2 = "o_con_type2";
        public static final String O_CON_NBR2 = "o_con_nbr2";
        public static final String O_CON_TYPE3 = "o_con_type3";
        public static final String O_CON_NBR3 = "o_con_nbr3";
        public static final String GUIDE = "guide";
        public static final String POST_ADDRESS = "post_address";
        public static final String IS_PROXY_RECORD_FEE = "is_proxy_record_fee";
        public static final String USER_TAG = "user_tag";
        public static final String CHANNEL_TYPE = "channel_type";
        public static final String CHANNEL_LEADER_ID = "channel_leader_id";
    }



}