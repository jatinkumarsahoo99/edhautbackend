package com.edhaut.mysql.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edhaut.mysql.entity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, String> {
	
	@Procedure("create_userRoutines")
	public void insertdata(String actionType,String actionValue);
	
	Boolean existsByEmail(String email);
	

}
