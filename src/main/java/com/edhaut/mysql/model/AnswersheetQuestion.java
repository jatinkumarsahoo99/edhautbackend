package com.edhaut.mysql.model;

import java.util.List;

public class AnswersheetQuestion {
	
	private String questionName;
	private String serialNo;
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	private List<AnswerSheetChoice> choices;
	public List<AnswerSheetChoice> getChoices() {
		return choices;
	}
	public void setChoices(List<AnswerSheetChoice> choices) {
		this.choices = choices;
	}
}
