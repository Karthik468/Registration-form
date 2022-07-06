package com.loginproject.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.loginproject.login.service.RegisterService;

@SpringBootApplication
public class LoginApplication {
	private final static Logger logger = LoggerFactory.getLogger(LoginApplication.class);
	public static void main(String[] args) {
		logger.info("Main Method");
		SpringApplication.run(LoginApplication.class, args);
	}

}
