package com.dbal.app.ioc2;

public class TvUser1 {

	public static void main(String[] args) {
		//TV tv = new SamsungTV();
		TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
