//扔豆袋的杂技师
package com.spring.action.idol;

public class Juggler implements Performer {
	//默认豆袋数量为3
	private int beanbags = 3;
	
	public Juggler() {
	
	}
	
	public Juggler(int beanbags){
		this.beanbags = beanbags;
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Juggler performs " + beanbags + " beanbags...");
	}

}
