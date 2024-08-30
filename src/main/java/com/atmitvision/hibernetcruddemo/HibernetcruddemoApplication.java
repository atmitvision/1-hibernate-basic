package com.atmitvision.hibernetcruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernetcruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(HibernetcruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return Runner ->{
			System.out.println("My project in now working");
		};
	}

}
