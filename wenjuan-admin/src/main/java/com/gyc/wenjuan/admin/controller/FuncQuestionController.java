package com.gyc.wenjuan.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gyc.wenjuan.core.http.HttpResult;
import com.gyc.wenjuan.core.page.PageRequest;

import com.gyc.wenjuan.admin.model.FuncQuestion;
import com.gyc.wenjuan.admin.service.FuncQuestionService;

/**
 * ---------------------------
 * 题目 (FuncQuestionController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("question")
public class FuncQuestionController {

	@Autowired
	private FuncQuestionService funcQuestionService;

	/**
	 * 保存题目
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody FuncQuestion record) {
		return HttpResult.ok(funcQuestionService.save(record));
	}

    /**
     * 删除题目
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<FuncQuestion> records) {
		return HttpResult.ok(funcQuestionService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(funcQuestionService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(funcQuestionService.findById(id));
	}

    /**
    * 根据问卷编号查询所有题目
    * @param questionnaireId
    * @return
    */
    @GetMapping(value="/findAllByQuestionnaireId")
    public HttpResult findAllByQuestionnaireId(@RequestParam Long questionnaireId) {
        return HttpResult.ok(funcQuestionService.findAllByQuestionnaireId(questionnaireId));
    }
}
