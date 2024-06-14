package com.facebookspringboot.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.facebookspringboot.exception.UserNotFoundException;

@ControllerAdvice
public class HandleException_Demo extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= {UserNotFoundException.class})
	protected  ResponseEntity<String> handleConflict(Exception ex) {
		
		return new ResponseEntity<>(ex.toString(), HttpStatus.BAD_REQUEST);
	      
		    
		        
		    }
	
}
