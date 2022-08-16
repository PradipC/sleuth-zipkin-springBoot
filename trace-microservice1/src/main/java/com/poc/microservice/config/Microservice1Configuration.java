package com.poc.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Microservice1Configuration {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
