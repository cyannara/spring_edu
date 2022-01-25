package com.dbal.app.board.service;

import com.dbal.app.board.domain.Criteria;
import com.dbal.app.board.domain.ReplyPageVO;
import com.dbal.app.board.domain.ReplyVO;

public interface ReplyService {

	//등록
	public int insert(ReplyVO vo);
	
	//수정
	public int update(ReplyVO vo);
	
	//삭제
	public int delete(ReplyVO vo);
	
	//단건조회
	public ReplyVO read(ReplyVO vo);
	
	//전체조회
	public ReplyPageVO getList(Criteria cri, Long bno);
	
}
