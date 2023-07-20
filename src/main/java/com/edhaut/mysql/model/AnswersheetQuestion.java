package com.edhaut.mysql.model;

import java.util.List;

public class AnswersheetQuestion {
	
	private String questionText;
	private String slNo;
	
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getSlNo() {
		return slNo;
	}
	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}
	String correctChoiceNo;
	public String getCorrectChoiceNo() {
		return correctChoiceNo;
	}
	public void setCorrectChoiceNo(String correctChoiceNo) {
		this.correctChoiceNo = correctChoiceNo;
	}
	public String getQuestionName() {
		return questionText;
	}
	public void setQuestionName(String questionName) {
		this.questionText = questionName;
	}
	public String getSerialNo() {
		return slNo;
	}
	public void setSerialNo(String serialNo) {
		this.slNo = serialNo;
	}
	private List<AnswerSheetChoice> choices;
	public List<AnswerSheetChoice> getChoices() {
		return choices;
	}
	public void setChoices(List<AnswerSheetChoice> choices) {
		this.choices = choices;
	}
}
