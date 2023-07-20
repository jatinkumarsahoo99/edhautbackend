package com.edhaut.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.edhaut.common.JsonResponse;
import com.edhaut.exception.ItemExistsException;
import com.edhaut.mysql.entity.ChoiceDTO;
import com.edhaut.mysql.entity.ExamClassModel;
import com.edhaut.mysql.entity.QuestionDTO;
import com.edhaut.mysql.entity.QuestionModel;
import com.edhaut.mysql.entity.QuestionOptionModel;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.StudentAnswer;
import com.edhaut.mysql.entity.StudentAnswerChoice;
import com.edhaut.mysql.entity.StudentAnswerQuestion;
import com.edhaut.mysql.model.AnswerSheetChoice;
import com.edhaut.mysql.model.AnswersheetQuestion;
import com.edhaut.mysql.model.TestAnswerSheet;
import com.edhaut.mysql.repository.StudentAnswerRepo;
import com.edhaut.mysql.repository.StudentRepo;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentrepo;
	 @Autowired 
	 private JdbcTemplate jdbcTemplate;
	 
	 @Autowired 
	 private StudentAnswerRepo studentansrpo;

	@Override
	public JsonResponse<Object> createStudent(Student user) {
		String values = "SET @p_email='" + user.getEmail() + "',@p_password='" + user.getPassword()
		+ "',@p_name='" + user.getStudentName() + "',@p_class='" + user.getStudentClass() +
		"',@p_classId='" + user.getStudentClassId() + "',@p_role='" + "rol001" + "';";

          System.out.println("VALUES" + values);
          JsonResponse<Object> resp = new JsonResponse<Object>();
          
          if (studentrepo.existsByEmail(user.getEmail())) {
        	  resp.setCode("failed");
        	  resp.setMessage("User is already register with this email");
        	  return resp;
//  			throw new ItemExistsException("User is already register with email:"+user.getEmail());
  		}
          try {
        	  studentrepo.insertdata("create_user",values);
    		  resp.setCode("sucess");
        	  resp.setMessage("Data saved successfully");
          }catch(Exception e) {
        	  resp.setCode("failed");
        	  resp.setMessage("Something went wrong");
          }
		
		
		return resp;
	}


	@Override
	public JsonResponse<Student> ValidateUser(String userId, String Password) {
		Student user = studentrepo.findByEmail(userId);
		  JsonResponse<Student> resp = new JsonResponse<Student>();
		  
        if (user == null) {
            // User ID not found
        	resp.setCode("failed");
        	resp.setMessage("User not found");
//        	user.setPassword("");
//        	resp.setBody(user);
            return resp;
        }

        if (!user.getPassword().equals(Password)) {
        	resp.setCode("failed");
        	resp.setMessage("Password incorrect");
//        	user.setPassword("");
//        	resp.setBody(user);
            return resp;
        }
        
        resp.setCode("success");
    	resp.setMessage("Successfully");
    	user.setPassword("");
    	resp.setBody(user);
        // User ID and password are valid
        return resp;
    
	}


	@Override
	public JsonResponse<Student> ProfileDetails(String studentId) {
		Student user = studentrepo.findBystudentId(studentId);
		
		  JsonResponse<Student> resp = new JsonResponse<Student>();
		  
	        if (user == null) {
	            // User ID not found
	        	resp.setCode("failed");
	        	resp.setMessage("User not found");
//	        	user.setPassword("");
//	        	resp.setBody(user);
	            return resp;
	        }
	        
	        resp.setCode("success");
	    	resp.setMessage("Data Fetched Successfully");
	    	user.setPassword("");
	    	resp.setBody(user);
	        // User ID and password are valid
	        return resp;
	}


	@Override
	public JsonResponse<Object> submitTest(TestAnswerSheet test) {
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String functionName = "generate_user_id_studentAnswer_test"; 
			String testId =
					  jdbcTemplate.queryForObject("SELECT " + functionName + "(?, ?)", String.class,"T","A");
			
			System.out.println(testId);
			
			StudentAnswer testData = new StudentAnswer();
			testData.setClassName(test.getClassName());
			testData.setClassId(test.getClassId());
			testData.setTpotalMark(test.getTpotalMark());
			testData.setTopic(test.getTopic());
			testData.setTestId(test.getTestId());
			testData.setAnswerSheetId(testId);
			testData.setExamDuration(test.getExamDuration());
			testData.setExamDate(test.getExamDate());
			testData.setTestName(test.getTestName());
			testData.setStudentId(test.getStudentId());
			testData.setTestId(test.getTestId());
		
			
			 List<AnswersheetQuestion> questionDTOs = test.getQuestions();
			 for (AnswersheetQuestion questionDTO : questionDTOs) {
				 functionName = "generate_user_id_studentAnswer_question";
					/*
					 * String questionId = jdbcTemplate.queryForObject("SELECT " + functionName +
					 * "(?, ?)", String.class,"Q","U");
					 */
				 StudentAnswerQuestion question = new StudentAnswerQuestion();
				 question.setTest(testData);
//				 question.setQuestionId(questionId);
				 question.setQuestionName(questionDTO.getQuestionName());
				 question.setSerialNo(questionDTO.getSerialNo());
				 question.setCorrectChoiceNo(questionDTO.getCorrectChoiceNo());
				 
				  List<AnswerSheetChoice> choiceDTOs = questionDTO.getChoices();
				  for (AnswerSheetChoice choiceDTO : choiceDTOs) {
					  functionName = "generate_user_id_studentAnswer_choice";
						/*
						 * String choiceId = jdbcTemplate.queryForObject("SELECT " + functionName +
						 * "(?, ?)", String.class,"C","H");
						 */
		            	
		            	StudentAnswerChoice choice = new StudentAnswerChoice();
//		            	choice.setChoiceId(choiceId);
		            	choice.setChoiceName(choiceDTO.getChoiceName());
		            	choice.setCorrectChoice(choiceDTO.getCorrectChoice());
		            	choice.setQuestion(question);
		            	choice.setSelectedChoice(choiceDTO.getSelectedChoice());
		            	choice.setSlNo(choiceDTO.getSlNo());
		            	
		            	question.getChoices().add(choice);
				  }
				 
				  testData.getQuestions().add(question);
			 }
			 
			  studentansrpo.save(testData);
			  resp.setCode("sucess");
        	  resp.setMessage("Data saved successfully");
		}catch(Exception e) {
			System.out.println(e);
			 resp.setCode("failed");
      	  resp.setMessage("Something went wrong");
		}
		
		
		return resp;
	}


	@Override
	public JsonResponse<List<StudentAnswer>> getAllSubmitTest() {
		
		 JsonResponse<List<StudentAnswer>> resp = new JsonResponse<List<StudentAnswer>>();
		 try {
			 List<StudentAnswer> submitedTest = (List<StudentAnswer>) studentansrpo.findAll() ;
			 resp.setCode("success");
		     resp.setMessage("Data Fetched Successfully");
			 resp.setBody(submitedTest);
		 }catch(Exception e) {
			 resp.setCode("failed");
	         resp.setMessage("Test not found");
		 }
		 
		return resp;
	}


	@Override
	public JsonResponse<Optional<StudentAnswer> > getSubmitTest(String testId) {
		JsonResponse<Optional<StudentAnswer> > resp = new JsonResponse<Optional<StudentAnswer> >();
		try {
			Optional<StudentAnswer> stdSubmitAnswer = studentansrpo.findById(testId) ;
			 resp.setCode("success");
		     resp.setMessage("Data Fetched Successfully");
			 resp.setBody(stdSubmitAnswer);
		}catch(Exception e) {
			 resp.setCode("failed");
	         resp.setMessage("Test not found");
		}
		
		return resp;
	}


	@Override
	public Student findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
