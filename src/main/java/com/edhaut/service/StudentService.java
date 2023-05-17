package com.edhaut.service;

import org.springframework.stereotype.Service;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.Student;


public interface StudentService {
	
	 JsonResponse<Object> createStudent(Student user);

}
