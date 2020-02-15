package com.tasklistie.todosinfosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.retry.annotation.EnableRetry;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableRetry
@SpringBootApplication
public class TodosInfosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosInfosServiceApplication.class, args);
	}

}
