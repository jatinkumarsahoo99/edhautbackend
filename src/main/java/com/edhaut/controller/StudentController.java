package com.edhaut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.Student;
import com.edhaut.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@PostMapping("/user")
	public JsonResponse<Object> saveExpenseDetails(@Valid @RequestBody Student user) {
		System.out.println("Printing the user details:: "+ user);
		
		JsonResponse<Object> resp  = studentService.createStudent(user);
	  	
	  	return resp;
		
	}

}
