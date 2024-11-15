package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController 
{
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String home(Model model) 
	{
		System.out.println("================================================================");
		System.out.println("[WelcomeController: home으로 매핑되어 컨트롤러로 들어왔습니다]");
		System.out.println("웰컴 텍스트를 Model에 담아서 전달합니다");
		model.addAttribute("greeting","Welcome to BookMarket");
		model.addAttribute("strapline","Welcome to Web Shopping Mall!");
		
		System.out.println("[WelcomeController: home 메서드를 통해 welcome.jsp로 이동합니다]");
		return "welcome";
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String welcome(Model model) 
	{
		System.out.println("================================================================");
		System.out.println("[WelcomeController: 프로젝트 이름으로 매핑되어 컨트롤러로 들어왔습니다]");
		System.out.println("웰컴 텍스트를 Model에 담아서 전달합니다");
		model.addAttribute("greeting","Welcome to BookMarket");
		model.addAttribute("strapline","Welcome to Web Shopping Mall!");
		
		System.out.println("[welcome.jsp로 이동합니다]");
		return "welcome";
	}
}
