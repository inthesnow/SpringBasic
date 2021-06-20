package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;


@Controller
@RequestMapping("/service")
public class ScoreController {
	
	//맴버변수
	//1st
	//private ScoreService scoreService = new ScoreServiceImpl();
	
	//2nd
//	@Autowired
//	@Qualifier("scoreService")
//	private ScoreService scoreService;
	
	//3rd
	@Autowired
	@Qualifier("scoreService")
	private ScoreService scoreService;
	
	//목록화면(화면으로 이동할 때 list를 가지고 나간다)
	@RequestMapping("/scoreList")
	public void scoreList(Model model) {
		//ArrayList<ScoreVO> list=scoreService.getList(); //모델의 값
		
		model.addAttribute("list", scoreService.getList());
	}
	
	
	//등록화면
	@RequestMapping("/scoreRegist") 
	public void scoreRegist() {
		
	}
	
	//결과화면
	@RequestMapping("/scoreResult")
	public void scoreResult() {
		
	}
	
	//등록요청
	@RequestMapping("regist")
	public String regist(ScoreVO vo) {
		scoreService.regist(vo);
		
		return "service/scoreResult";
	}
	//삭제요청
	@RequestMapping("scoreDelete")
	public String delete(@RequestParam("num") int num,
						 RedirectAttributes ra) {
		scoreService.delete(num);
		System.out.println(num);
		ra.addFlashAttribute("msg", "삭제처리되었습니다.");
		return "redirect:/service/scoreList";
	}
}
