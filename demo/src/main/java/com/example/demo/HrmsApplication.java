package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.business.abstracts.UsersService;
import com.example.demo.business.concretes.UsersManager;
import com.example.demo.core.abstracts.CheckService;
import com.example.demo.core.concretes.CheckUsers;
import com.example.demo.core.concretes.MernisServiceAdaptor;
import com.example.demo.dataAccess.abstracts.UsersDao;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.entities.concretes.Users;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {
	

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HrmsApplication.class, args);
	


	}
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.example.demo"))              
          .build();                                           
    }
	
	
}
