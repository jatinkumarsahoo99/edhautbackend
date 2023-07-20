package com.edhaut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.Teacher;
import com.edhaut.mysql.repository.StudentRepo;
import com.edhaut.mysql.repository.TeacherRepo;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
	
	@Autowired
	TeacherRepo teacherRepol;
	
	@Autowired
	StudentRepo studentRepo;

	@Override
	public JsonResponse<Object> forgotPasswordStudent(String email, String newPassword) {
		// TODO Auto-generated method stub
		JsonResponse<Object> res = new JsonResponse<Object>();
		Student std = studentRepo.findByEmail(email);
		if(std != null) {
			std.setPassword(newPassword);
			studentRepo.save(std);
			res.setCode("success");
			res.setMessage("Password updated successfully");
			return res;
		}else {
			res.setCode("fails");
			res.setMessage("Something went wrong");
			return res;
		}
	}

	@Override
	public JsonResponse<Object> forgotPasswordTeacher(String email, String newPassword) {
		JsonResponse<Object> res = new JsonResponse<Object>();
		Teacher teac = 	teacherRepol.findByEmail(email);
		if(teac != null) {
			teac.setPassword(newPassword);
			teacherRepol.save(teac);
			res.setCode("success");
			res.setMessage("Password updated successfully");
			return res;
		}else {
			res.setCode("fails");
			res.setMessage("Something went wrong");
			return res;
		}
	}

}
