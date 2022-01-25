package com.dbal.app.ioc2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser3Container {

	public static void main(String[] args) {

		AbstractApplicationContext  factory =
				new GenericXmlApplicationContext("application-context.xml");
		TV tv = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
