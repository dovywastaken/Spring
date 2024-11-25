package com.spring.dto;


public class BookDTO 
{

	//전역변수
	private String title;
	private int price;
	private String company;
	private int page;
	
	//생성자
	public BookDTO() {}
	public BookDTO(String title, int price, String company, int page) 
	{
		super();
		this.title = title;
		this.price = price;
		this.company = company;
		this.page = page;
	}
	
	
	//Getter Setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
	//객체 --> 문자열로 출력 구문
	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", price=" + price + ", company=" + company + ", page=" + page + "]";
	}
	
	
	
}
