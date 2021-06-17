package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	//res_ex01화면처리
	@RequestMapping("/res_ex01")
	public void res_ex01() {
		
	}
	
	//model전달자 - 화면으로 전달할 데이터를 addAttribute(key, value)
	@RequestMapping("/res_ex02")
	public String res_ex02(Model model) {
		model.addAttribute("serverTime", new Date());
		model.addAttribute("name", "hong");
		
		return "response/res_ex02";
	}
	
	//modelAndView방법 - 데이터는 addObject(key, value),화면정보 setViewName()
	@RequestMapping("/res_ex03")
	public ModelAndView res_ex03() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime", new Date());
		mv.setViewName("response/res_ex03");
		return mv;
	}
	
	//ModelAttribute전달자 - @requestParam+model
	@RequestMapping("/res_ex04")
	public String res_ex04(@ModelAttribute("id") String id) {
		
		return "response/res_ex04";
	}
	
	//modelAttribute의 여러값
	@RequestMapping("/res_ex05")
	public String res_ex05(@ModelAttribute("info") ReqVO vo) {
		
		return "response/res_ex05";
	}
	
	//리다이렉트와 리다이렉트 어트리뷰트!
	@RequestMapping("/res_redirect")
	public void res_redirect() {
		
	}
	
	//가정 - 아이디, 비밀번호가 동일하면 성공화면, 다르면 다시로그인 화면으로 이동
	@RequestMapping("/login")
	public String login(ReqVO vo, RedirectAttributes RA) {
		if(vo.getId().equals(vo.getPw())) {//성공
			return "response/res_login_ok";
		} else {//실패
			//redirect:/절대경로 - 다시 컨트롤러를 타게한다.
			RA.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요");
			return "redirect:/response/res_redirect";//다시로그인화면
		}
	}
	
	//res_quiz01
	@RequestMapping("/res_quiz01")
	public String res_quiz01() {
		return "response/res_quiz01";
	}
	
	@RequestMapping("/res_login")
	public String res_login(@ModelAttribute("res_login") ReqVO vo, RedirectAttributes RA) {
		if(vo.getId().equals("kim12")&&vo.getPw().equals("1234")) {
			return "response/res_quiz02";			
		} else {
			RA.addFlashAttribute("fail", vo.getId()+"는 회원이 아닙니다.");
			return "redirect:/response/res_quiz01";
		}
	}
}
