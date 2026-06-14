package com.comigo.vem.controllers.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import com.comigo.vem.DTO.CustomError;
import com.comigo.vem.DTO.ValidationError;
import com.comigo.vem.services.exceptions.BookingException;
import com.comigo.vem.services.exceptions.PasswordException;
import com.comigo.vem.services.exceptions.ResourceNotFoundException;
import com.comigo.vem.services.exceptions.RideCanceledException;
import com.comigo.vem.services.exceptions.RideFullException;
import com.comigo.vem.services.exceptions.UserDriverException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(PasswordException.class)
	public ResponseEntity<CustomError> passwordException(PasswordException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(RideCanceledException.class)
	public ResponseEntity<CustomError> rideCanceled(RideCanceledException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(RideFullException.class)
	public ResponseEntity<CustomError> rideFull(RideFullException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError err = new ValidationError(Instant.now(), status.value(), "Erro de validação", request.getRequestURI());
		
		for(FieldError f : e.getBindingResult().getFieldErrors()) {
			err.addError(f.getField(), f.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(HandlerMethodValidationException.class)
	public ResponseEntity<CustomError> handlerMethodValidation(HandlerMethodValidationException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError err = new ValidationError(Instant.now(), status.value(), "Erro de validação", request.getRequestURI());
		

		e.getAllErrors().forEach(p-> 
			err.addError("Parametro", p.getDefaultMessage()));
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(UserDriverException.class)
	public ResponseEntity<CustomError> userDriver(UserDriverException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<CustomError> booking(BookingException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
	
		return ResponseEntity.status(status).body(err);
	}
}
