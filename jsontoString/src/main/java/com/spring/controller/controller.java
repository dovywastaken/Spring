package com.spring.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spring.dto.BookDTO;

@Controller
@RequestMapping("/test")
public class controller 
{
	@GetMapping("case1")
	public String index() 
	{
		return "index";
	}
	String json;
	Gson gs = new Gson();
	
	//DTO를 JSON으로 바꾸는 법!!!
	@ResponseBody
	@GetMapping("/project01")
	public String project01() 
	{
		BookDTO dto = new BookDTO("자바", 21000,"에이콘",670);
		//Gson으로 JSON으로 변환하기
		System.out.println(dto.toString());
		//Gson의 toJson객체에 dto를 파라미로 주면 dto 내 변수들을 json 타입을 ㅗ바꿔준다
		json = gs.toJson(dto);
		System.out.println(json);
		
		return json;
	}
	
	
	//JSON을 DTO로 바꾸는 법!!!
	@GetMapping("/project02")
	public String project02() 
	{
		BookDTO dto = gs.fromJson(json, BookDTO.class);
		System.out.println(dto.toString());
		
		
		return "index";
	}
	
	
	//DTO 여러개를 ArrayList로 묶은 것을 JSON으로 바꾸기
	@ResponseBody
	@GetMapping("/project03")
	public String project03() 
	{
		BookDTO dto1 = new BookDTO("자바1", 21000,"에이콘1",670);
		BookDTO dto2 = new BookDTO("자바2", 21000,"에이콘2",670);
		BookDTO dto3 = new BookDTO("자바3", 21000,"에이콘3",670);
		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		String jsonlist = gs.toJson(list);
		
		
		
		//JSON(ArrayList) --> ArrayList<BookDTO>
		
		ArrayList<BookDTO> jsontolist = 
		gs.fromJson(jsonlist, new TypeToken<ArrayList<BookDTO>>() {}.getType());
		
		
		for(int i=0; i<jsontolist.size(); i++) 
		{
			BookDTO tmp = jsontolist.get(i);
			System.out.println(i);
			System.out.println(tmp.toString());
		}
		
		for(BookDTO vo : jsontolist) System.out.println(vo.toString());
		
		return jsonlist;
	}
	
	
	@GetMapping("/project04")
	public String project04() 
	{
		JSONObject student1 = new JSONObject(); 
		student1.put("name", "홍길동");
		student1.put("phone", "010-1111-1111");
		student1.put("address", "서울");
		System.out.println("student1"+ student1);
		
		JSONObject student2 = new JSONObject();
		student2.put("name", "나길동");
		student2.put("phone", "010-2222-2222");
		student2.put("address", "광주");
		System.out.println("student2"+ student2);
		
		JSONArray students = new JSONArray();
		students.put(student1);
		students.put(student2);
		System.out.println("students"+ students);
		
		JSONObject object = new JSONObject();
		object.put("students", students);
		System.out.println("object"+ object);
		
		return "index";
	} 
	
}

