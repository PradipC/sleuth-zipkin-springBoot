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
		return "Hi there! Nice to see you. ...";
	}

	
	
	@GetMapping(value = "/microservice4/delay")
	public String delayMethod() {
		log.info("Inside delayMethod method in Microservice4Controller ");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			log.error("InterruptedException is : "+e.getMessage());
			e.printStackTrace();
		}
		
		
		return "Hi there! wait is over.....";
	}

	
	
}

