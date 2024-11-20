package com.springmvc.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MonitoringInterceptor implements HandlerInterceptor
{
	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception 
	{
		System.out.println("preHandle 호출");
		logger.info("접근한 URL 경로 : " + getURLPath(req));
		logger.info("요청 처리 시작 시각 : " + getCurrentTime());
		System.out.println("preHandle 종료");
		
		return true;
	}
	
	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse resp, Object handler, ModelAndView modelAndView) throws Exception
	{
		System.out.println("postHandle 호출");
		logger.info("요청 처리 종료 시각 : " + getCurrentTime());
		System.out.println("postHandle 종료");
	}
	
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception exception) throws Exception 
	{
		System.out.println("afterCompletion 호출");
		System.out.println("afterCompletion 종료");
		logger.info("==============================================================");
	} 
	
	
	private String getURLPath(HttpServletRequest req) 
	{
		System.out.println("getURLPath 호출");
		String currentPath = req.getRequestURI();
		String queryString = req.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		System.out.println("getURLPath 종료");
		
		return currentPath + queryString;
	}
	
	private String getCurrentTime() 
	{
		System.out.println("getCurrentTime 호출");
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		System.out.println("getCurrentTime 종료");
		
		return formatter.format(calendar.getTime());
	}
}
