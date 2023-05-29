package com.edhaut.mysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.edhaut.mysql.entity.QuestionModel;

public interface QuestionRepository extends CrudRepository<QuestionModel, String> {
	

}
