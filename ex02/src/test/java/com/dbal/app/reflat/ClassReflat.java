package com.dbal.app.reflat;

import com.dbal.app.insa.domain.EmpVO;

public class ClassReflat {

	public static void main(String[] args) {
		EmpVO.class.getDeclaredFields();  //field 목록
	}

}
