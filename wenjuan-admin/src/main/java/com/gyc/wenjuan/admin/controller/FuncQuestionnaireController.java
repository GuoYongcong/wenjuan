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
import com.gyc.wenjuan.admin.model.FuncQuestion;
import com.gyc.wenjuan.admin.model.FuncOption;

import com.gyc.wenjuan.admin.service.FuncQuestionnaireService;
import com.gyc.wenjuan.admin.service.FuncQuestionService;
import com.gyc.wenjuan.admin.service.FuncOptionService;


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
    @Autowired
    private FuncQuestionService funcQuestionService;
   @Autowired
    private FuncOptionService funcOptionService;

	/**
	 * 保存问卷
	 * @param records
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody FuncQuestionnaire record) {
        //保存问卷信息
        funcQuestionnaireService.save(record);
        //获取问卷的编号
        Long questionnaireId = record.getId();
        //保存题目信息
        List<FuncQuestion> questions = record.getQuestions();
        for(FuncQuestion question : questions ){
            question.setQuestionnaireId(questionnaireId);
        }
        funcQuestionService.save(questions);
        //获取题目的编号,并保存选项信息
        for(FuncQuestion question : questions ){
            List<FuncOption> options = question.getOptions();
            Long questionId = question.getId();
            for (FuncOption option: options) {
                option.setQuestionId(questionId);
            }
            funcOptionService.save(options);
        }
		return HttpResult.ok(1);
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
