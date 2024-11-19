package com.springmvc.chap09;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Example03Controller 
{
	@GetMapping("/form")
	public String requestForm(Member member) 
	{
		System.out.println("================================================================");
        System.out.println("[Example03Controller: exam03/form Get으로 매핑되어 컨트롤러로 들어왔습니다]");
		return "webpage09_02";
	}
	
	@PostMapping("/form")
	public String submitForm(@ModelAttribute("member") Member member, HttpServletRequest req, HttpSession session) 
	{
		System.out.println("================================================================");
        System.out.println("[Example03Controller: exam03/form POST로 매핑되어 컨트롤러로 들어왔습니다]");
		String name = member.getName();
		String save = req.getServletContext().getRealPath("/resources/images");
		System.out.println(save);
		String filename = member.getImageFile().getOriginalFilename();
		try 
		{
			member.getImageFile().transferTo(new File(save + name + "_" + filename));
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return "webpage09_submit";
	}
}
