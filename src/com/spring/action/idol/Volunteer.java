package com.spring.action.idol;

/**
 * Created by crow on 2017/4/11.
 */
public class Volunteer implements Thinker {
    private String thoughts;
    @Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
