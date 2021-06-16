package com.simple.dao;

import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("yyy")
public class ScoreDAOImpl implements ScoreDAO{
	
	@Override
	public void regist(ScoreVO vo) {
		System.out.println("넘어오는 값"+vo.getName());
		System.out.println("넘어오는 값"+vo.getKor());
		System.out.println("넘어오는 값"+vo.getEng());
	}
}
