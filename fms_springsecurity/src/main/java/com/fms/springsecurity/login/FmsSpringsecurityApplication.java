package com.fms.springsecurity.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fms.springsecurity.login.*,com.fms.entity")
public class FmsSpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsSpringsecurityApplication.class, args);
	}

}
