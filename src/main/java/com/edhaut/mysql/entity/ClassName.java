package com.edhaut.mysql.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_avilable_class")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@NamedStoredProcedureQuery(name= "create_userRoutines_Class", procedureName = "create_userRoutines_Class",parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class,name = "actionType"),	
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class,name = "actionValue"),
})

public class ClassName {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@PersistenceContext(unitName = "entityManagerFactory")
	@Column(name = "classId")
	private String classId;
	
	private String className;
	
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

	public String getClassStrength() {
		return classStrength;
	}

	public void setClassStrength(String classStrength) {
		this.classStrength = classStrength;
	}

	private String classStrength;

}
