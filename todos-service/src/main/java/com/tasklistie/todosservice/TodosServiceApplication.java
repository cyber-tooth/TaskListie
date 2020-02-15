package com.tasklistie.todosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TodosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosServiceApplication.class, args);
	}

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

