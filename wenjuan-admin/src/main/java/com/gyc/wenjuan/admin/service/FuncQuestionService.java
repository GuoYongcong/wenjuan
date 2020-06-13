package com.gyc.wenjuan.admin.service;

import java.util.List;

import com.gyc.wenjuan.admin.model.FuncQuestion;
import com.gyc.wenjuan.core.service.CurdService;

/**
 * ---------------------------
 * 题目 (FuncQuestionService)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface FuncQuestionService extends CurdService<FuncQuestion> {

    /**
    * 根据问卷编号查找所有题目
    * @param questionnaireId
    * @return
    */
    List<FuncQuestion> findAllByQuestionnaireId(Long questionnaireId);

     /**
     * 批量保存操作
     * @param records
     * @return
     */
    int save(List<FuncQuestion> records);

}
