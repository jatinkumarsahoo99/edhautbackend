package com.edhaut.mysql.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.Teacher;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, String> {
	
	@Procedure("create_userRoutines_Teacher")
	public void insertdata(String actionType,String actionValue);
	
	Boolean existsByEmail(String email);
	
	Teacher findByEmail(String email);
	
	Teacher findByteacherId(String teacherId);
	
	
	

}
