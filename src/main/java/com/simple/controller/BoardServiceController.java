package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class BoardServiceController {
	
	@RequestMapping("/boardList")
	public void boardList() {
		
	}
	
	@RequestMapping("/boardRegister")
	public void boardRegister() {
		
	}
	
	@RequestMapping("/boardResult")
	public void boardResult() {
		
	}
	
	//등록요청
	@RequestMapping("/boardForm")
	public String boardForm() {
		
		return "service/boardResult";//결과화면
	}
}
