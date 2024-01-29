package com.example.estoque.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testdata")
public class Temporario {

	@GetMapping(value = "/data")
	
	public String testador () {
		
		LocalDateTime data = LocalDateTime.now() ;
		DateTimeFormatter dts = DateTimeFormatter.ofPattern("dd/MMM/yyyy HH:mm:ss ") ;
		String dft = data.format(dts);
		return dft; 
		
		
		
	}
	
	
	
}
