package com.facebookspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.Trainer;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.*"})
public class FacebookspringbootApplication {

	public static void main(String[] args) {
		
		
	ApplicationContext ctx=	SpringApplication.run(FacebookspringbootApplication.class, args);
	Trainer t=ctx.getBean(Trainer.class);
	t.teach();
	}
	
	

}
