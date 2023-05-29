package com.edhaut.mysql.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="tbl_stud_exam_answer_question")
public class StudentAnswerQuestion {
	
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

	
	
	public StudentAnswer getTest() {
		return test;
	}

	public void setTest(StudentAnswer test) {
		this.test = test;
	}

	public List<StudentAnswerChoice> getChoices() {
		return choices;
	}

	public void setChoices(List<StudentAnswerChoice> choices) {
		this.choices = choices;
	}

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

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String serialNo;
	
	
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "answerSheetId")
    private StudentAnswer test;
	
	
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<StudentAnswerChoice> choices = new ArrayList<>();

}
