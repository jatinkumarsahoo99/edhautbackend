package com.edhaut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edhaut.common.JsonResponse;
import com.edhaut.exception.ItemExistsException;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.repository.StudentRepo;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentrepo;


	@Override
	public JsonResponse<Object> createStudent(Student user) {
		String values = "SET @p_email='" + user.getEmail() + "',@p_password='" + user.getPassword()
		+ "',@p_name='" + user.getStudentName() + "',@p_role='" + "rol001" + "';";

          System.out.println("VALUES" + values);
          JsonResponse<Object> resp = new JsonResponse<Object>();
          
          if (studentrepo.existsByEmail(user.getEmail())) {
        	  resp.setCode("failed");
        	  resp.setMessage("User is already register with this email");
        	  return resp;
//  			throw new ItemExistsException("User is already register with email:"+user.getEmail());
  		}
		
		studentrepo.insertdata("create_user",values);
		  resp.setCode("sucess");
    	  resp.setMessage("Data saved successfully");
		return resp;
	}

}
