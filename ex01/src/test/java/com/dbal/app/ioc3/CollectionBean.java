package com.dbal.app.ioc3;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class CollectionBean {

	private List<String> addressList;

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	
	
}
