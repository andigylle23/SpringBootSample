package com.example.demo.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo.model.ExceptionResponse;

// グローバルコード
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	// NOT_FOUNDの場合
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handlerResourceNotFound(final ResourceNotFoundException exception, final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setRequetedURI(request.getRequestURI());
		error.setRequestMethod(request.getMethod());
		
		return error;
	}

}
