package com.gyc.wenjuan.dao;

import java.util.List;

import com.gyc.wenjuan.model.FuncQuestionnaire;

/**
 * ---------------------------
 * 问卷 (FuncQuestionnaireMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface FuncQuestionnaireMapper {

	/**
	 * 添加问卷
	 * @param record
	 * @return
	 */
    int add(FuncQuestionnaire record);

    /**
     * 删除问卷
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改问卷
     * @param record
     * @return
     */
    int update(FuncQuestionnaire record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    FuncQuestionnaire findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<FuncQuestionnaire> findPage();
    
}