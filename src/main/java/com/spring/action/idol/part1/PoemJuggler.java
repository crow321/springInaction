//����ʫ����Ӽ�ʦ
package com.spring.action.idol.part1;

public class PoemJuggler extends Juggler {
	//���ýӿ� Poem
	private Poem poem;
	//ע��poem
	public PoemJuggler(Poem poem) {
		super();
		this.poem = poem;
	}
	//ע��poem��beanbags
	public PoemJuggler(Poem poem, int beanbags){
		super(beanbags);
		this.poem = poem;
	}
	
	public void perform() throws PerformanceException{
		super.perform();
		System.out.println("while reciting...");
		poem.recite();
	}
}
