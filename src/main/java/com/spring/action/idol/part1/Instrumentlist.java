//���ֱ��ݼ�
//��ϰע��bean
package com.spring.action.idol.part1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Instrumentlist implements Performer {

	private Instrument instrument;
    @Value("snow")
	private String song;
	
	public Instrumentlist() {
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Playing " + song + " :");
		instrument.play();
	}
	
	public String screamSong(){
		return song;
	}
	public String getSong() {
		return song;
	}
	//
	public void setSong(String song) {
		this.song = song;
	}
	//
    @Autowired()
    @Qualifier("guitar")
	public void setInstrument(Instrument intstrument) {
		this.instrument = intstrument;
	}
	

}
