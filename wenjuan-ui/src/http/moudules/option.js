/*
* @Author: 郭永聪
* @Date:   2020-06-11
* @Last Modified by:   郭永聪
* @Last Modified time: 2020-06-11
*/
import axios from '../axios'

/*
 * 选项管理模块
 */

// 保存
export const save = (data) => {
    return axios({
        url: '/option/save',
        method: 'post',
        data
    })
}
// 删除
export const batchDelete = (data) => {
    return axios({
        url: '/option/delete',
        method: 'post',
        data
    })
}
// 分页查询
export const findPage = (data) => {
    return axios({
        url: '/option/findPage',
        method: 'post',
        data
    })
}
// 根据题目编号查询所有选项
export const findAllByquestionId = (data) => {
    return axios({
        url: '/option/findAllByquestionId',
        method: 'get',
        data
    })
}


