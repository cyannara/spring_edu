package com.dbal.app.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbal.app.board.domain.BoardVO;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class AjaxTestController {

	@GetMapping("/ajax1") 
	@ResponseBody
	public BoardVO test1(BoardVO vo) {
		vo.setContent("content test");
		return vo;
	}
	
	@PostMapping("/ajax2")  
	@ResponseBody
	public BoardVO test2(@RequestBody BoardVO vo) {
		vo.setContent("content test");
		return vo;
	}
}



