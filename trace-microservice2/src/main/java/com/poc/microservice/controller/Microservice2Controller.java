package com.poc.microservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Microservice2Controller {

	int count =1;
	private static final String CIRCUIT_BREAKER_MICROSERVICE2 = "microservice2";
	private static final String CIRCUIT_BREAKER_MICROSERVICE2_FALLBACK_METHOD = "cbMethod2FallBack";
	private static final String CIRCUIT_BREAKER_MICROSERVICE2_RETRY_FALLBACK_METHOD = "cbMethod2RetryFallBack";

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

	@GetMapping(value = "/microservice2/circuit-breaker")
	@CircuitBreaker(name = CIRCUIT_BREAKER_MICROSERVICE2, fallbackMethod = CIRCUIT_BREAKER_MICROSERVICE2_FALLBACK_METHOD)
	public String cbMethod2() {

		log.info("Inside circuit Breaker method2");
		String baseUrl = "http://localhost:9083/microservice3";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		log.info("The response received by circuit Breaker method2 is " + response);
		return response;

	}

	@GetMapping(value = "/microservice2/circuit-breaker/retry")
	@Retry(name = CIRCUIT_BREAKER_MICROSERVICE2, fallbackMethod = CIRCUIT_BREAKER_MICROSERVICE2_RETRY_FALLBACK_METHOD )
	public String cbMethod2Retry() {

		log.info("Inside circuit Breaker retry method2");
		String baseUrl = "http://localhost:9083/microservice3";
		log.info("retry method called :"+count+" times at "+new Date());
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		log.info("The response received by circuit Breaker retry method2 is " + response);
		return response;

	}

	public String cbMethod2FallBack(Exception e) {
		// This is fallback method of cbMethod2
		return "connection timeout. Please try later .. ";
	}

	public String cbMethod2RetryFallBack(Exception e) {
		// This is fallback method of cbMethod2Retry
		return "connection timeout.Please wait , we retrying again ..";
	}

	

	@GetMapping(value = "/microservice2/delay")
	public String delayMethod() {

		log.info("Inside delayMethod method in Microservice2Controller ");
		String baseUrl = "http://localhost:9083/microservice3/delay";
		log.info("retry method called :"+count+" times at "+new Date());
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		log.info("The response received by delay method is " + response);
		return response;

	}
	
	
}
