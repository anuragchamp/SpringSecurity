package com.test.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
	
	@Bean
	DataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		  driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/mypractice");
		  driverManagerDataSource.setUsername("root");
		  driverManagerDataSource.setPassword("qwerty10");
	   return driverManagerDataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		return new JdbcTemplate(getDataSource());
		
	}

}
