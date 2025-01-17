package com.gyc.wenjuan.admin.dao;

import java.util.List;

import com.gyc.wenjuan.admin.model.FuncQuestion;

import org.apache.ibatis.annotations.Param;


/**
 * ---------------------------
 * 题目 (FuncQuestionMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface FuncQuestionMapper {

	/**
	 * 添加题目
	 * @param record
	 * @return
	 */
    int add(FuncQuestion record);

    /**
     * 删除题目
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改题目
     * @param record
     * @return
     */
    int update(FuncQuestion record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    FuncQuestion findById(@Param(value="id") Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<FuncQuestion> findPage();
    
    /**
    * 根据问卷编号查询所有题目
    * @param questionnaireId
    * @return
    */  
    List<FuncQuestion> findAllByQuestionnaireId(@Param(value="questionnaireId")Long questionnaireId);
}