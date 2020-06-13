package com.gyc.wenjuan.admin.service;

import java.util.List;

import com.gyc.wenjuan.admin.model.FuncOption;
import com.gyc.wenjuan.core.service.CurdService;
/**
 * ---------------------------
 * 选项 (FuncOptionService)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 18:34:29
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface FuncOptionService extends CurdService<FuncOption> {
   /**
    * 根据题目编号查找所有选项
    * @param questionId
    * @return
    */
    List<FuncOption> findAllByquestionId(Long questionId);

     /**
     * 批量保存操作
     * @param records
     * @return
     */
    int save(List<FuncOption> records);
}
