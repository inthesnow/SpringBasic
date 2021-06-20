package com.simple.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.test.mapper.TESTMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class MybatisTEST {
	//1. 세션팩토리 주입확인
	@Autowired
	SqlSessionFactoryBean sqlSessionFactory;
	
	//2.메퍼파일 주입
	@Autowired
	TESTMapper testMapper;
	
	@Test
	public void mybatisTest() {
		System.out.println("마이바티스 팩토리빈 : " + sqlSessionFactory);
		
		System.out.println("테스트 맵퍼"+testMapper.getTEST());
	}
}
