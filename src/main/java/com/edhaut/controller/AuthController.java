package com.edhaut.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.Student;
import com.edhaut.service.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@GetMapping("api/new-login")
	public JsonResponse<List<Map<String,Object>>> Login(@RequestParam String email,@RequestParam String password){
		
		return authService.ValidateUser(email, password);
	}

}
