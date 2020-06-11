package com.gyc.wenjuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;

import com.gyc.wenjuan.model.FuncOption;
import com.gyc.wenjuan.service.FuncOptionService;

/**
 * ---------------------------
 * 选项 (FuncOptionController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("funcOption")
public class FuncOptionController {

	@Autowired
	private FuncOptionService funcOptionService;

	/**
	 * 保存选项
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody FuncOption record) {
		return HttpResult.ok(funcOptionService.save(record));
	}

    /**
     * 删除选项
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<FuncOption> records) {
		return HttpResult.ok(funcOptionService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(funcOptionService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param 