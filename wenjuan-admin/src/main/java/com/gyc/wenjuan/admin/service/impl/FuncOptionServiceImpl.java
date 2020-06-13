package com.gyc.wenjuan.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyc.wenjuan.core.page.MybatisPageHelper;
import com.gyc.wenjuan.core.page.PageRequest;
import com.gyc.wenjuan.core.page.PageResult;

import com.gyc.wenjuan.admin.model.FuncOption;
import com.gyc.wenjuan.admin.dao.FuncOptionMapper;
import com.gyc.wenjuan.admin.service.FuncOptionService;

/**
 * ---------------------------
 * 选项 (FuncOptionServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 18:34:29
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class FuncOptionServiceImpl implements FuncOptionService {

	@Autowired
	private FuncOptionMapper funcOptionMapper;

	@Override
	public int save(FuncOption record) {
		if(record.getId() == null || record.getId() == 0) {
			return funcOptionMapper.add(record);
		}
		return funcOptionMapper.update(record);
	}

	@Override
	public int save(List<FuncOption> records) {
		for(FuncOption record:records) {
			save(record);
		}
		return 1;
	}
	
	@Override
	public int delete(FuncOption record) {
		return funcOptionMapper.delete(record.getId());
	}

	@Override
	public int delete(List<FuncOption> records) {
		for(FuncOption record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public FuncOption findById(Long id) {
		return funcOptionMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, funcOptionMapper);
	}

	@Override
	public List<FuncOption> findAllByquestionId(Long questionId) {
		return funcOptionMapper.findAllByquestionId(questionId);
	}
	
}
