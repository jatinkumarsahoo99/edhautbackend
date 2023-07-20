package com.edhaut.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edhaut.mysql.entity.StudentAnswerQuestion;

@Repository
public interface StudentAnswerChoiceRepo extends JpaRepository<StudentAnswerQuestion, String> {

}
