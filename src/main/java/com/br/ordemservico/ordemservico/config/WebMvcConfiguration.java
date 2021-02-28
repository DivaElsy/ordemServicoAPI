package com.br.ordemservico.ordemservico.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

public class WebMvcConfiguration {
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/");
	}
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
}
