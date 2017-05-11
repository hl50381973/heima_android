package com.itheima.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * 定义服务  需要在清单文件里面配置
 * @author jhon
 *
 */
public class FirstService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		
		System.out.println("onBind");
		return null;
	}

	//当服务第一次被开启的时候调用
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
	
	//服务销毁的时候执行
	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}
	
}
