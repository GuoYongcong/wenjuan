package com.gyc.wenjuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.gyc.wenjuan.model.FuncQuestion;
import com.gyc.wenjuan.dao.FuncQuestionMapper;
import com.gyc.wenjuan.service.FuncQuestionService;

/**
 * ---------------------------
 * 题目 (FuncQuestionServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class FuncQuestionServiceImpl implements FuncQuestionService {

	@Autowired
	private FuncQuestionMapper funcQuestionMapper;

	@Override
	public int save(FuncQuestion record) {
		if(record.getId() == null || record.getId() == 0) {
			return funcQuestionMapper.add(record);
		}
		return funcQuestionMapper.update(record);
	}

	@Override
	public int delete(FuncQuestion record) {
		return funcQuestionMapper.delete(record.getId());
	}

	@Override
	public int delete(List<FuncQuestion> records) {
		for(FuncQuestion record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public FuncQuestion findById(Long id) {
		return funcQuestionMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, funcQuestionMapper);
	}
	
}
