package com.spring.action.idol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Created by crow on 2017/4/11.
 */
@Component
public class Audience {
    public void beforePerform(){
        System.out.println("表演开始前...");
    }
    public void afterPerform(){
        System.out.println("表演结束...");
    }
    public void throwPerform(){
        System.out.println("表演开始前和表演结束...");
    }

    public void watchPerform(ProceedingJoinPoint joinPoint) {

        try {
            long startTime = System.currentTimeMillis();
            System.out.println("表演很精彩..." + " starttime= " + startTime);

            joinPoint.proceed();

            long endTime = System.currentTimeMillis();
            System.out.println("表演很精彩..." + " endTime= " + endTime);
            long time = endTime- startTime;
            System.out.println("表演耗时 " + time +" ms");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
