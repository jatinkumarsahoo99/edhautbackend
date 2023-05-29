package com.edhaut.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.Teacher;
import com.edhaut.mysql.repository.StudentRepo;
import com.edhaut.mysql.repository.TeacherRepo;



@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private StudentRepo studentrepo;
	
	 @Autowired 
	 private TeacherRepo teacherRepo;

	@Override
	public JsonResponse<List<Map<String,Object>>> ValidateUser(String userId, String Password) {
	
		JsonResponse<List<Map<String,Object>>> resp = new JsonResponse<List<Map<String,Object>>>();
		  
		  try {
				Student userStudent = studentrepo.findByEmail(userId);
				Teacher userTeacher = teacherRepo.findByEmail(userId);
				if(userStudent != null && userTeacher != null ) {
					
					if (userStudent.getPassword().equals(Password) ||
							userTeacher.getPassword().equals(Password) ) {
						   resp.setCode("success");
					    	resp.setMessage("User fetch Successfully");
					    	List<Map<String,Object>> data =  new ArrayList<Map<String,Object>>();
					    	Map<String,Object> student  = new HashMap<String, Object>();
					    	Map<String,Object> teacher  = new HashMap<String, Object>();
					    	student.put("userId", userStudent.getStudentId());
					    	student.put("email", userStudent.getEmail());
					    	student.put("name", userStudent.getStudentName());
					    	student.put("role", userStudent.getUserRole());
					    	
					    	teacher.put("userId", userTeacher.getTeacherId());
					    	teacher.put("email", userTeacher.getEmail());
					    	teacher.put("name", userTeacher.getTeacherName());
					    	teacher.put("role", userTeacher.getUserRole());
					    	
					    	data.add(teacher);
					    	data.add(student);
					    	
					    	resp.setBody(data);
					}else {
						resp.setCode("failed");
			        	resp.setMessage("Password incorrect");
					}
					
					
				 
			    	
				}else if(userStudent != null) {
					if (userStudent.getPassword().equals(Password)){
						resp.setCode("success");
				    	resp.setMessage("User fetch Successfully");
				    	List<Map<String,Object>> data =  new ArrayList<Map<String,Object>>();
				    	Map<String,Object> student  = new HashMap<String, Object>();
				      	student.put("userId", userStudent.getStudentId());
				    	student.put("email", userStudent.getEmail());
				    	student.put("name", userStudent.getStudentName());
				    	student.put("role", userStudent.getUserRole());
				    	
	                    data.add(student);
				    	
				    	resp.setBody(data);
				    	
					}else {
						resp.setCode("failed");
			        	resp.setMessage("Password incorrect");
					}
					
					
			    	
				}else if( userTeacher != null) {
					if(userTeacher.getPassword().equals(Password)) {
						 resp.setCode("success");
					    	resp.setMessage("User fetch Successfully");
					    	List<Map<String,Object>> data =  new ArrayList<Map<String,Object>>();
					    	Map<String,Object> teacher  = new HashMap<String, Object>();

					    	teacher.put("userId", userTeacher.getTeacherId());
					    	teacher.put("email", userTeacher.getEmail());
					    	teacher.put("name", userTeacher.getTeacherName());
					    	teacher.put("role", userTeacher.getUserRole());
					    	data.add(teacher);
					    	resp.setBody(data);
					}else {
						resp.setCode("failed");
			        	resp.setMessage("Password incorrect");
					}
					
				}else {
					resp.setCode("failed");
		        	resp.setMessage("UserId incorrect");
				}
				
				
				
		  }catch(Exception e) {
			  resp.setCode("failed");
	        	resp.setMessage("Sometbing went wrong");
		  }
		  
		  
		  
		return resp;
	}

}
