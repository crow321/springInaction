//�Ӷ������Ӽ�ʦ
package com.spring.action.idol.part1;

public class Juggler implements Performer {
	//Ĭ�϶�������Ϊ3
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
