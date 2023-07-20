package com.edhaut.mysql.model;

import java.sql.Timestamp;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;

public class AnswerSheetChoice {

	private String choiceText;
	private String correct;
	
	public String getChoiceText() {
		return choiceText;
	}

	public void setChoiceText(String choiceText) {
		this.choiceText = choiceText;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	private String slNo;
	
	public String getChoiceName() {
		return choiceText;
	}

	public void setChoiceName(String choiceName) {
		this.choiceText = choiceName;
	}

	public String getSlNo() {
		return slNo;
	}

	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}

	public String getCorrectChoice() {
		return correctChoice;
	}

	public void setCorrectChoice(String correctChoice) {
		this.correctChoice = correctChoice;
	}

	public String getSelectedChoice() {
		return selectedChoice;
	}

	public void setSelectedChoice(String selectedChoice) {
		this.selectedChoice = selectedChoice;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	private String correctChoice;
	
	private String selectedChoice;
	
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	@Column(name = "created_at",nullable = false , updatable = false)
	@CreationTimestamp    //it will auto insert on the time of creation 
	private Timestamp createdAt;
}
