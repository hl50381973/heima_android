package com.itheima.baidumusic;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

//���ֲ��ŷ���
public class MusicService extends Service {

	//[2]�����Ƕ�����м��˶��� ����
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}
	//�����һ�ο������ǵ���
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	
	//���������ٵ�ʱ�����
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	//ר�������������ֵ� 
	public void playMusic(){
		System.out.println("���ֲ�����");
		//TODO �Ƚ����ý�� �Ѹù�������
		
	}
	
	//������ͣ��
	public void pauseMusic(){
		System.out.println("������ͣ��");
	}
	
	//���ּ������ŵķ���
	public void  rePlayMusic(){
		System.out.println("���ּ���������");
	}
	
	//[1]����һ���м��˶���(IBinder) 
	private class MyBinder extends Binder implements Iservice{

		//���ò������ֵķ���
		@Override
		public void callPlayMusic() {
			
			playMusic();
		}

		//������ͣ���ֵķ���
		@Override
		public void callPauseMusic() {
			
			pauseMusic();
		}

		//���ü������ŵķ��� 
		@Override
		public void callrePlayMusic() {
			
			rePlayMusic();
		}
		
	}
	
	
	
}
