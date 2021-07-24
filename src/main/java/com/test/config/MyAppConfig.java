package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("com")
public class MyAppConfig  {
	
	public MyAppConfig() {
		// TODO Auto-generated constructor stub
		System.out.println("gg");
	}
	
	@Bean
	InternalResourceViewResolver ViewResolver(){
		System.out.println("called");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	      viewResolver.setPrefix("/WEB-INF/views/");
	      viewResolver.setSuffix(".jsp");
	      return viewResolver;
	}

}
