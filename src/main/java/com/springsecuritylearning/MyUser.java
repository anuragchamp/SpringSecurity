package com.springsecuritylearning;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUser implements UserDetails {
	
	String username;
	String password;
	String role;
	
	
	
	

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		ArrayList<GrantedAuthority> gaList = new ArrayList();
		
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(role);
		gaList.add(sga);
		
		return gaList;
	}
public MyUser(String username, String password, String role) {
	super();
	this.username = username;
	this.password = password;
	this.role = role;
}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
