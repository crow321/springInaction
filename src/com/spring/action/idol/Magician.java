package com.spring.action.idol;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.Expression;

/**
 * Created by crow on 2017/4/11.
 */

@Component
@Aspect
public class Magician implements MinderReader {
    private String thoughts;
    @Pointcut(
            "execution(* com.spring.action.idol.Thinker.thinkOfSomething(String)) && args(thoughts)")
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
