package com.edhaut.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.StudentAnswer;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
	
	@Procedure("create_userRoutines")
	public void insertdata(String actionType,String actionValue);
	
	Boolean existsByEmail(String email);
	
	Student findByEmail(String email);
	
	Student findBystudentId(String studentId);
	

	
	

}
