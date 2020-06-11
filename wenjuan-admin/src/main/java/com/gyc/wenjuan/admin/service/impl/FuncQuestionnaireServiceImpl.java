package com.gyc.wenjuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.gyc.wenjuan.model.FuncQuestionnaire;
import com.gyc.wenjuan.dao.FuncQuestionnaireMapper;
import com.gyc.wenjuan.service.FuncQuestionnaireService;

/**
 * ---------------------------
 * 问卷 (FuncQuestionnaireServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class FuncQuestionnaireServiceImpl implements FuncQuestionnaireService {

	@Autowired
	private FuncQuestionnaireMapper funcQuestionnaireMapper;

	@Override
	public int save(FuncQuestionnaire record) {
		if(record.getId() == null || record.getId() == 0) {
			return funcQuestionnaireMapper.add(record);
		}
		return funcQuestionnaireMapper.update(record);
	}

	@Override
	public int delete(FuncQuestionnaire record) {
		return funcQuestionnaireMapper.delete(record.getId());
	}

	@Override
	public int delete(List<FuncQuestionnaire> records) {
		for(FuncQuestionnaire record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public FuncQuestionnaire findById(Long id) {
		return funcQuestionnaireMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, funcQuestionnaireMapper);
	}
	
}
