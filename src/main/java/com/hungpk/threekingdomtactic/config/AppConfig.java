package com.hungpk.threekingdomtactic.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public static final String SCHEMA = "public";

    @Bean
    public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
