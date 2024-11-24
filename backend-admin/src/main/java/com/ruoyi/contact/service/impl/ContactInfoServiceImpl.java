package com.ruoyi.contact.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.contact.domain.ContactInfo;
import com.ruoyi.contact.mapper.ContactInfoMapper;
import com.ruoyi.contact.service.IContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通讯录Service业务层处理
 *
 * @author ruoyi
 * @date 2024-11-24
 */
@Service
public class ContactInfoServiceImpl implements IContactInfoService {
    @Autowired
    private ContactInfoMapper contactInfoMapper;

    /**
     * 查询通讯录
     *
     * @param contactId 通讯录主键
     * @return 通讯录
     */
    @Override
    public ContactInfo selectContactInfoByContactId(Long contactId) {
        return contactInfoMapper.selectContactInfoByContactId(contactId);
    }

    /**
     * 查询通讯录列表
     *
     * @param contactInfo 通讯录
     * @return 通讯录
     */
    @Override
    public List<ContactInfo> selectContactInfoList(ContactInfo contactInfo) {
        return contactInfoMapper.selectContactInfoList(contactInfo);
    }

    /**
     * 新增通讯录
     *
     * @param contactInfo 通讯录
     * @return 结果
     */
    @Override
    public int insertContactInfo(ContactInfo contactInfo) {
        contactInfo.setCreateTime(DateUtils.getNowDate());
        return contactInfoMapper.insertContactInfo(contactInfo);
    }

    /**
     * 批量新增通讯录
     *
     * @param contactList
     */
    @Override
    public int batchInsertContactInfo(List<ContactInfo> contactList) {
        if (!contactList.isEmpty()) {
            for (ContactInfo contactInfo : contactList) {
                contactInfo.setCreateTime(DateUtils.getNowDate());
                contactInfoMapper.insertContactInfo(contactInfo);
            }
        }
        return 0;
    }

    /**
     * 修改通讯录
     *
     * @param contactInfo 通讯录
     * @return 结果
     */
    @Override
    public int updateContactInfo(ContactInfo contactInfo) {
        contactInfo.setUpdateTime(DateUtils.getNowDate());
        return contactInfoMapper.updateContactInfo(contactInfo);
    }

    /**
     * 批量删除通讯录
     *
     * @param contactIds 需要删除的通讯录主键
     * @return 结果
     */
    @Override
    public int deleteContactInfoByContactIds(Long[] contactIds) {
        return contactInfoMapper.deleteContactInfoByContactIds(contactIds);
    }

    /**
     * 设置为常用联系人
     *
     * @param contactIds
     * @return
     */
    @Override
    public int setOftenContact(Long[] contactIds) {
        return contactInfoMapper.setOftenContact(contactIds);
    }

    /**
     * 删除通讯录信息
     *
     * @param contactId 通讯录主键
     * @return 结果
     */
    @Override
    public int deleteContactInfoByContactId(Long contactId) {
        return contactInfoMapper.deleteContactInfoByContactId(contactId);
    }
}
