package com.spring.action.idol;

/**
 * Created by crow on 2017/4/11.
 */
public class Magician implements MinderReader {
    private String thoughts;
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
