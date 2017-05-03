package com.spring.action.idol.part1;

import org.springframework.stereotype.Component;

@Component()
public class Guitar implements Instrument {

	@Override
	public void play() {
        int sum = 0;
        for (int i = 0; i < 1000000; i++){
            sum += i;
        }
        System.out.println("Playing Guitar:  1+2+...+1000000=" + sum);
	}

}
