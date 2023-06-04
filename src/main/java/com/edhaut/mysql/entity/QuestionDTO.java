package com.edhaut.mysql.entity;

import java.util.List;
import java.util.Set;

public class QuestionDTO {
	 private String questionText;
	 private String correctChoiceNo;
	 public String getCorrectChoiceNo() {
		return correctChoiceNo;
	}
	public void setCorrectChoiceNo(String correctChoiceNo) {
		this.correctChoiceNo = correctChoiceNo;
	}
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
	public List<ChoiceDTO> getChoices() {
		return choices;
	}
	public void setChoices(List<ChoiceDTO> choices) {
		this.choices = choices;
	}
	private String slNo;
	    private List<ChoiceDTO> choices;
}
