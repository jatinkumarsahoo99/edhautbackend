package com.edhaut.service;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.ExamClassModel;
import com.edhaut.mysql.entity.ScheduledClass;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.Teacher;
import com.edhaut.mysql.entity.TestDTO;

public interface TeacherService {
	
	 JsonResponse<Object>  createQuestion(TestDTO test);
	 
	 JsonResponse<Student>  ValidateUser(String userId,String Password);
	 
	 JsonResponse<Object> createTeacher(Teacher user);
	 
	 JsonResponse<List<ExamClassModel>> getAllTest();
	 
	 JsonResponse<Optional<Teacher>> getTeacherProfile(String teacherId);
	 
	 JsonResponse<Object> createScheduledClass(ScheduledClass scheduledClass);
	 
	 
	 JsonResponse<List<ScheduledClass>> getAllClasses(Date Date);
	 

}
