package com.example.estoque.controllers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.estoque.exceptions.NotFoundException;
import com.example.estoque.exceptions.StandartError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourcesExceptionHandler extends Exception {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandartError> recursoNaoEncontrado(NotFoundException e, HttpServletRequest request) {
		StandartError error = new StandartError();
		error.setTimestamp(Instant.now());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setErro(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<StandartError> recursoDuplicado(NullPointerException e, HttpServletRequest request) {
		StandartError error = new StandartError();
		error.setTimestamp(Instant.now());
		error.setStatusCode(HttpStatus.CONFLICT.value());
		error.setErro("Registro com nome duplicado");
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);

	}
}
	
