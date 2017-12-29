package com.fco271292;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages="com.fco271292")
@EnableScheduling
@EnableJpaAuditing
public class SbjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbjApplication.class, args);
	}
}
