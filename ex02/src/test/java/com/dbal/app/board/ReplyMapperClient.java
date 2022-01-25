package com.dbal.app.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dbal.app.board.domain.Criteria;
import com.dbal.app.board.domain.ReplyVO;
import com.dbal.app.board.mapper.ReplyMapper;
import com.dbal.app.board.service.ReplyService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class ReplyMapperClient {

	@Autowired ReplyMapper replyMapper;
	@Autowired ReplyService replyService;
	
	@Test
	public void getList() {
		Criteria cri = new Criteria(1,20);
		log.info(replyService.getList(cri, 377L).toString());
	}

	
	
	
	
	
	//@Test
	public void insert() {
		//ReplyVO 생성
		ReplyVO vo = new ReplyVO();
		//vo.setContent("aa");
		//vo.setTitle("title");
		//vo.setWriter("홍길동");
		replyMapper.insert(vo);
		log.info(Long.toString(vo.getBno()));
		
	}
	//@Test
	public void read() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(1);
		vo = replyMapper.read(vo);
		log.info(vo.toString());
	}
	
	//@Test
	public void update() {
		//ReplyVO 생성
		ReplyVO vo = new ReplyVO();
		vo.setBno(1);
		//vo.setContent("aa");
		//vo.setTitle("title");
		//vo.setWriter("홍길동");
		int result = replyMapper.update(vo);
		assertEquals(result, 1);
	}
	
	//@Test
	public void delete() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(1);
		int result = replyMapper.delete(vo);
		assertEquals(result, 1);
	}
}
