package com.springmvc.chap09;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/exam01")
public class Example01Controller 
{
	@GetMapping("/form")
	public String requestForm() 
	{
		System.out.println("================================================================");
        System.out.println("[Example01Controller: exam01/form으로 매핑되어 컨트롤러로 들어왔습니다]");
        System.out.println("[webpage09_01.jsp로 이동합니다]");
		return "webpage09_01";
	}

	@PostMapping("/form")
	public String submitForm(@RequestParam("name") String name, @RequestParam("fileImage") MultipartFile file, HttpServletRequest req) 
	{
		System.out.println("================================================================");
        System.out.println("[Example01Controller: exam01/form POST로 매핑되어 컨트롤러로 들어왔습니다]");
        //String imagesFolder = "D:/KES/Spring/Spring_Project/chap09/src/main/webapp/resources/images";
		String imagesFolder = req.getServletContext().getRealPath("/resources/images");
		
		//파일 경로 저장 유효성 검사
		if(imagesFolder == null)
			System.out.println("경로 저장에 실패했습니다");
		else 
		{
			System.out.println("저장 경로 : "+imagesFolder);
		}
		String filename = file.getOriginalFilename();
		//파일이름 유효성 검사
		if(filename == null)
			System.out.println("파일 이름 저장에 실패했습니다");
		else 
		{
			System.out.println("파일 이름 : "+filename);
		}
		File f = new File(imagesFolder + "\\" + name + "_" + filename);
		try 
		{
			file.transferTo(f);
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		return "webpage09_submit";
	}
}
