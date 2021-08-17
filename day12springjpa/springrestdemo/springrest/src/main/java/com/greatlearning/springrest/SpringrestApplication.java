package com.greatlearning.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//import com.greatlearning.Repsitory.FieldGroupRepository;
//import com.greatlearning.Repsitory.TextRepository;
import com.greatlearning.springrest.entity.FieldGroup;
import com.greatlearning.springrest.entity.Text;



@SpringBootApplication
public class SpringrestApplication extends SpringBootServletInitializer {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder appliation) {
		return appliation.sources(SpringrestApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringrestApplication.class, args);
		
	}

}
