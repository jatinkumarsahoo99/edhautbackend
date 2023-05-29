package com.edhaut.mysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edhaut.mysql.entity.StudentAnswer;

@Repository
public interface StudentAnswerRepo extends CrudRepository<StudentAnswer, String> {
	

}
