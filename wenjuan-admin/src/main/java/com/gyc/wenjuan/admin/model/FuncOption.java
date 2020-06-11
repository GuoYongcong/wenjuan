package com.gyc.wenjuan.model;

/**
 * ---------------------------
 * 选项 (FuncOption)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2020-06-11 16:03:54
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class FuncOption {

	/** 题目编号 */
	private Long questionId;
	/** 选项序号 */
	private Integer no;
	/** 选项内容 */
	private String content;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}