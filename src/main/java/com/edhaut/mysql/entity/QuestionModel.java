package com.edhaut.mysql.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_question")
public class QuestionModel {
	
	
	private String questionName;
	
	

	@Id
	/*
	 * @GeneratedValue(generator = "uuid")
	 * 
	 * @GenericGenerator(name = "uuid", strategy = "uuid2")
	 */
	@PersistenceContext(unitName = "entityManagerFactory")
	@Column(name = "questionId")
	private String questionId;
	
	public String getQuestionName() {
		return questionName;
	}


	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}


	public String getQuestionId() {
		return questionId;
	}


	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}


	public String getSerialNo() {
		return serialNo;
	}


	public void setSerialNo(String string) {
		this.serialNo = string;
	}



	public ExamClassModel getTest() {
		return test;
	}


	public void setTest(ExamClassModel test) {
		this.test = test;
	}


	public List<QuestionOptionModel> getChoices() {
		return choices;
	}


	public void setChoices(List<QuestionOptionModel> choices) {
		this.choices = choices;
	}


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String serialNo;
	
	
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "examId")
    private ExamClassModel test;
	
	
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionOptionModel> choices = new ArrayList<>();
}
