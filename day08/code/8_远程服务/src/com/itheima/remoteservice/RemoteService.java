package com.itheima.remoteservice;

import com.itheima.remoteservice.Iservice.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

//Զ�̷���
public class RemoteService extends Service {

	//[2]�����Ƕ�����м��˶��󷵻�
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}

	
	//�ڷ������涨��һ������
	
	public void testMethod(){
		System.out.println("����Զ�̷�������ķ���");
	}
	
	//[1]�����м��˶��� 
	private class MyBinder extends Stub{

		//����testMethod����
		@Override
		public void callTestMethod() {
			
			testMethod();
		}
		
	}
	
}
