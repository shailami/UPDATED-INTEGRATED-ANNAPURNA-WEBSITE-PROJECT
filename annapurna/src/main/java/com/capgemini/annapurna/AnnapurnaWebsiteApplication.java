package com.capgemini.annapurna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient
public class AnnapurnaWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnapurnaWebsiteApplication.class, args);
	}

	@Bean
	//@LoadBalanced
	public RestTemplate passData() {
		return new RestTemplate();
	}

}
