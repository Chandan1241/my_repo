package com.chandan.gradle.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.chandan.gradle")
public class SwaggerBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerBootApplication.class, args);
	}
}
