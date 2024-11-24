package com.ruoyi.contact.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 通讯录对象 contact_info
 *
 * @author ruoyi
 * @date 2024-11-24
 */
public class ContactInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表ID */
    private Long contactId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 社交账号 */
    @Excel(name = "社交账号")
    private String socialAccount;

    /** 联系电话1 */
    @Excel(name = "联系电话1")
    private String phoneNumber1;

    /** 联系电话2 */
    @Excel(name = "联系电话2")
    private String phoneNumber2;

    /** 电子邮件 */
    @Excel(name = "电子邮件")
    private String email;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 是否常用 */
    private String oftenFlag;

    public void setContactId(Long contactId)
    {
        this.contactId = contactId;
    }

    public Long getContactId()
    {
        return contactId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setSocialAccount(String socialAccount)
    {
        this.socialAccount = socialAccount;
    }

    public String getSocialAccount()
    {
        return socialAccount;
    }
    public void setPhoneNumber1(String phoneNumber1)
    {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber1()
    {
        return phoneNumber1;
    }
    public void setPhoneNumber2(String phoneNumber2)
    {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getPhoneNumber2()
    {
        return phoneNumber2;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setOftenFlag(String oftenFlag)
    {
        this.oftenFlag = oftenFlag;
    }

    public String getOftenFlag()
    {
        return oftenFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contactId", getContactId())
            .append("name", getName())
            .append("socialAccount", getSocialAccount())
            .append("phoneNumber1", getPhoneNumber1())
            .append("phoneNumber2", getPhoneNumber2())
            .append("email", getEmail())
            .append("address", getAddress())
            .append("oftenFlag", getOftenFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
