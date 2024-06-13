package com.facebookspringboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Trainer;

@Configuration
public class ProjectConfiguration {
	@Bean
	public Trainer createObject() {
		return new Trainer();
	}
}
