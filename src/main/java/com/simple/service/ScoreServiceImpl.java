package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{

	@Autowired
	@Qualifier("scoreDAO")
	private ScoreDAO scoreDAO;
	
	public void regist(ScoreVO vo) {
		scoreDAO.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		//ArrayList<ScoreVO> list=scoreDAO.getList(); //리턴할 값
		return scoreDAO.getList();
	}

	@Override
	public void delete(int num) {
		scoreDAO.delete(num);
	}
	
	
}
