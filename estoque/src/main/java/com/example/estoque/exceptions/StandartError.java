package com.example.estoque.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandartError {
	private Instant timestamp;
	private Integer statusCode ; 
	private String erro ; 
	private String path ; 
	
	

}
