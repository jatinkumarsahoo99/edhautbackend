package com.edhaut.service;

import java.util.List;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.ExamClassModel;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.Teacher;
import com.edhaut.mysql.entity.TestDTO;

public interface TeacherService {
	
	 JsonResponse<Object>  createQuestion(TestDTO test);
	 
	 JsonResponse<Student>  ValidateUser(String userId,String Password);
	 
	 JsonResponse<Object> createStudent(Teacher user);
	 
	 JsonResponse<List<ExamClassModel>> getAllTest();

}
