package com.gmt.myschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gmt.myschool")
@EnableAutoConfiguration
public class MySchoolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySchoolApiApplication.class, args);
	}

}
