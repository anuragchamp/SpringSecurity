package com.users.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.security.dto.SignupDto;


@Repository
public class UserRepo implements UsersDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(SignupDto signupDto) {
	
		String udpateUsers = "insert into Users values(? ,?, ?)";
		jdbcTemplate.update(udpateUsers , signupDto.getUsername() , signupDto.getPassword() , 1);

		String udpateAuthorities = "insert into authorities values(? ,?)";
		jdbcTemplate.update(udpateAuthorities , signupDto.getUsername() , "User");

	}

}
