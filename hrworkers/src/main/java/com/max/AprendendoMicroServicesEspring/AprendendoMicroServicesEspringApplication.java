package com.max.AprendendoMicroServicesEspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AprendendoMicroServicesEspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AprendendoMicroServicesEspringApplication.class, args);
	}

}
