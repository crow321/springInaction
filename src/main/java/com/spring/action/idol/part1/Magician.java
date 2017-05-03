package com.spring.action.idol.part1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by crow on 2017/4/11.
 */

@Component
@Aspect
public class Magician implements MinderReader {
    private String thoughts;
    @Pointcut(
            "execution(* com.spring.action.idol.part1.Thinker.thinkOfSomething(String)) && args(thoughts)")
    public void mind(String thoughts){

    }
    @Before("mind(String) && args(thoughts)")
    @Override
    public void interruptThought(String thoughts) {
        System.out.println("interrupt volunteer's thoughts!");
        this.thoughts = thoughts;
    }

    @Override
    public String getThgoughts() {
        return thoughts;
    }

}
