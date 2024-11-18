package com.springmvc.chap08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example02Controller 
{
	

	@GetMapping("/")
	public String defaultMapping(Model model) 
	{
		System.out.println("프로젝트 이름으로 매핑되서 defaultMapping로 들어옴");
		System.out.println("main.jsp 요청");
		return "main";
	}

	@GetMapping("/exam02")
	public String requestMethod(Model model) 
	{
		System.out.println("exam02로 매핑되서 requestMethod로 들어옴");
		System.out.println("webpage08_02.jsp 요청");
		return "webpage08_02";
	}
	
	@GetMapping("/manager/tag")
	public String requestMethod2(Model model) 
	{
		System.out.println("manager/tag로 매핑되서 requestMethod2로 들어옴");
		System.out.println("webpage08_02.jsp 요청");
		return "webpage08_02";
	}
}
