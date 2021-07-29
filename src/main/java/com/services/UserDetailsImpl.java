package com.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mbc.dao.UserRepoImpl;
import com.mvc.entity.UserEntity;
import com.springsecuritylearning.MyUser;

@Service
public class UserDetailsImpl implements UserDetailsService {

	
	@Autowired
	UserRepoImpl userRepoImpl;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 UserEntity userEntity = userRepoImpl.findUserByUserName(username);
	     if(userEntity == null) {
	    	 throw new UsernameNotFoundException("user name not found");
	     }

//	     SimpleGrantedAuthority sga = new SimpleGrantedAuthority(userEntity.getRole());
//	     
//	     ArrayList<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();
//	     ga.add(sga);
	     
	     System.out.println(username);
	     System.out.println(userEntity);
	     
	     
	     //return new User(username, userEntity.getPassword(), ga);
	     return new MyUser(username , userEntity.getPassword() , userEntity.getRole());
	    		 
	
	}

}
