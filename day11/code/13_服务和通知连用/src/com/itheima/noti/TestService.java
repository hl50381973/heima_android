package com.itheima.noti;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TestService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	//�������һ�ο�����ʱ�� 
	@Override
	public void onCreate() {
		//ȷ���������������ǰ̨����
//		startForeground(id, notification)
		
		super.onCreate();
	}
	
}
