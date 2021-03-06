package com.dbal.app.board.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class BoardVO {
	private long bno;		//게시글번호
	private String title;	//제목
	private String content;	//내용
	private String writer;	//작성자
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date regdt;	//작성일자
	@JsonIgnore
	private Date upddt;//수정일자
	private long replycnt;
	
	List<BoardAttachVO> attachList;
}

