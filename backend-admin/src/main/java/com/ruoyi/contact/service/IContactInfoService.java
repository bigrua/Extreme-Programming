package com.ruoyi.contact.service;

import com.ruoyi.contact.domain.ContactInfo;

import java.util.List;

/**
 * 通讯录Service接口
 *
 * @author ruoyi
 * @date 2024-11-24
 */
public interface IContactInfoService
{
    /**
     * 查询通讯录
     *
     * @param contactId 通讯录主键
     * @return 通讯录
     */
    public ContactInfo selectContactInfoByContactId(Long contactId);

    /**
     * 查询通讯录列表
     *
     * @param contactInfo 通讯录
     * @return 通讯录集合
     */
    public List<ContactInfo> selectContactInfoList(ContactInfo contactInfo);

    /**
     * 新增通讯录
     *
     * @param contactInfo 通讯录
     * @return 结果
     */
    public int insertContactInfo(ContactInfo contactInfo);

    /**
     * 批量新增通讯录
     */
    public int batchInsertContactInfo(List<ContactInfo> contactList);

    /**
     * 修改通讯录
     *
     * @param contactInfo 通讯录
     * @return 结果
     */
    public int updateContactInfo(ContactInfo contactInfo);

    /**
     * 批量删除通讯录
     *
     * @param contactIds 需要删除的通讯录主键集合
     * @return 结果
     */
    public int deleteContactInfoByContactIds(Long[] contactIds);

    /**
     * 设置为常用联系人
     * @param contactIds
     * @return
     */
    public int setOftenContact(Long[] contactIds);

    /**
     * 删除通讯录信息
     *
     * @param contactId 通讯录主键
     * @return 结果
     */
    public int deleteContactInfoByContactId(Long contactId);
}
