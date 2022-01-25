package com.dbal.app.ioc3;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext  factory =
				new GenericXmlApplicationContext("application-context.xml");
		//CollectionBean bean = factory.getBean(CollectionBean.class);
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		List<String> addressList = bean.getAddressList();
		for(String addr : addressList) {
			System.out.println(addr);
		}
	}
}
