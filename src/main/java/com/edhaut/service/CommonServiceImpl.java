package com.edhaut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.ClassName;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.repository.ClassRepo;
import com.edhaut.mysql.repository.StudentRepo;


@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private ClassRepo classrepo;
	
	@Override
	public JsonResponse<Object> createClass(ClassName classname) {
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_name='" + classname.getClassName() + "',@p_strength='" + classname.getClassStrength()+ "';";

	          System.out.println("VALUES" + values);
	          
	          
	          if (classrepo.existsByClassName(classname.getClassName())) {
	        	  resp.setCode("failed");
	        	  resp.setMessage("Class already register");
	        	  return resp;
//	  			throw new ItemExistsException("User is already register with email:"+user.getEmail());
	  		}else {
	  			classrepo.insertdata("create_user",values);
    		  resp.setCode("sucess");
        	  resp.setMessage("Data saved successfully");
	  		}
	          
	          
	          
	          
		}catch(Exception e) {
			 resp.setCode("failed");
       	  resp.setMessage("Something went wrong");
		}
		
		
		
		return resp;
	}

	@Override
	public JsonResponse<ClassName> GetClassDetails(String classId) {
		
		
		  JsonResponse<ClassName> resp = new JsonResponse<ClassName>();
		  
		  try {
			  ClassName classes = classrepo.findByClassId(classId);
			  if (classes == null) {
		            // User ID not found
		        	resp.setCode("failed");
		        	resp.setMessage("Classes not found");
//		        	user.setPassword("");
//		        	resp.setBody(user);
		            return resp;
		        }
			    resp.setCode("success");
		    	resp.setMessage("Data Fetched Successfully");
		    	resp.setBody(classes);
		  }catch(Exception e) {
				resp.setCode("failed");
	        	resp.setMessage("Classes not found");
		  }
		  
		  return resp;
	}

	@Override
	public JsonResponse<List<ClassName>> GetAllClasses() {
		 JsonResponse<List<ClassName>> resp = new JsonResponse<List<ClassName>>();
		try {
			List<ClassName> classes = (List<ClassName>) classrepo.findAll();
			
			resp.setCode("success");
	    	resp.setMessage("Data Fetched Successfully");
	    	resp.setBody(classes);
		}catch(Exception e){
			resp.setCode("failed");
        	resp.setMessage("Classes not found");
		}
		
		return resp;
	}

}
