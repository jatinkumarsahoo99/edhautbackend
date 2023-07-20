package com.edhaut.service;

import com.edhaut.common.JsonResponse;

public interface ForgotPasswordService {
	
	JsonResponse<Object> forgotPasswordStudent(String email, String newPassword);
	JsonResponse<Object> forgotPasswordTeacher(String email, String newPassword);
}
