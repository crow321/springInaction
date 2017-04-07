//朗诵诗歌的杂技师
package com.spring.action.idol;

public class PoemJuggler extends Juggler {
	//引用接口 Poem
	private Poem poem;
	//注入poem
	public PoemJuggler(Poem poem) {
		super();
		this.poem = poem;
	}
	//注入poem和beanbags
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
