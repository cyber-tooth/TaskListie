package hs.tasklistie.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class })
public class AuthApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() { return new BCryptPasswordEncoder();	}

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
