package com.poc.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Microservice3Controller {

	
	@GetMapping(value = "/microservice3")
	public String method3() {
		log.info("Inside method3");
		return "SUCCESS";
	}
	
}
