package com.springsecuritylearning;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   //load data from database
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(getBcryptPasswordEncoder());
      //auth.inMemoryAuthentication().passwordEncode
	
		
		
	}

	
	@Bean
	PasswordEncoder getBcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .authorizeRequests()
		    .antMatchers("/coder").hasAuthority("user")
		    .antMatchers("/admin").hasAuthority("admin")
		    .antMatchers("/hello","/customLogin" , "/signup")
		    .permitAll()
		    .antMatchers("/home","/bye")
		    .authenticated()
		    .and()
		    .formLogin().loginPage("/customLogin")
		    .and()
		    .httpBasic()
		    .and()
		    .logout();
	}

}
