/*
* @Author: 郭永聪
* @Date:   2020-06-11
* @Last Modified by:   郭永聪
* @Last Modified time: 2020-06-13
*/
import axios from '../axios'

/*
 * 问卷管理模块
 */

// 保存
export const save = (data) => {
    return axios({
        url: '/questionnaire/save',
        method: 'post',
        data
    })
}
// 删除
export const batchDelete = (data) => {
    return axios({
        url: '/questionnaire/delete',
        method: 'post',
        data
    })
}
// 分页查询
export const findPage = (data) => {
    return axios({
        url: '/questionnaire/findPage',
        method: 'post',
        data
    })
}

// 根据问卷编号查询
export const findById = (params) => {
    return axios({
        url: '/questionnaire/findById',
        method: 'get',
        params
    })
}

