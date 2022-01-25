package com.dbal.app.ioc3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/application-context.xml"})
public class TvUserClient {

	@Autowired TV tv;
	
	@Test
	public void getTv() {
		tv.powerOn();
		tv.volumeUp();
	}
}
