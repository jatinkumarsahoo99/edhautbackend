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
@Table(name = "tbl_multipleChoice")
public class QuestionOptionModel {
	
	@Id
	/*
	 * @GeneratedValue(generator = "uuid")
	 * 
	 * @GenericGenerator(name = "uuid", strategy = "uuid2")
	 */
	@PersistenceContext(unitName = "entityManagerFactory")
	@Column(name = "choiceId")
	private String choiceId;
	
	
	private String choiceName;
	
	private String slNo;
	
	
	@Column(name = "created_at",nullable = false , updatable = false)
	@CreationTimestamp    //it will auto insert on the time of creation 
	private Timestamp createdAt;
	
	
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


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


	public QuestionModel getQuestion() {
		return question;
	}


	public void setQuestion(QuestionModel question) {
		this.question = question;
	}


	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "questionId")
    private QuestionModel question;
	

}
