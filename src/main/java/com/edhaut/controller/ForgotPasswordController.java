package com.edhaut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.Teacher;
import com.edhaut.mysql.repository.StudentRepo;
import com.edhaut.mysql.repository.TeacherRepo;
import com.edhaut.service.ForgotPasswordService;

@RestController
public class ForgotPasswordController {
     
	@Autowired
	TeacherRepo teacherRepol;
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	ForgotPasswordService forgotPasswordService;
	
	@GetMapping("api/forgot-password-validate")
	public JsonResponse<Object> checkValidUser(@RequestParam String email,@RequestParam boolean usertype){
		JsonResponse<Object> res = new JsonResponse<Object>();
		if(usertype) {
			Teacher teac = 	teacherRepol.findByEmail(email);
			if(teac != null) {
				res.setCode("success");
				res.setMessage("Email Id verified");
				return res;
			}else {
				
				res.setCode("fail");
				res.setMessage("Please enter a valid emial id");
				return res;
			}
		}else {
			Student std = studentRepo.findByEmail(email);
			if(std != null) {
				res.setCode("success");
				res.setMessage("Email Id verified");
				return res;
			}else {
				res.setCode("fail");
				res.setMessage("Please enter a valid emial id");
				return res;
			}
		}
		
	}
	@GetMapping("api/forgot-password")
	public JsonResponse<Object> forgotPassword(@RequestParam String email,@RequestParam boolean usertype,
			@RequestParam String newPassword){
		JsonResponse<Object> res = new JsonResponse<Object>();
		if(usertype) {
			res = forgotPasswordService.forgotPasswordTeacher(email, newPassword);
			return res;
		}else {
			res = forgotPasswordService.forgotPasswordStudent(email, newPassword);
			return res;
		}
		
	}
	
}
