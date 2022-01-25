package com.dbal.app.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private long rno;
	private long bno;
	private String reply;
	private String writer;
	private Date regdt;
	private Date upddt;
}
