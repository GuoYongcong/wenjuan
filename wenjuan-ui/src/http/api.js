/*
 * 接口统一集成模块
 */
import * as login from './moudules/login'
import * as user from './moudules/user'
import * as role from './moudules/role'
import * as menu from './moudules/menu'
import * as questionnaire from './moudules/questionnaire'
import * as question from './moudules/question'
import * as option from './moudules/option'

// 默认全部导出
export default {
    login,
    user,
    role,
    menu,
    questionnaire
}
