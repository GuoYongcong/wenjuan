/*
* @Author: 郭永聪
* @Date:   2020-06-11
* @Last Modified by:   郭永聪
* @Last Modified time: 2020-06-11
*/
import axios from '../axios'

/*
 * 题目管理模块
 */

// 保存
export const save = (data) => {
    return axios({
        url: '/question/save',
        method: 'post',
        data
    })
}
// 删除
export const batchDelete = (data) => {
    return axios({
        url: '/question/delete',
        method: 'post',
        data
    })
}
// 分页查询
export const findPage = (data) => {
    return axios({
        url: '/question/findPage',
        method: 'post',
        data
    })
}
// 根据问卷编号查询所有题目
export const findAllByQuestionnaireId = (data) => {
    return axios({
        url: '/question/findAllByQuestionnaireId',
        method: 'get',
        data
    })
}


