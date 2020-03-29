package com.contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactWebApp1Application {
     private static final Logger logger = LoggerFactory.getLogger(ContactWebApp1Application.class);
	public static void main(String[] args) {
		logger.debug("method started");
		SpringApplication.run(ContactWebApp1Application.class, args);
		logger.debug("method ended");
	}

}
