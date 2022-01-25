package com.dbal.app.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dbal.app.sample.service.SampleService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class SampleServiceClient {

	@Autowired SampleService sampleService;
	
	@Test
	public void test() {
		String str = "no1 150000000";		
		sampleService.addData(str);		
		log.info("length="+ str.getBytes().length);
	}
}
