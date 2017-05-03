package com.spring.action.idol.part1;

public class Sonnet29 implements Poem {
	private static String[] LINES =
		{
			"~~When in disgrace with fortune and men's eyes,",
			"~~I all alone beweep my outcast state,",
			"~~And trouble deaf heaven with my bootless cries,",
			"~~And look upon myself, and curse my fate."
		};
	
	@Override
	public void recite() {
		for (int i = 0; i < LINES.length; i++) {
			System.out.println(LINES[i]);
		}
	}

}
