package com.simple.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.mapper.ScoreMapper;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{

//	@Autowired
//	@Qualifier("scoreDAO")
//	private ScoreDAO scoreDAO;

	@Autowired
	private ScoreMapper scoreMapper;
	
	@Override
	public void regist(ScoreVO vo) {
		//1st
		//scoreMapper.regist(vo);
		
		//2nd - map
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", vo.getName());
		map.put("kor", vo.getKor());
		map.put("eng", vo.getEng());
		
		scoreMapper.regist(map);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		//ArrayList<ScoreVO> list=scoreDAO.getList(); //리턴할 값
		
		return scoreMapper.getList();
	}

	@Override
	public void delete(int num) {
		scoreMapper.delete(num);
	}
	
	
}
