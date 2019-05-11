package com.infly.springcloudconsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsulApplication.class, args);
	}

}
