package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController 
{
	@GetMapping("/login")
	public String login() 
	{
		System.out.println("================================================================");
        System.out.println("[LoginController: login으로 매핑되어 컨트롤러로 들어왔습니다]");
        System.out.println("[login.jsp로 이동합니다]");
		return "login";
	}
	
	@GetMapping("/loginfailed")
	public String loginerror(Model model) 
	{
		System.out.println("================================================================");
		System.out.println("[LoginController: login으로 매핑되어 컨트롤러로 들어왔습니다]");
		model.addAttribute("error","true");
		System.out.println(model.getAttribute("error"));
		System.out.println("[login.jsp로 이동합니다]");
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) 
	{
		return "login";
	}
	
}
