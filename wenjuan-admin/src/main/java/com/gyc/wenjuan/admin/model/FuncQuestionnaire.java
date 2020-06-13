package com.gyc.wenjuan.admin.model;

import java.util.List;

/**
 * ---------------------------
 * 问卷 (FuncQuestionnaire)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class FuncQuestionnaire {

	/** 编号 */
	private Long id;
	/** 问卷标题 */
	private String title;
	/** 用户编号 */
	private Long userId;
	/** 问卷状态：0表示未发布；1表示已发布 */
	private Integer state;
	//题目
	private List<FuncQuestion> questions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<FuncQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<FuncQuestion> questions) {
		this.questions = questions;
	}


}