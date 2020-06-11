package com.gyc.wenjuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.gyc.wenjuan.model.FuncOption;
import com.gyc.wenjuan.dao.FuncOptionMapper;
import com.gyc.wenjuan.service.FuncOptionService;

/**
 * ---------------------------
 * 选项 (FuncOptionServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class FuncOptionServiceImpl implements FuncOptionService {

	@Autowired
	private FuncOptionMapper funcOptionMapper;

	@Override
	public int save(FuncOption record) {
		if(record.