package com.edhaut.mysql.entity;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
@Entity
@Table(name="tbl_student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@NamedStoredProcedureQuery(name= "create_userRoutines", procedureName = "create_userRoutines",parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class,name = "actionType"),	
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class,name = "actionValue"),
})

public class Student {

	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer Id;
	
	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@PersistenceContext(unitName = "entityManagerFactory")
	@Column(name = "studentId")
	private String studentId;
	
	private String studentName;
	
	@Column(unique = true)
	private String  email;
	
	
	private String userRole;
	
	private String password;
	

	
}
