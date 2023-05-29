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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_teacher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@NamedStoredProcedureQuery(name= "create_userRoutines_Teacher", procedureName = "create_userRoutines_Teacher",parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class,name = "actionType"),	
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class,name = "actionValue"),
})

public class Teacher {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@PersistenceContext(unitName = "entityManagerFactory")
	@Column(name = "teacherId")
	private String teacherId;
	
	private String teacherName;
	
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	@Column(unique = true)
	private String  email;
	
	
	private String userRole;
	
	@NotBlank(message = "Password schould not be null")
	@NotNull(message = "Password must not be null")
	private String password;

}
