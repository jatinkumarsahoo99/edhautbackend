package com.edhaut.mysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.edhaut.mysql.entity.QuestionOptionModel;

public interface ChoiceRepository extends CrudRepository<QuestionOptionModel, String> {

}
