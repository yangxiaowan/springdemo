package com.yangwan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping("hello")
	public String sayHello(){
		System.out.println("Greetings from Spring Boot!");
		return "Greetings from Spring Boot!";
	}
}
