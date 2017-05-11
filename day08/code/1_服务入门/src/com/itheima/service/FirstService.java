package com.itheima.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * �������  ��Ҫ���嵥�ļ���������
 * @author jhon
 *
 */
public class FirstService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		
		System.out.println("onBind");
		return null;
	}

	//�������һ�α�������ʱ�����
	@Override
	public void onCreate() {
		System.out.println("onCreate");
		super.onCreate();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	//�������ٵ�ʱ��ִ��
	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}
	
}
