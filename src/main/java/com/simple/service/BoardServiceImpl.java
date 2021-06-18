package com.simple.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	
//	@Autowired
//	@Qualifier("boardDAO")
//	private BoardDAO boardDAO;
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void boardRegist(BoardVO vo) {
		
		HashMap<String, String > map = new HashMap<String, String>();
		map.put("name", vo.getName());
		map.put("title", vo.getTitle());
		map.put("content", vo.getContent());
		
		boardMapper.regist(map);
	}

	@Override
	public ArrayList<BoardVO> getList() {
		
		return boardMapper.getList();
	}

	@Override
	public void boardDelete(int num) {
		
		boardMapper.delete(num);
	}

}
