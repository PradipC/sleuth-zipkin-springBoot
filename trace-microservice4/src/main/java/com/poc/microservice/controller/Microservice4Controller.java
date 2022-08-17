package com.poc.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Microservice4Controller {

	
	@GetMapping(value = "/microservice4")
	public String method4() {
		log.info("Inside method4");
		return "SUCCESS";
	}
	
}
