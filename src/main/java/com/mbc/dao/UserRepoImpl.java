package com.mbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.entity.UserEntity;

@Repository
public class UserRepoImpl implements UserRepo {

	@Autowired
	JdbcTemplate jdbc;
	
	public UserEntity findUserByUserName(String username) {
	
		Object[] args = {username};
		UserEntity entity = jdbc.queryForObject("select * from user where username = ?", args, new BeanPropertyRowMapper<UserEntity>(UserEntity.class));
		return entity;
	}

}
