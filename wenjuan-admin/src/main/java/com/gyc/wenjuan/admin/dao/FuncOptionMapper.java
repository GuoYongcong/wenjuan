package com.gyc.wenjuan.admin.dao;

import java.util.List;

import com.gyc.wenjuan.admin.model.FuncOption;

/**
 * ---------------------------
 * 选项 (FuncOptionMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 18:34:29
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface FuncOptionMapper {

	/**
	 * 添加选项
	 * @param record
	 * @return
	 */
    int add(FuncOption record);

    /**
     * 删除选项
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改选项
     * @param record
     * @return
     */
    int update(FuncOption record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    FuncOption findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<FuncOption> findPage();

    /**
    * 根据题目编号查询所有选项
    * @param questionId
    * @return
    */  
    List<FuncOption> findAllByquestionId(Long questionId);
    
}