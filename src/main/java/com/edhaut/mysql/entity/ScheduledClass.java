package com.edhaut.mysql.entity;

import java.sql.Date;


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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_scheduled_class")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduledClass {
	
	
	public Date getClassStartDate() {
		return classStartDate;
	}


	public void setClassStartDate(Date classStartDate) {
		this.classStartDate = classStartDate;
	}


	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@PersistenceContext(unitName = "entityManagerFactory")
	@Column(name = "classId")
	private String classId;
	
	private String className;
	
	private String classUrl;
	
	private String teacherName;
	
	private String topic;
	
	private String classPlatform;
	
	private String classDate;
	
	private Date classStartDate;
	
	private String classNameId;
	
	public String getClassNameId() {
		return classNameId;
	}


	public void setClassNameId(String classNameId) {
		this.classNameId = classNameId;
	}


	public String getClassId() {
		return classId;
	}


	public void setClassId(String classId) {
		this.classId = classId;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getClassUrl() {
		return classUrl;
	}


	public void setClassUrl(String classUrl) {
		this.classUrl = classUrl;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getClassPlatform() {
		return classPlatform;
	}


	public void setClassPlatform(String classPlatform) {
		this.classPlatform = classPlatform;
	}


	public String getClassDate() {
		return classDate;
	}


	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}


	public String getClassTime() {
		return classStartTime;
	}


	public void setClassTime(String classTime) {
		this.classStartTime = classTime;
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


	private String classStartTime;
	
	private String classEndTime;
	
	public String getClassStartTime() {
		return classStartTime;
	}


	public void setClassStartTime(String classStartTime) {
		this.classStartTime = classStartTime;
	}


	public String getClassEndTime() {
		return classEndTime;
	}


	public void setClassEndTime(String classEndTime) {
		this.classEndTime = classEndTime;
	}


	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;
	

	@Column(name = "created_at")
	@CreationTimestamp    //it will auto insert on the time of creation 
	private Timestamp createdAt;
	
	
	
	
	
}
