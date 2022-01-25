package com.dbal.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbal.app.board.domain.BoardAttachVO;
import com.dbal.app.board.domain.BoardVO;
import com.dbal.app.board.domain.Criteria;
import com.dbal.app.board.mapper.BoardAttachMapper;
import com.dbal.app.board.mapper.BoardMapper;
import com.dbal.app.board.service.BoardService;

@Service
public class BoardServiceImpl  implements BoardService {

	@Autowired BoardMapper boardMapper;
	@Autowired BoardAttachMapper attachMapper;
	
	@Override
	public int insert(BoardVO vo) {
		boardMapper.insert(vo);  //bno
		
		if( vo.getAttachList() == null) 
			return 1;
		
		for(BoardAttachVO attach  : vo.getAttachList()) {
			attach.setBno(vo.getBno());
			attachMapper.insert(attach);
		}
		
		return 1;
	}
	public int update(BoardVO vo) {
		return boardMapper.update(vo);
	}
	public int delete(BoardVO vo) {
		return boardMapper.delete(vo);
	}
	//게시글 조회
	public BoardVO read(BoardVO vo) {
		//게시글조회
		vo = boardMapper.read(vo);
		//첨부파일 조회
		vo.setAttachList(  attachMapper.findByBno(vo.getBno())   );
		return vo;
	}
	public List<BoardVO> getList(Criteria cri) {
		return boardMapper.getList(cri);
	}
	@Override
	public int getTotalCount(Criteria cri) {
		return boardMapper.getTotalCount(cri);
	}
	@Override
	public BoardAttachVO attachRead(String uuid) {
		return attachMapper.read(uuid);
	}

}
