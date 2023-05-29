package com.edhaut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.ChoiceDTO;
import com.edhaut.mysql.entity.ExamClassModel;
import com.edhaut.mysql.entity.QuestionDTO;
import com.edhaut.mysql.entity.QuestionModel;
import com.edhaut.mysql.entity.QuestionOptionModel;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.Teacher;
import com.edhaut.mysql.entity.TestDTO;
import com.edhaut.mysql.repository.TestRepository;
import com.edhaut.service.TeacherService;

import jakarta.validation.Valid;

@RestController
public class TeacherController {
	
	 @Autowired 
	 private JdbcTemplate jdbcTemplate;
	 
	 @Autowired 
	 private TestRepository testRepo;
	 
	 @Autowired 
	 private TeacherService tescherService;
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@PostMapping("api/question-created")
	public JsonResponse<Object> saveExpenseDetails(@Valid @RequestBody TestDTO test) {
		System.out.println("Printing the user details:: "+ test.getClassName());
		
		
//		JsonResponse<Object> resp  = studentService.createStudent(user);
	  	
	  	return tescherService.createQuestion(test);
		
	}
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@PostMapping("/api/create-teacher")
	public JsonResponse<Object> createTeacher(@Valid @RequestBody Teacher user) {
		System.out.println("Printing the user details:: "+ user);
		
		JsonResponse<Object> resp  = tescherService.createStudent(user);
	  	
	  	return resp;
		
	}
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@GetMapping("/api/get-AllTest")
	public JsonResponse<List<ExamClassModel>> getTest( ) {
		
		return tescherService.getAllTest();
		
	}
}
