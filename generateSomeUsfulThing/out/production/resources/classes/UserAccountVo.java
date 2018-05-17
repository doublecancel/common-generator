package com.mchain.bourse.service.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mchain.bourse.common.utils.serializer.LDTSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel
public class UserAccountVo {

    @ApiModelProperty("用户账户ID")
    private Integer id;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("账户")
    private String account;

    @ApiModelProperty("锁定状态 ：0正常，1锁定")
    private Integer lockStatus;

    @JsonSerialize(using = LDTSerializer.class)
    @ApiModelProperty(dataType = "string", example = "2018-05-05 12:12:25", value = "注册日期")
    private LocalDateTime registerDate;

    @ApiModelProperty("证件类型")
    private Integer identityType;

    @ApiModelProperty("证件号码")
    private String identityNumber;

    public com.mchain.bourse.service.user.vo.UserAccountVo setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public com.mchain.bourse.service.user.vo.UserAccountVo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public com.mchain.bourse.service.user.vo.UserAccountVo setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getAccount() {
        return account;
    }



    public com.mchain.bourse.service.user.vo.UserAccountVo setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
        return this;
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public com.mchain.bourse.service.user.vo.UserAccountVo setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
}