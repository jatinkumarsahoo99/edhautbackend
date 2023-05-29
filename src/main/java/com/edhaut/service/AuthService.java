package com.edhaut.service;

import java.util.List;
import java.util.Map;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.Student;

public interface AuthService {
	
	JsonResponse<List<Map<String,Object>>>  ValidateUser(String userId,String Password);
	

}
