package com.dec2023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Dec2023Application {

	public static void main(String[] args) {
		SpringApplication.run(Dec2023Application.class, args);
	}

}
