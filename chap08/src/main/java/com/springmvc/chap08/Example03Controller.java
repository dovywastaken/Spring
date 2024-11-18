package com.springmvc.chap08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example03Controller 
{
	@GetMapping("/exam03")
	public String requestMethod(Model model) 
	{
		return "webpage08_03";
	}
	
	
	@GetMapping("/admin/tag")
	public String requestMethod2(Model model) 
	{
		return "webpage08_03";
	}
}
