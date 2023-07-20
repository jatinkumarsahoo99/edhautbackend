package com.edhaut.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.edhaut.mysql.entity.QuestionOptionModel;

public interface ChoiceRepository extends JpaRepository<QuestionOptionModel, String> {

}
