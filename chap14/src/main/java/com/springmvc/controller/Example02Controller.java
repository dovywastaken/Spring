package com.springmvc.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class Example02Controller 
{
	@GetMapping("/json")
	public String showForm() 
	{
		System.out.println("json으로 매핑됨");
		return "webpage14_02";
	}
		
	@PostMapping("/test")
	public void submit(@RequestBody HashMap<String, Object> map) 
	{
		System.out.println("test로 매핑됨");
		System.out.println(map);
	}
}
