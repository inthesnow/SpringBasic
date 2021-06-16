package com.simple.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.QuizVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	//quiz01화면처리
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	@RequestMapping("/sendBirth")
	public String birth(@ModelAttribute("sendBirth") QuizVO vo) {
		vo.setMonth(vo.getMonth().length()==1?"0"+vo.getMonth():vo.getMonth());
		vo.setDay(vo.getDay().length()==1?"0"+vo.getDay():vo.getDay());
		System.out.println(vo.getYear()+vo.getMonth()+vo.getDay());
		return "quiz/quiz01_ok";
	}
	
	//quiz02화면처리
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	@RequestMapping("/join")
	public ModelAndView join(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", request.getParameter("id"));
		map.put("pw", request.getParameter("pw"));
		map.put("name", request.getParameter("name"));
		map.put("email", request.getParameter("email"));
		
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(map);
		mv.setViewName("quiz/quiz02_ok");
		System.out.println(mv.getModel());
		
		return mv;
	}
	
	//quiz03화면처리
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping("/join2")
	public String join2(@ModelAttribute("id") String id,
						@ModelAttribute("pw") String pw,
						@ModelAttribute("pw_check") String pw_check,
						RedirectAttributes ra) {
		if(id.equals("")) {
			ra.addFlashAttribute("check", "아이디를 입력하세요.");
			return "redirect:/quiz/quiz03";
		} else if (!(pw.equals(pw_check))) {
			ra.addFlashAttribute("check", "비밀번호를 확인하세요.");
			return "redirect:/quiz/quiz03";
		} else {			
			return "quiz/quiz03_ok";
		}
		
	}

}
