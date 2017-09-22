package opt.entity;

import java.time.LocalDateTime;

/**
* Created by Administrator on 2017-09-22 12:19:06
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
    public void setUserType(String user_type){
        this.user_type = user_type;
    }
    public String getUserType(){
        return this.user_type;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setOauthStatus(String oauth_status){
        this.oauth_status = oauth_status;
    }
    public String getOauthStatus(){
        return this.oauth_status;
    }
    public void setOauthDate(LocalDateTime oauth_date){
        this.oauth_date = oauth_date;
    }
    public LocalDateTime getOauthDate(){
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
    public void setIdType(String id_type){
        this.id_type = id_type;
    }
    public String getIdType(){
        return this.id_type;
    }
    public void setIdNbr(String id_nbr){
        this.id_nbr = id_nbr;
    }
    public String getIdNbr(){
        return this.id_nbr;
    }
    public void setOrgId(String org_id){
        this.org_id = org_id;
    }
    public String getOrgId(){
        return this.org_id;
    }
    public void setLegalPerson(String legal_person){
        this.legal_person = legal_person;
    }
    public String getLegalPerson(){
        return this.legal_person;
    }
    public void setCompanyNbr(String company_nbr){
        this.company_nbr = company_nbr;
    }
    public String getCompanyNbr(){
        return this.company_nbr;
    }
    public void setWebSite(String web_site){
        this.web_site = web_site;
    }
    public String getWebSite(){
        return this.web_site;
    }
    public void setCreateDate(LocalDateTime create_date){
        this.create_date = create_date;
    }
    public LocalDateTime getCreateDate(){
        return this.create_date;
    }
    public void setUpdateDate(LocalDateTime update_date){
        this.update_date = update_date;
    }
    public LocalDateTime getUpdateDate(){
        return this.update_date;
    }
    public void setLoginTimes(Integer login_times){
        this.login_times = login_times;
    }
    public Integer getLoginTimes(){
        return this.login_times;
    }
    public void setRevisability(String revisability){
        this.revisability = revisability;
    }
    public String getRevisability(){
        return this.revisability;
    }
    public void setRandomNbr(String random_nbr){
        this.random_nbr = random_nbr;
    }
    public String getRandomNbr(){
        return this.random_nbr;
    }
    public void setIsContract(Integer is_contract){
        this.is_contract = is_contract;
    }
    public Integer getIsContract(){
        return this.is_contract;
    }
    public void setIsHeavybuyer(Integer is_heavybuyer){
        this.is_heavybuyer = is_heavybuyer;
    }
    public Integer getIsHeavybuyer(){
        return this.is_heavybuyer;
    }
    public void setChannelId(Integer channel_id){
        this.channel_id = channel_id;
    }
    public Integer getChannelId(){
        return this.channel_id;
    }
    public void setAuthType(String auth_type){
        this.auth_type = auth_type;
    }
    public String getAuthType(){
        return this.auth_type;
    }
    public void setAuthId(String auth_id){
        this.auth_id = auth_id;
    }
    public String getAuthId(){
        return this.auth_id;
    }
    public void setIsProxy(Integer is_proxy){
        this.is_proxy = is_proxy;
    }
    public Integer getIsProxy(){
        return this.is_proxy;
    }
    public void setInternRate(Integer intern_rate){
        this.intern_rate = intern_rate;
    }
    public Integer getInternRate(){
        return this.intern_rate;
    }
    public void setChatType(String chat_type){
        this.chat_type = chat_type;
    }
    public String getChatType(){
        return this.chat_type;
    }
    public void setChatNbr(String chat_nbr){
        this.chat_nbr = chat_nbr;
    }
    public String getChatNbr(){
        return this.chat_nbr;
    }
    public void setNational(String national){
        this.national = national;
    }
    public String getNational(){
        return this.national;
    }
    public void setOConType1(String o_con_type1){
        this.o_con_type1 = o_con_type1;
    }
    public String getOConType1(){
        return this.o_con_type1;
    }
    public void setOConNbr1(String o_con_nbr1){
        this.o_con_nbr1 = o_con_nbr1;
    }
    public String getOConNbr1(){
        return this.o_con_nbr1;
    }
    public void setOConType2(String o_con_type2){
        this.o_con_type2 = o_con_type2;
    }
    public String getOConType2(){
        return this.o_con_type2;
    }
    public void setOConNbr2(String o_con_nbr2){
        this.o_con_nbr2 = o_con_nbr2;
    }
    public String getOConNbr2(){
        return this.o_con_nbr2;
    }
    public void setOConType3(String o_con_type3){
        this.o_con_type3 = o_con_type3;
    }
    public String getOConType3(){
        return this.o_con_type3;
    }
    public void setOConNbr3(String o_con_nbr3){
        this.o_con_nbr3 = o_con_nbr3;
    }
    public String getOConNbr3(){
        return this.o_con_nbr3;
    }
    public void setGuide(Integer guide){
        this.guide = guide;
    }
    public Integer getGuide(){
        return this.guide;
    }
    public void setPostAddress(String post_address){
        this.post_address = post_address;
    }
    public String getPostAddress(){
        return this.post_address;
    }
    public void setIsProxyRecordFee(Integer is_proxy_record_fee){
        this.is_proxy_record_fee = is_proxy_record_fee;
    }
    public Integer getIsProxyRecordFee(){
        return this.is_proxy_record_fee;
    }
    public void setUserTag(Integer user_tag){
        this.user_tag = user_tag;
    }
    public Integer getUserTag(){
        return this.user_tag;
    }
    public void setChannelType(Integer channel_type){
        this.channel_type = channel_type;
    }
    public Integer getChannelType(){
        return this.channel_type;
    }
    public void setChannelLeaderId(Long channel_leader_id){
        this.channel_leader_id = channel_leader_id;
    }
    public Long getChannelLeaderId(){
        return this.channel_leader_id;
    }



}