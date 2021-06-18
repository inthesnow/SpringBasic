package com.simple.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.simple.command.BoardVO;

@Mapper
public interface BoardMapper {
	public void regist(HashMap<String, String> map);
	public ArrayList<BoardVO> getList();
	public void delete(int num);
}
