package com.edhaut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.ClassName;
import com.edhaut.mysql.entity.Student;
import com.edhaut.service.CommonService;

import jakarta.validation.Valid;

@RestController
public class CommonController {
	
	@Autowired
	private CommonService commsevice;
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@PostMapping("/api/create-class")
	public JsonResponse<Object> createClass(@Valid @RequestBody ClassName className) {
		System.out.println("Printing the user details:: "+ className);
		
		JsonResponse<Object> resp  = commsevice.createClass(className);
	  	
	  	return resp;
		
	}
	
	@GetMapping("api/get-classes")
	public JsonResponse<ClassName> getClassDetails(@RequestParam String classId){
		
		
		/*
		 * String functionName = "generate_user_id"; String result =
		 * jdbcTemplate.queryForObject("SELECT " + functionName + "()", String.class);
		 * 
		 * System.out.print(result);
		 */
		 

		
		return commsevice.GetClassDetails(classId);
	}
	@GetMapping("api/get-All-classes")
	public JsonResponse<List<ClassName>> getallClasses(){
		
		
		return commsevice.GetAllClasses();
		
	}

}
