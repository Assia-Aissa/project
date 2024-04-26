package com.pfe.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
public class ProjectApplication {

	public static void main(String[] args) {SpringApplication.run(ProjectApplication.class, args);}

	@Bean
    public ModelMapper modelMapper() {
		return new ModelMapper();
	}



}
