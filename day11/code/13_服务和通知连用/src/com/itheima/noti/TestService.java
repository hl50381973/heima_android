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

	//当服务第一次开启的时候 
	@Override
	public void onCreate() {
		//确保这个服务运行在前台进程
//		startForeground(id, notification)
		
		super.onCreate();
	}
	
}
