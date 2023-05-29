package com.edhaut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.ChoiceDTO;
import com.edhaut.mysql.entity.ClassName;
import com.edhaut.mysql.entity.ExamClassModel;
import com.edhaut.mysql.entity.QuestionDTO;
import com.edhaut.mysql.entity.QuestionModel;
import com.edhaut.mysql.entity.QuestionOptionModel;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.Teacher;
import com.edhaut.mysql.entity.TestDTO;
import com.edhaut.mysql.repository.TeacherRepo;
import com.edhaut.mysql.repository.TestRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	 @Autowired 
	 private JdbcTemplate jdbcTemplate;
	 
	 @Autowired 
	 private TestRepository testRepo;
	 
	 @Autowired 
	 private TeacherRepo teacherRepo;

	@Override
	public JsonResponse<Object> createQuestion(TestDTO test) {
		 JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			
			String functionName = "generate_user_id_test"; 
			String testId =
					  jdbcTemplate.queryForObject("SELECT " + functionName + "(?, ?)", String.class,"T","E");
			
			System.out.println(testId);
			
			ExamClassModel testData = new ExamClassModel();
			testData.setExamName(test.getTestName());
			testData.setClassName(test.getClassName());
			testData.setClassId(test.getClassId());
			testData.setCorrectChoice(test.getCorrectChoice());
			testData.setExamDate(test.getExamDate());
			testData.setExamDuration(test.getExamDuration());
			testData.setIndividualMark(test.getIndividualMark());
			testData.setTpotalMark(test.getTpotalMark());
			testData.setTopic(test.getTopic());
			testData.setExamId(testId);
			
			 List<QuestionDTO> questionDTOs = test.getQuestions();
			 
			 for (QuestionDTO questionDTO : questionDTOs) {
				 functionName = "generate_user_id_question";
				 String questionId =
						  jdbcTemplate.queryForObject("SELECT " + functionName + "(?, ?)", String.class,"Q","U");
				 QuestionModel question = new QuestionModel();
		            question.setTest(testData);
		            question.setQuestionName(questionDTO.getQuestionText());
		            question.setSerialNo(questionDTO.getSlNo());
		            question.setQuestionId(questionId);

		            List<ChoiceDTO> choiceDTOs = questionDTO.getChoices();
		            for (ChoiceDTO choiceDTO : choiceDTOs) {
		            	functionName = "generate_user_id_choice";
		            	String choiceId =
		  					  jdbcTemplate.queryForObject("SELECT " + functionName + "(?, ?)", String.class,"C","H");
		            	QuestionOptionModel choice = new QuestionOptionModel();
		                choice.setQuestion(question);
		                choice.setChoiceName(choiceDTO.getChoiceText());
		                choice.setChoiceId(choiceId);
		                
		               
		                question.getChoices().add(choice);
		            }

		            testData.getQuestions().add(question);
		        }
			 testRepo.save(testData);
			  resp.setCode("sucess");
        	  resp.setMessage("Data saved successfully");
			 
		} 
		
		catch(Exception e) {
			System.out.println(e);
			 resp.setCode("failed");
       	  resp.setMessage("Something went wrong");
		}
		
		
		return resp;
	}

	@Override
	public JsonResponse<Student> ValidateUser(String userId, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonResponse<Object> createStudent(Teacher user) {
		String values = "SET @p_email='" + user.getEmail() + "',@p_password='" + user.getPassword()
		+ "',@p_name='" + user.getTeacherName() + "',@p_role='" + "rol002" + "';";

          System.out.println("VALUES" + values);
          JsonResponse<Object> resp = new JsonResponse<Object>();
          if (teacherRepo.existsByEmail(user.getEmail())) {
        	  resp.setCode("failed");
        	  resp.setMessage("User is already register with this email");
        	  return resp;
//  			throw new ItemExistsException("User is already register with email:"+user.getEmail());
  		} try {
  		  teacherRepo.insertdata("create_user",values);
  		  resp.setCode("sucess");
      	  resp.setMessage("Data saved successfully");
        }catch(Exception e) {
        	System.out.print(e);
      	  resp.setCode("failed");
      	  resp.setMessage("Something went wrong");
        }
		
		
		return resp;
          
	}

	@Override
	public JsonResponse<List<ExamClassModel>> getAllTest() {
		 JsonResponse<List<ExamClassModel>> resp = new JsonResponse<List<ExamClassModel>>();
		 
		 try {
			 List<ExamClassModel> test = (List<ExamClassModel>) testRepo.findAll();
			 resp.setCode("success");
		    	resp.setMessage("Data Fetched Successfully");
		    	resp.setBody(test);
		 }catch(Exception e) {
			 resp.setCode("failed");
	         resp.setMessage("Test not found");
		 }
		 
		return resp;
	}

	
	
}
