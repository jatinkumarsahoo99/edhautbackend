package com.edhaut.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.edhaut.mysql.entity.ExamClassModel;

public interface TestRepository extends JpaRepository<ExamClassModel,String> {
	
	@Query(value = "SELECT * FROM tbl_examination p where p.classId = :classId and p.examDate = :examDate",nativeQuery = true)
	List<ExamClassModel> findTestFilterByDateAndClass(@Param("classId") String classId,@Param("examDate") String examDate);
	

}
