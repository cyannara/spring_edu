package com.dbal.app.ioc3;

import org.springframework.beans.factory.annotation.Autowired;

public class LgTV implements TV {
	
	//@Autowired   //클래스타입
	//@Qualifier("apple")*/  //id 값으로 검색
	//@Resource(name="apple")
	Speaker speaker;	 
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("LgTV powerOn");
	}
	public void powerOff() {
		System.out.println("LgTV powerDown");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}	
}
