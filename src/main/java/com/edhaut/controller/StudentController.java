package com.edhaut.controller;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edhaut.common.JsonResponse;
import com.edhaut.mysql.entity.ExamClassModel;
import com.edhaut.mysql.entity.ScheduledClass;
import com.edhaut.mysql.entity.Student;
import com.edhaut.mysql.entity.StudentAnswer;
import com.edhaut.mysql.entity.TestDTO;
import com.edhaut.mysql.model.TestAnswerSheet;
import com.edhaut.mysql.repository.StudentAnswerRepo;
import com.edhaut.service.StudentService;
import com.edhaut.service.TeacherService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	 @Autowired 
	 private JdbcTemplate jdbcTemplate;
	 
	 @Autowired 
	 private TeacherService teacherService;
	 
	 @Autowired 
	  private StudentAnswerRepo studentrepo;
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@PostMapping("/api/create-student")
	public JsonResponse<Object> createStudent(@Valid @RequestBody Student user) {
		System.out.println("Printing the user details:: "+ user);
		
		JsonResponse<Object> resp  = studentService.createStudent(user);
	  	
	  	return resp;
		
	}
	
	@GetMapping("api/login")
	public JsonResponse<Student> Login(@RequestParam String email,@RequestParam String password){
		
		return studentService.ValidateUser(email, password);
	}
	
	@GetMapping("api/student-profile")
	public JsonResponse<Student> getProfileDetails(@RequestParam String userId){
		
		
		/*
		 * String functionName = "generate_user_id"; String result =
		 * jdbcTemplate.queryForObject("SELECT " + functionName + "()", String.class);
		 * 
		 * System.out.print(result);
		 */
		 

		
		return studentService.ProfileDetails(userId);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@PostMapping("/api/answer-submited")
	public JsonResponse<Object> saveAnswer(@Valid @RequestBody TestAnswerSheet test) {
		System.out.println("Printing the user details:: "+ test.getClassName());
		
	
	  	
	  	return studentService.submitTest(test);
	}
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@GetMapping("/api/get-AllSubmitTest")
	public JsonResponse<List<StudentAnswer>> getTest( ) {
		
		return studentService.getAllSubmitTest();
		
		
	}
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@GetMapping("/api/get-SubmitTest")
	public JsonResponse<Optional<StudentAnswer>> getTestById( @RequestParam String testId) {
		
		return studentService.getSubmitTest(testId);
		
		
	}
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@GetMapping("/api/get-allClasses")
	public JsonResponse<List<ScheduledClass>> getAllClasses(/*
															 * @RequestParam("date") @DateTimeFormat(pattern =
															 * "yyyy-MM-dd") String dateString,
															 */
			@RequestParam String classId) {
//		Date date = Date.valueOf(dateString);
		System.out.println("dateCheck>>>>>>>>>>>>>>>>>>"+classId.toString());
		return teacherService.getAllClasses(classId);
		
		
	}
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@GetMapping("/api/get-allSubmittedTest")
	public JsonResponse<List<StudentAnswer>> getAllSubmittedTest( @RequestParam("studentId") String studentId ) {
		JsonResponse<List<StudentAnswer>> res = new JsonResponse<List<StudentAnswer>>();
		List<StudentAnswer> data = studentrepo.findBystudentId(studentId) ;
		
		if(data != null && !data.isEmpty()) {
			res.setBody(data);
			res.setCode("success");
			res.setMessage("Data fetch successfully");
			return res;
		}else {
			data = new ArrayList<>();
			res.setBody(data);
			res.setCode("failed");
			res.setMessage("Data fetch successfully");
			return res;
		}
		
	}
	
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@GetMapping("/api/get-onlytestId-allSubmittedTest")
	public JsonResponse<List<String>> getAllSubmittedTestOnlyTestId( @RequestParam("studentId") String studentId ) {
		JsonResponse<List<String>> res = new JsonResponse<List<String>>();
		List<String> data = studentrepo.findBystudent(studentId) ;
		
		if(data != null && !data.isEmpty()) {
			res.setBody(data);
			res.setCode("success");
			res.setMessage("Data fetch successfully");
			return res;
		}else {
			data = new ArrayList<>();
			res.setBody(data);
			res.setCode("success");
			res.setMessage("Data fetch successfully");
			return res;
		}
		
	}
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@GetMapping("/api/get-all-allSubmittedTest")
	public JsonResponse<List<StudentAnswer>> getAllSubmittedTesstByStudentId( @RequestParam("studentId") String studentId ) {
		JsonResponse<List<StudentAnswer>> res = new JsonResponse<List<StudentAnswer>>();
		List<StudentAnswer> data = studentrepo.allSubmitedTestfindBystudent(studentId) ;
		
		if(data != null && !data.isEmpty()) {
			res.setBody(data);
			res.setCode("success");
			res.setMessage("Data fetch successfully");
			return res;
		}else {
			data = new ArrayList<>();
			res.setBody(data);
			res.setCode("success");
			res.setMessage("Data fetch successfully");
			return res;
		}
		
	}
	
	@ResponseStatus(value = HttpStatus.CREATED) // for status code
	@GetMapping("/api/get-SubmitedtestById")
	public JsonResponse<List<StudentAnswer>> getSubmittedTestByTestId( @RequestParam("studentId") String studentId ,
			@RequestParam("examId") String examId ) {
		JsonResponse<List<StudentAnswer>> res = new JsonResponse<List<StudentAnswer>>();
		List<StudentAnswer> data = studentrepo.findBystudentExamId(studentId,examId) ;
		
		if(data != null && !data.isEmpty()) {
			res.setBody(data);
			res.setCode("success");
			res.setMessage("Data fetch successfully");
			return res;
		}else {
			data = new ArrayList<>();
			res.setBody(data);
			res.setCode("success");
			res.setMessage("Data fetch successfully");
			return res;
		}
		
	}

}
