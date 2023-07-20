package com.edhaut.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edhaut.mysql.entity.ClassName;
import com.edhaut.mysql.entity.Student;

@Repository
public interface ClassRepo extends JpaRepository<ClassName, String> {
	
	@Procedure("create_userRoutines_Class")
	public void insertdata(String actionType,String actionValue);
	
	Boolean existsByClassName(String className);
	
	
	ClassName findByClassId(String classId);

}
