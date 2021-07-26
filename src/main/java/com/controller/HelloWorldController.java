package com.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.security.dto.SignupDto;
import com.users.dao.UserRepo;

@Controller
public class HelloWorldController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/")
	public String homepage(Principal principal , Authentication auth , Model model) {
		
		 String username = principal.getName();
		 
		 Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
		 
		 model.addAttribute("username", username);
		 model.addAttribute("roles", roles);
		
		return "home";
	}

	@GetMapping("/home")
	public String helloWorld() {
		return "home";
	}
	
	@GetMapping("/customLogin")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(@ModelAttribute("singupdto") SignupDto signupDto) {
		return "signup";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "admin";
	}
	@GetMapping("/user")
	public String getUser() {
		return "user";
	}
	
	
	@PostMapping("/process-signup")
	public String processSignup(SignupDto signupDto) {
		System.out.println(signupDto);
		
		signupDto.setPassword(passwordEncoder.encode(signupDto.getPassword()));
		
		System.out.println(passwordEncoder.encode(signupDto.getPassword()));
		
		userRepo.save(signupDto);
		
		return "redirect:/customLogin";
	}
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		System.out.println("working fine");
		return "hello";
	}
	
	@ResponseBody
	@GetMapping("/bye")
	public String bye() {
		System.out.println("gg bye");
		return "byee";
	}
	
	@ResponseBody
	@GetMapping("/test")
	public String test() {
		System.out.println("gg bye");
		return "mytest";
	}
}
