package com.poc.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Microservice1Controller {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/microservice1")
	public String method1() {
		log.info("Inside method1");
		String baseUrl = "http://localhost:9082/microservice2";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		log.info("The response received by method1 is " + response);
		return response;
	}
	
	
	@GetMapping(value = "/microservice1/circuit-breaker")
	public String cbMethod1() {
		
		log.info("Inside circuit breaker method in Microservice1Controller ");
		String baseUrl = "http://localhost:9082/microservice2/circuit-breaker";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		log.info("The response received by circuit breaker  method is " + response);
		return response;
		
	}
	
	
	@GetMapping(value = "/microservice1/circuit-breaker/retry")
	public String cbMethod1Retry() {
		
		log.info("Inside circuit breaker retry in Microservice1Controller ");
		String baseUrl = "http://localhost:9082/microservice2/circuit-breaker/retry";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		log.info("The response received by circuit breaker retry method is " + response);
		return response;
		
	}
	
	
	@GetMapping(value = "/microservice1/delay")
	public String delayMethod() {
		
		log.info("Inside delayMethod method in Microservice1Controller ");
		String baseUrl = "http://localhost:9082/microservice2/delay";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		log.info("The response received by delay method is " + response);
		return response;
		
	}
	
	
}
