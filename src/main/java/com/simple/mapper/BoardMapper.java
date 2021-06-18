package com.simple.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.simple.command.BoardVO;

public interface BoardMapper {
	public void regist(HashMap<String, String> map);
	public ArrayList<BoardVO> getList();
	public void delete(int num);
}
