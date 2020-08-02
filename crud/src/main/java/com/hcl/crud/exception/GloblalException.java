package com.hcl.crud.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.crud.dto.ErrorResponse;

@ControllerAdvice
public class GloblalException extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {

		if (ex instanceof MethodArgumentNotValidException) {

			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;

			List<String> errorList = exception.getBindingResult()

					.getFieldErrors()

					.stream()

					.map(fieldError -> fieldError.getDefaultMessage())

					.collect(Collectors.toList());

			ErrorResponse errorDetails = new ErrorResponse("this is a message from handler", errorList, 856);

			return super.handleExceptionInternal(ex, errorDetails, headers, status, request);

		}
		return super.handleExceptionInternal(ex, body, headers, status, request);

	}

}
