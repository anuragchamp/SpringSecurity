package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "hello-world";
	}
	
	@GetMapping("/customLogin")
	public String login() {
		return "login";
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
