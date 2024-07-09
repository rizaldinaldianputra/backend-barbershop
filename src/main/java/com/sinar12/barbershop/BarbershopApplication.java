package com.sinar12.barbershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration

public class BarbershopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbershopApplication.class, args);
	}

}
