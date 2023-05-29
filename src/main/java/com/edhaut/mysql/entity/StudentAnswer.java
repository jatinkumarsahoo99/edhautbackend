package com.edhaut.mysql.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_stud_exam_answer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentAnswer {
	
	public String getAnswerSheetId() {
		return answerSheetId;
	}

	public void setAnswerSheetId(String answerSheetId) {
		this.answerSheetId = answerSheetId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
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

	public String getSecureMark() {
		return secureMark;
	}

	public void setSecureMark(String secureMark) {
		this.secureMark = secureMark;
	}

	@Id
	/*
	 * @GeneratedValue(generator = "uuid")
	 * 
	 * @GenericGenerator(name = "uuid", strategy = "uuid2")
	 */
	@PersistenceContext(unitName = "entityManagerFactory")
	@Column(name = "answerSheetId")
	private String answerSheetId;
	
	private String testName;
	
	private String testId;
	
	private String createdDate;
	
	private String topic;
	
	private String examDuration;
	
	private String tpotalMark;
	
	private String individualMark;
	
	private String className;
	
	private String classId;

	private String examDate;
	
	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public List<StudentAnswerQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<StudentAnswerQuestion> questions) {
		this.questions = questions;
	}

	private String secureMark;
	
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<StudentAnswerQuestion> questions = new ArrayList<>();
	
	
	
	
	
	

}
