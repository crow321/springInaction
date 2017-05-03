//ͨ����̬����������������
package com.spring.action.idol.part1;

public class Stage {
	//˽�еĹ��췽��
	private Stage(){
	}
	//�ӳټ���ʵ��
	private static class StageSingletonHolder{
		private static Stage stage = new Stage(); 
	}
	//������ʱ��ʵ����
	//��̬������ÿ�η�����ͬ��ʵ������
	public static Stage getInstance(){
		return StageSingletonHolder.stage;
	}
}
