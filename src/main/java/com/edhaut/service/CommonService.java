package com.edhaut.service;

import java.util.List;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.ClassName;
import com.edhaut.mysql.entity.Student;

public interface CommonService {
	JsonResponse<Object> createClass(ClassName classname);
	
	JsonResponse<ClassName>  GetClassDetails(String classId);
	
	JsonResponse<List<ClassName>> GetAllClasses();

}
