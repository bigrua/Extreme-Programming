package com.ruoyi.contact.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.contact.domain.ContactInfo;
import com.ruoyi.contact.service.IContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 通讯录Controller
 *
 * @author ruoyi
 * @date 2024-11-24
 */
@RestController
@RequestMapping("/contact/contactInfo")
public class ContactInfoController extends BaseController {
    @Autowired
    private IContactInfoService contactInfoService;

    /**
     * 查询通讯录列表
     */
    @PreAuthorize("@ss.hasPermi('contact:contactInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ContactInfo contactInfo) {
        startPage();
        List<ContactInfo> list = contactInfoService.selectContactInfoList(contactInfo);
        return getDataTable(list);
    }

    /**
     * 导出通讯录列表
     */
    @PreAuthorize("@ss.hasPermi('contact:contactInfo:export')")
    @Log(title = "通讯录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ContactInfo contactInfo) {
        List<ContactInfo> list = contactInfoService.selectContactInfoList(contactInfo);
        ExcelUtil<ContactInfo> util = new ExcelUtil<ContactInfo>(ContactInfo.class);
        util.exportExcel(response, list, "通讯录数据");
    }

    /**
     * 获取通讯录详细信息
     */
    @PreAuthorize("@ss.hasPermi('contact:contactInfo:query')")
    @GetMapping(value = "/{contactId}")
    public AjaxResult getInfo(@PathVariable("contactId") Long contactId) {
        return success(contactInfoService.selectContactInfoByContactId(contactId));
    }

    /**
     * 新增通讯录
     */
    @PreAuthorize("@ss.hasPermi('contact:contactInfo:add')")
    @Log(title = "通讯录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ContactInfo contactInfo) {
        return toAjax(contactInfoService.insertContactInfo(contactInfo));
    }

    /**
     * 修改通讯录
     */
    @PreAuthorize("@ss.hasPermi('contact:contactInfo:edit')")
    @Log(title = "通讯录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ContactInfo contactInfo) {
        return toAjax(contactInfoService.updateContactInfo(contactInfo));
    }

    /**
     * 删除通讯录
     */
    @PreAuthorize("@ss.hasPermi('contact:contactInfo:remove')")
    @Log(title = "通讯录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{contactIds}")
    public AjaxResult remove(@PathVariable Long[] contactIds) {
        return toAjax(contactInfoService.deleteContactInfoByContactIds(contactIds));
    }

    /**
     * 删除通讯录
     */
    @PreAuthorize("@ss.hasPermi('contact:contactInfo:remove')")
    @Log(title = "通讯录", businessType = BusinessType.DELETE)
    @PutMapping("/{contactIds}")
    public AjaxResult setOftenContact(@PathVariable Long[] contactIds) {
        return toAjax(contactInfoService.setOftenContact(contactIds));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response) {
        ExcelUtil<ContactInfo> util = new ExcelUtil<>(ContactInfo.class);
        util.importTemplateExcel(response, "通讯录数据");
    }

    @Log(title = "导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file) throws Exception {
        ExcelUtil<ContactInfo> util = new ExcelUtil<>(ContactInfo.class);
        List<ContactInfo> contactList = util.importExcel(file.getInputStream());
        contactInfoService.batchInsertContactInfo(contactList);
        return success();
    }

}
