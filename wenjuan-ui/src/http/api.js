/*
 * 接口统一集成模块
 */
import * as login from './modules/login'
import * as user from './modules/user'
import * as role from './modules/role'
import * as menu from './modules/menu'
import * as questionnaire from './modules/questionnaire'
import * as question from './modules/question'
import * as option from './modules/option'

// 默认全部导出
export default {
    login,
    user,
    role,
    menu,
    questionnaire,
    question,
    option
}
