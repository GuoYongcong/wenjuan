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

import com.gyc.wenjuan.admin.model.FuncQuestionnaire;
import com.gyc.wenjuan.admin.service.FuncQuestionnaireService;

/**
 * ---------------------------
 * 问卷 (FuncQuestionnaireController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("questionnaire")
public class FuncQuestionnaireController {

	@Autowired
	private FuncQuestionnaireService funcQuestionnaireService;

	/**
	 * 保存问卷
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody FuncQuestionnaire record) {
        HttpResult result = HttpResult.ok(funcQuestionnaireService.save(record));
        //获取保存之后问卷的编号
        result.setData(record.getId());
		return result;
	}

    /**
     * 删除问卷
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<FuncQuestionnaire> records) {
		return HttpResult.ok(funcQuestionnaireService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(funcQuestionnaireService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(funcQuestionnaireService.findById(id));
	}

}
