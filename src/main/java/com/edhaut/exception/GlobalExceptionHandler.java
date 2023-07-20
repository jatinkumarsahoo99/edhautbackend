package com.edhaut.exception;


import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.edhaut.common.ErrorObject;
import com.edhaut.common.JsonResponse;





@RestControllerAdvice 
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		errorObject.setMessage(ex.getMessage());
		
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
		
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
		errorObject.setMessage(ex.getMessage());
		
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<JsonResponse> handleGeneralException(Exception ex, WebRequest request) {
		JsonResponse<Object> resp = new JsonResponse<Object>();
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		errorObject.setMessage(ex.getMessage());
		
		errorObject.setTimestamp(new Date());
		
		resp.setCode("failed");
    	  resp.setMessage("Something went wrong");
    	  resp.setBody(errorObject);
		
		
		return new ResponseEntity<JsonResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ItemExistsException.class)
	public ResponseEntity<JsonResponse> handleItemExistsException(ItemExistsException ex, WebRequest request) {
		JsonResponse<Object> resp = new JsonResponse<Object>();
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.CONFLICT.value());
		
		errorObject.setMessage(ex.getMessage());
		
		errorObject.setTimestamp(new Date());
		
		  resp.setCode("failed");
      	  resp.setMessage("Something went wrong");
      	  resp.setBody(errorObject);
		
		return new ResponseEntity<JsonResponse>(resp, HttpStatus.CONFLICT);
	}
	
	@Override
	@Nullable
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	Map<String, Object> body = new HashMap<String, Object>();
	JsonResponse<Object> resp = new JsonResponse<Object>();
		
		body.put("statusCode", HttpStatus.BAD_REQUEST.value());
		
		List<String> errors = ex.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(x -> x.getDefaultMessage())
			.collect(Collectors.toList());
		
		body.put("messages", errors);
		
		body.put("timestamp", new Date());
		
		  resp.setCode("failed");
      	  resp.setMessage("Something went wrong");
      	  resp.setBody(body);
		
		return new ResponseEntity<Object>(resp, HttpStatus.BAD_REQUEST);
	}
}

