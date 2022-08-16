package com.poc.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Microservice2Controller {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping(value = "/microservice2")
	public String method2() {
		log.info("Inside method2");
		String baseUrl = "http://localhost:9083/microservice3";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		log.info("The response received by method2 is " + response);
		return response;
	}
	
	
}
