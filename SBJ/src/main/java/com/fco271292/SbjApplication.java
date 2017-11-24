package com.fco271292;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.fco271292")
public class SbjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbjApplication.class, args);
	}
}
