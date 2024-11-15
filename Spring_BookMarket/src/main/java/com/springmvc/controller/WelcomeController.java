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
		System.out.println();
		model.addAttribute("greeting","Welcome to BookMarket");
		model.addAttribute("strapline","Welcome to Web Shopping Mall!");
		
		return "welcome";
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String welcome(Model model) 
	{
		System.out.println("================================================================");
		model.addAttribute("greeting","Welcome to BookMarket");
		model.addAttribute("strapline","Welcome to Web Shopping Mall!");
		
		return "welcome";
	}
}
