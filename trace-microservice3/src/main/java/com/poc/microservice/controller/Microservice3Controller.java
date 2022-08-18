package com.poc.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Microservice3Controller {

	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping(value = "/microservice3")
	public String method3() {
		log.info("Inside method3");
		String baseUrl = "http://localhost:9084/microservice4";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		log.info("The response received by method3 is " + response);
		return response;
	}
	
	
	
	@GetMapping(value = "/microservice3/delay")
	public String delayMethod() {

		log.info("Inside delayMethod method in Microservice3Controller ");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			log.error("InterruptedException is : "+e.getMessage());
			e.printStackTrace();
		}
		
		String baseUrl = "http://localhost:9084/microservice4/delay";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		log.info("The response received by delay method is " + response);
		return response;

	}
	
	
}
