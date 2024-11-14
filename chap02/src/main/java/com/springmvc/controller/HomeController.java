package com.springmvc.controller;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //컨트롤러 지정하기
public class HomeController 
{
	
	@RequestMapping(value ="/", method = RequestMethod.GET) //doGet과 같은 역할
	public String home(Locale locale, Model model) 
	{	
	      Date date = new Date();
	      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	      
	      String formattedDate = dateFormat.format(date);
	      
	      model.addAttribute("serverTime", formattedDate );
		
		
		// /WEB-IMF/views/    여기에 home이 들어감       .jsp
		return "home";	
	}
	
	@RequestMapping(value = "/test")
	public String test(Model model) 
	{
		String test = "안녕하세요";
		model.addAttribute("tt",test);
		return "test";
	}
}
