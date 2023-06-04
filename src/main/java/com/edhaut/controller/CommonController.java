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
import com.edhaut.mysql.entity.GroupMessageData;
import com.edhaut.mysql.entity.Student;
import com.edhaut.service.CommonService;
import com.edhaut.service.GroupMessageDataService;

import jakarta.validation.Valid;

@RestController
public class CommonController {
	
	@Autowired
	private CommonService commsevice;
	
	@Autowired
	private GroupMessageDataService groupmsgSer;
	
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
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@PostMapping("/api/post-group-msg")
	public JsonResponse<Object> createSubmitMsg(@Valid @RequestBody GroupMessageData msg) {
		System.out.println("Printing the user details:: "+ msg);
		
		JsonResponse<Object> resp  = groupmsgSer.submitGroupMsg(msg);
	  	
	  	return resp;
		
	}
	@GetMapping("api/get-All-msg")
	public JsonResponse<List<GroupMessageData>> getallMsg(){
		
		
		return groupmsgSer.getAllMsg();
		
	}

}
