package com.spring.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
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
		System.out.println("student1 : "+ student1);
		
		JSONObject student2 = new JSONObject();
		student2.put("name", "나길동");
		student2.put("phone", "010-2222-2222");
		student2.put("address", "광주");
		System.out.println("student2 : "+ student2);
		
		JSONArray students = new JSONArray();
		students.put(student1);
		students.put(student2);
		System.out.println("students : "+ students);
		
		JSONObject object = new JSONObject();
		object.put("students", students);
		System.out.println("object : "+ object);
		
		return "index";
	} 
	
	
	
	@GetMapping("/project05")
	public String project05() 
	{
		String client_id = "a1xrcx51gr";
		String client_secret = "Eks8yzDeEjf1LedRzYxWkU7HnwuFKa8VU5biXpIx";

		try 
		{
			//
			BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("주소를 입력하세요: ");
			String address = io.readLine();
			// 입력받는 문자열의 공백으로 인해서
			// 데이터를 끝으로 인식하므로
			// UTF-8로 변경하면 %20으로 변환됨
			// 즉, 데이터 토큰이 공백을 통해서 판단됨
			
			String addr = URLEncoder.encode(address, "UTF-8");
			
			//Step 2 : URL 작성하기
			String reqURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr;
			
			//Step 3 : 작성된 URL을 이용하여 요청을 발생시킴
			URL url = new URL(reqURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", client_id);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", client_secret);
			
			
			//Step 4 : 요청 후 응답데이터 수신하기
			
			
			int responseCode=con.getResponseCode(); //HTTP 응답코드를 구해오는 메서드임 200, 404, 500 등
			BufferedReader br = new BufferedReader(
						new InputStreamReader(con.getInputStream(), "UTF-8")
						);
			
			//Step 5 : 수신한 데이터 문자열 데이터로 변환하기
			String line;
			StringBuffer data = new StringBuffer();
			while((line=br.readLine())!=null) 
			{
				data.append(line);
			}
			//System.out.println(data);
			br.close();
			
			//Step 6: JSON 객체로 변환하기
			JSONTokener tok = new JSONTokener(data.toString()); //데이터 단위를 인식시키기 위해 필요한 객체로 파라미터로 단위가 될 코드를 받는다
			JSONObject obj = new JSONObject(tok); //얘는 {}를 인식해서 JSON 코드를 인식함
			//System.out.println(obj.get("status")); //obj의 get안에 key 값을 넣는다
			
			JSONObject meta = obj.getJSONObject("meta");// 객체안의 객체를 꺼내는 방법 // meta : { }
			int totalCount = meta.getInt("totalCount"); // 이런식으로 key값을 파라미터로 줘서 value를 가져온다
			
			JSONArray arr = obj.getJSONArray("addresses"); //JSON배열은 이렇게 담기
			
			JSONObject first  = (JSONObject)arr.get(0);
			
			JSONArray adr =  first.getJSONArray("addressElements");
			
			JSONObject eighth = (JSONObject)adr.get(8);
			
			String longName = eighth.getString("longName");
			String shortName = eighth.getString("shortName");
			
			
			
			String x = first.getString("x"); //키 값을 이용해서 x에 해당하는 value를 저장
			String y = first.getString("y");
			
			System.out.println("x 좌표는 "+ x);
			System.out.println("y 좌표는 "+ y);
			// first.getJSONArray("addressElements"); //이건 객체 안의 배열에 접근할 때
			
			getImage(x,y,address);
			/* */
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return "index";
	}
	
	
	public void getImage(String x, String y, String addr) 
	{
		System.out.println("=======================================================================================");
		System.out.println("getImage 함수 입장");
		//step1 : URL 작성하기
		String client_id = "a1xrcx51gr";
		String client_secret = "Eks8yzDeEjf1LedRzYxWkU7HnwuFKa8VU5biXpIx";
		
		try 
		{
			System.out.println(addr);
			String url = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
			url += "w=300&h=300&";
			url += "center="+x+","+y+"&";
			url += "level=16";
			//url += "markers";
			System.out.println(url);
			String pos = URLEncoder.encode(x+" "+y,"UTF-8");
			url += "&markers=type:t|size:mid|pos:"+pos+"|label:"+URLEncoder.encode(addr, "UTF-8");
			
			//step2 : 요청 발생 시키기
			URL ur = new URL(url);
			HttpURLConnection con = (HttpURLConnection) ur.openConnection();
			//System.out.println("HttpURLConnection의 값은 : "+con);
			con.setRequestMethod("GET");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", client_id);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", client_secret);
			//System.out.println("요청발생시키기 까지 왔니?" + con);
			
			//step3 : 데이터 수신
			InputStream is = con.getInputStream();
			byte[] bytes = new byte[1024];


			
			//파일이름 짓기
			/*
			Date dt = new Date();
			Long lt = dt.getTime();
			String img = lt.toString();
			
			이 3개 코드나 밑에 imgname 코드나 똑같음
			*/
			String imgname = Long.valueOf(new Date().getTime()).toString();
			
			//파일 생성
			String savePath = "D:\\";
			File file = new File(savePath + imgname+".jpg");
			file.createNewFile();
			int read = 0;

			System.out.println(file.getAbsolutePath());
			FileOutputStream outputstream = new FileOutputStream(file);
			
			while((read=is.read(bytes))!= -1) 
			{
				outputstream.write(bytes,0,read);
			}
			System.out.println("파일 생성 완료");
			is.close();
			outputstream.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}

