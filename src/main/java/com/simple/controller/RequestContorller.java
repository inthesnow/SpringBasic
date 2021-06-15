package com.simple.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/request") //클래스의 requestMapping은 메서드의 요청경로를 묶어서 사용합니다.
public class RequestContorller {
	
//	@RequestMapping("/request/req_ex01")
//	public String req_ex01() {
//		System.out.println("실행됨");
//		return "request/req_ex01";
//	}
	
	//void형 메서드는 들어오는 경로자체가 뷰리졸버로 돌아가게 됩니다.
	@RequestMapping("/req_ex01")
	public void req_ex01(){
		
	}
//	
//	//basic01에 대한 요청
//	@RequestMapping(value = "/basic01", method = RequestMethod.GET)
//	public void basic01() {
//		System.out.println("basic01");
//	}
//	
//	//basic02에 대한 요청
//	@RequestMapping(value = "/basic02", method = RequestMethod.POST)
//	public void basic02() {
//		System.out.println("basic02");
//	}
//	
//	//basic03에 대한 요청
//	@RequestMapping(value = "/basic03")
//	public void basic03() {
//		System.out.println("basic03");
//
//	}
	
	//basic01,02,03을 하나의 메서드로 받아서 처리.
	@RequestMapping({"/basic01","/basic02","/basic03"})
	public void basic() {
		System.out.println("1,2,3");
	}
	/*===================================================================================*/
	//req_ex02의 화면처리
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		return "request/req_ex02";
	}
	//param요청처리
	//1. request객체이용하기
	@RequestMapping("/param")
//	public String param(HttpServletRequest request) {
//		
//		System.out.println(request.getParameter("id"));
//		System.out.println(Arrays.deepToString(request.getParameterValues("inter")));
//		
//		return "request/req_ex02_result";
//	}
	//2. 어노테이션 방법
	public String param(@RequestParam("id") String id, @RequestParam(value="inter", required=false, defaultValue="") ArrayList<String> inter) {
		System.out.println(id);
		System.out.println(inter.toString());
		return "request/req_ex02_result";
	}
}
