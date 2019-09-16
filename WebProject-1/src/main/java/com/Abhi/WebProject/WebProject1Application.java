package com.Abhi.WebProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class WebProject1Application {

	
	@Bean
	@LoadBalanced
	public RestTemplate RestTemp() {
		
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(WebProject1Application.class, args);
	}

}
