package com.gyc.wenjuan.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyc.wenjuan.core.page.MybatisPageHelper;
import com.gyc.wenjuan.core.page.PageRequest;
import com.gyc.wenjuan.core.page.PageResult;
import com.gyc.wenjuan.core.page.ColumnFilter;

import com.gyc.wenjuan.admin.model.FuncQuestionnaire;
import com.gyc.wenjuan.admin.dao.FuncQuestionnaireMapper;
import com.gyc.wenjuan.admin.service.FuncQuestionnaireService;

/**
 * ---------------------------
 * 问卷 (FuncQuestionnaireServiceImpl)         
 * ---------------------------
 * 作者：  郭永聪
 * 时间：  2020-06-11 
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
		String userId = getColumnFilterValue(pageRequest, "userId");
		PageResult result = null;
		if(userId != null) {
			Long uid = Long.valueOf(userId);
			result = MybatisPageHelper.findPage(pageRequest, funcQuestionnaireMapper, "findPageByUserId", uid);
		}else{
			result = MybatisPageHelper.findPage(pageRequest, funcQuestionnaireMapper);
		}
		// //查询问卷的题目和选项
		// for (FuncQuestionnaire q : (List<FuncQuestionnaire>)result.getContent()) {
		//  	q = this.findById(q.getId());
		// }
		return result;
	}

	/**
	 * 获取过滤字段的值
	 * @param filterName
	 * @return
	 */
	public String getColumnFilterValue(PageRequest pageRequest, String filterName) {
		String value = null;
		ColumnFilter columnFilter = pageRequest.getColumnFilter(filterName);
		if(columnFilter != null) {
			value = columnFilter.getValue();
		}
		return value;
	}
	
}
