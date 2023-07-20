package com.edhaut.mysql.repository;

import java.util.ArrayList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edhaut.mysql.entity.StudentAnswer;

@Repository
public interface StudentAnswerRepo extends JpaRepository<StudentAnswer, String> {
	
      List<StudentAnswer> findBystudentId(String studentId);
	  
	  @Query(value = "SELECT p.testId FROM tbl_stud_exam_answer p where p.studentId = :studentId",nativeQuery = true)
      List<String> findBystudent(@Param("studentId") String studentId);
	  
	  @Query(value = "SELECT * FROM tbl_stud_exam_answer p where p.studentId = :studentId and p.testId = :testId",nativeQuery = true)
      List<StudentAnswer> findBystudentExamId(@Param("studentId") String studentId ,@Param("testId") String testId);
	  
	  @Query(value = "SELECT * FROM tbl_stud_exam_answer p where p.studentId = :studentId",nativeQuery = true)
      List<StudentAnswer> allSubmitedTestfindBystudent(@Param("studentId") String studentId);
}
