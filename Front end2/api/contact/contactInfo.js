import request from '@/utils/request'

// 查询通讯录列表
export function listContactInfo(query) {
  return request({
    url: '/contact/contactInfo/list',
    method: 'get',
    params: query
  })
}

// 查询通讯录详细
export function getContactInfo(contactId) {
  return request({
    url: '/contact/contactInfo/' + contactId,
    method: 'get'
  })
}

// 新增通讯录
export function addContactInfo(data) {
  return request({
    url: '/contact/contactInfo',
    method: 'post',
    data: data
  })
}

// 修改通讯录
export function updateContactInfo(data) {
  return request({
    url: '/contact/contactInfo',
    method: 'put',
    data: data
  })
}

// 删除通讯录
export function delContactInfo(contactId) {
  return request({
    url: '/contact/contactInfo/' + contactId,
    method: 'delete'
  })
}

// 删除通讯录
export function setOftenContact(contactIds) {
  return request({
    url: '/contact/contactInfo/' + contactIds,
    method: 'put'
  })
}
