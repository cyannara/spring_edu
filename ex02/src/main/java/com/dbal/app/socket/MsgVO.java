package com.dbal.app.socket;

import lombok.Data;

@Data
public class MsgVO {
	String cmd;
	String id;
	String msg;
}
