package com.edhaut.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.ExamClassModel;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.StudentAnswer;
import com.edhaut.mysql.model.TestAnswerSheet;


public interface StudentService {
	
	 JsonResponse<Object> createStudent(Student user);
	 
	 JsonResponse<Student>  ValidateUser(String userId,String Password);
	 
	 JsonResponse<Student>  ProfileDetails(String userId);
	 
	 JsonResponse<Object> submitTest(TestAnswerSheet test);
	 
	 JsonResponse<List<StudentAnswer>> getAllSubmitTest();
	 
	 
	 JsonResponse<Optional<StudentAnswer> > getSubmitTest(String testId);

}
