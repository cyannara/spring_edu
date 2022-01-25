package com.dbal.app.ioc2;

public class SamsungTV implements TV {

	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	public void volumeUp() {
		System.out.println("SamsungTV volumeUp");
	}
	public void volumeDown() {
		System.out.println("SamsungTV volumeDown");
	}	
}
