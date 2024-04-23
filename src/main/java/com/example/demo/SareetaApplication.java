package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.demo.Logger.Logger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaRepositories("com.example.demo.model.persistence.repositories")
@EntityScan("com.example.demo.model.persistence")
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class SareetaApplication {
	private static final Logger mylogger = LogManager.getLogger(SareetaApplication.class);

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		mylogger.info("*** E-commerce Application started...");
		SpringApplication.run(SareetaApplication.class, args);
		mylogger.trace("We've just greeted the user!");
		mylogger.debug("We've just greeted the user!");
		mylogger.info("We've just greeted the user!");
		mylogger.warn("We've just greeted the user!");
		mylogger.error("We've just greeted the user!");
		mylogger.fatal("We've just greeted the user!");
	}

	@Bean
	public Logger2 getLogs(){
		return new Logger2();
	}

}
