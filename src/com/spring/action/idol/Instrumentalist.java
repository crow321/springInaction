//ÒôÀÖ±íÑİ¼Ò
//Á·Ï°×¢Èëbean
package com.spring.action.idol;

public class Instrumentalist implements Performer {
	
	private Instrument instrument;
	private String song;
	
	public Instrumentalist() {
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
	//×¢Èë¸èÇú
	public void setSong(String song) {
		this.song = song;
	}
	//×¢ÈëÀÖÆ÷
	public void setInstrument(Instrument intstrument) {
		this.instrument = intstrument;
	}
	

}
