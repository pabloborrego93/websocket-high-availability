package com.pbg.SocketsDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SocketsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketsDemoApplication.class, args);
	}
	
}
