package com.springsecuritylearning;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   //load data from database
	auth.inMemoryAuthentication().withUser("test").password("test123").roles("admin");
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .authorizeRequests()
		    .antMatchers("/hello","/customLogin")
		    .permitAll()
		    .antMatchers("/helloWorld","/bye")
		    .authenticated()
		    .and()
		    .formLogin().loginPage("/customLogin")
		    .and()
		    .httpBasic()
		    .and()
		    .logout();
	}

}
