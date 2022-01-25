package com.dbal.app.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbal.app.board.domain.Criteria;
import com.dbal.app.board.domain.ReplyPageVO;
import com.dbal.app.board.domain.ReplyVO;
import com.dbal.app.board.mapper.BoardMapper;
import com.dbal.app.board.mapper.ReplyMapper;
import com.dbal.app.board.service.ReplyService;

@Service
public class ReplyServiceImpl  implements ReplyService {

	@Autowired ReplyMapper replyMapper;
	@Autowired BoardMapper boardMapper;
	
	@Override
	@Transactional
	public int insert(ReplyVO vo) {
		boardMapper.updateReplycnt(vo.getBno(), 1L);
		return replyMapper.insert(vo);
	}
	public int update(ReplyVO vo) {
		return replyMapper.update(vo);
	}
	public int delete(ReplyVO vo) {
		boardMapper.updateReplycnt(vo.getBno(), -1L);
		return replyMapper.delete(vo);
	}
	public ReplyVO read(ReplyVO vo) {
		return  replyMapper.read(vo);
	}
	public ReplyPageVO getList(Criteria cri, Long bno) {
		ReplyPageVO vo = new ReplyPageVO();
		vo.setReplyCnt(replyMapper.getCountByBno(bno));
		vo.setList(replyMapper.getList(cri, bno));
		return vo;
	}
}
