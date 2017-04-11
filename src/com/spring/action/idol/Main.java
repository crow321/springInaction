package com.spring.action.idol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws PerformanceException {
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/springIdol.xml");
		Performer performer = (Performer) context.getBean("duke");
		performer.perform();
		System.out.println("=====================================");
		Performer performer2 = (Performer) context.getBean("poemticduke");
		performer2.perform();
		
		System.out.println("=====================================");
		Auditorium auditorium = (Auditorium) context.getBean("auditorium");
		
		System.out.println("=====================================");
		Performer performer3 = (Performer) context.getBean("kenny");
		performer3.perform();

        System.out.println("===========AOP test===============");
        ApplicationContext context1 = new ClassPathXmlApplicationContext("xml/aop.xml");
        Performer instrumentlist = (Performer) context1.getBean("tom");
        instrumentlist.perform();
    }

}
