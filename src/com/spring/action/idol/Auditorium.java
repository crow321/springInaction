//礼堂类
package com.spring.action.idol;

public class Auditorium {
	//表演开始前调用
	public void turnOnLights(){
		System.out.println("表演开始前开灯...");
	}
	//表演结束后调用
	public void turnOffLights(){
		System.out.println("表演结束后关灯...");
	}
}
