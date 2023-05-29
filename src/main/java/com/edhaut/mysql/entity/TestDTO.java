package com.edhaut.mysql.entity;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TestDTO {
	
	 @NotNull(message = "Test Name should not be null") 
	 @NotBlank(message = "Test name schould not be null")
	  private String testName;
	  
		
		public String getTestName() {
		return testName;
	}


	public void setTestName(String testName) {
		this.testName = testName;
	}


	public String getCorrectChoice() {
		return correctChoice;
	}


	public void setCorrectChoice(String correctChoice) {
		this.correctChoice = correctChoice;
	}


	public String getExamDate() {
		return examDate;
	}


	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}


	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getExamDuration() {
		return examDuration;
	}


	public void setExamDuration(String examDuration) {
		this.examDuration = examDuration;
	}


	public String getTpotalMark() {
		return tpotalMark;
	}


	public void setTpotalMark(String tpotalMark) {
		this.tpotalMark = tpotalMark;
	}


	public String getIndividualMark() {
		return individualMark;
	}


	public void setIndividualMark(String individualMark) {
		this.individualMark = individualMark;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getClassId() {
		return classId;
	}


	public void setClassId(String classId) {
		this.classId = classId;
	}


	public List<QuestionDTO> getQuestions() {
		return questions;
	}


	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}


		private String correctChoice;
		
		private String examDate;
		
		private String createdDate;
		
		private String topic;
		
		private String examDuration;
		
		private String tpotalMark;
		
		private String individualMark;
		
		private String className;
		
		private String classId;
		
		
	  private List<QuestionDTO> questions;
}
