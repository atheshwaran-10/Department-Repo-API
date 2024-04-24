package com.springexample.springexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringexampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringexampleApplication.class, args);
	}
	@GetMapping("/greet")
	public String doGet()
	{
		return "Hello World";
	}
}
