package com.lcwd.holtel.HotelService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class GlobalExceptionHandler {

	@RestControllerAdvice
	public class GlobalExceptionalHandler {

		 
		 
		 @ExceptionHandler(ResourceNotFoundException.class)
		    public ResponseEntity<String> handleProductNotFoundException(Exception e)
		    {
		        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		        return responseEntity;
		    }
	}
}
