package com.edhaut.mysql.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_stud_exam_answer_question_choice")
public class StudentAnswerChoice {
	
	@Id

	  @GeneratedValue(generator = "uuid")
	  
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	 
	@PersistenceContext(unitName = "entityManagerFactory")
	@Column(name = "choiceId")
	private String choiceId;

	
	
	public String getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(String choiceId) {
		this.choiceId = choiceId;
	}

	public String getChoiceName() {
		return choiceName;
	}

	public void setChoiceName(String choiceName) {
		this.choiceName = choiceName;
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

	private String choiceName;
	
	private String slNo;
	
	private String correctChoice;
	
	private String selectedChoice;
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	@Column(name = "created_at",nullable = false , updatable = false)
	@CreationTimestamp    //it will auto insert on the time of creation 
	private Timestamp createdAt;
	
	
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

	public StudentAnswerQuestion getQuestion() {
		return question;
	}

	public void setQuestion(StudentAnswerQuestion question) {
		this.question = question;
	}

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "questionId")
    private StudentAnswerQuestion question;

}
