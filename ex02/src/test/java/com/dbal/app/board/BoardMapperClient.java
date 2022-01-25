package com.dbal.app.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dbal.app.board.domain.BoardVO;
import com.dbal.app.board.domain.Criteria;
import com.dbal.app.board.mapper.BoardMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class BoardMapperClient {

	@Autowired BoardMapper boardMapper;
	
	@Test
	public void getList() {
		Criteria cri = new Criteria(1,20);
		cri.setType("W");
		cri.setKeyword("choi");
		log.info(boardMapper.getList(cri).toString());
	}
	
	//@Test
	public void insert() {
		//BoardVO 생성
		BoardVO vo = new BoardVO();
		vo.setContent("aa");
		vo.setTitle("title");
		vo.setWriter("홍길동");
		boardMapper.insert(vo);
		log.info(Long.toString(vo.getBno()));
		
	}
	//@Test
	public void read() {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo = boardMapper.read(vo);
		log.info(vo.toString());
	}
	
	//@Test
	public void update() {
		//BoardVO 생성
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setContent("aa");
		vo.setTitle("title");
		vo.setWriter("홍길동");
		int result = boardMapper.update(vo);
		assertEquals(result, 1);
	}
	
	//@Test
	public void delete() {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		int result = boardMapper.delete(vo);
		assertEquals(result, 1);
	}
}
