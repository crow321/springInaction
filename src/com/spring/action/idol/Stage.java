//通过静态工厂方法创建单例
package com.spring.action.idol;

public class Stage {
	//私有的构造方法
	private Stage(){
	}
	//延迟加载实例
	private static class StageSingletonHolder{
		private static Stage stage = new Stage(); 
	}
	//返回延时的实例，
	//静态方法：每次返回相同的实例对象
	public static Stage getInstance(){
		return StageSingletonHolder.stage;
	}
}
