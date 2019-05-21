package com.infly.springcloudconsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsulApplication.class, args);
	}

	@RequestMapping("/hello")
	public String Hello(){
		return "Hello";
	}
}
