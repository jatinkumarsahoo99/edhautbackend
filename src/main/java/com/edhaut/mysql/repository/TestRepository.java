package com.edhaut.mysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.edhaut.mysql.entity.ExamClassModel;

public interface TestRepository extends CrudRepository<ExamClassModel,String> {
	
	

}
