package com.spring.action.idol;

/**
 * Created by crow on 2017/4/11.
 */
public class Audience {
    public void beforePerform(){
        System.out.println("beforePerform...");
    }
    public void afterPerform(){
        System.out.println("afterPerform...");
    }
    public void throwPerform(){
        System.out.println("throwPerform...");
    }
}
