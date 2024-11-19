package com.project.hallallocatement.globalExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.hallallocatement.Exception.ExistException;
import com.project.hallallocatement.Exception.InvalidException;
import com.project.hallallocatement.Exception.MailException;
import com.project.hallallocatement.Exception.PassException;



@RestControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler
	public ResponseEntity<Object>mailEx(MailException su)
	{
		return new ResponseEntity<Object>("Invalid Mail",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<Object>PassEx(PassException su)
	{
		System.out.println("reached global exception handling");
		return new ResponseEntity<Object>("Password must be more than Eight characters",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<Object>ExistEx(ExistException su)
	{
		System.out.println("reached global exception handling");
		return new ResponseEntity<Object>("Already exist",HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<Object>ExistEx(InvalidException su)
	{
		System.out.println("reached global exception handling");
		return new ResponseEntity<Object>("Please Sign Up....",HttpStatus.BAD_REQUEST);
	}
	
	
}
















