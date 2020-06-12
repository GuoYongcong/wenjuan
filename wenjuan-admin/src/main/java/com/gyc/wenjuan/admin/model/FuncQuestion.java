package com.gyc.wenjuan.admin.model;

/**
 * ---------------------------
 * 题目 (FuncQuestion)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class FuncQuestion {

	/** 题目编号 */
	private Long id;
	/** 问卷编号 */
	private Long questionnaireId;
	/** 题目类型：0表示单选；1表示多选 */
	private Integer type;
	/** 题目标题 */
	private String title;
	/** 题目序号 */
	private Integer no;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

}