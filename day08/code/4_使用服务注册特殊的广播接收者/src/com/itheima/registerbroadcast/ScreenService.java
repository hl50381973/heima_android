package com.itheima.registerbroadcast;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class ScreenService extends Service {
	
	private ScreenReceiver receiver;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	//当服务第一次启动的时候调用
	@Override
	public void onCreate() {
		
		//在这个方法里面注册广播接收者
		//[1]获取ScreenReceiver实例
        receiver = new ScreenReceiver();
		
        //[2]创建IntentFilter对象
		IntentFilter filter = new IntentFilter();
		//[3]添加注册的事件
		filter.addAction("android.intent.action.SCREEN_OFF");
		filter.addAction("android.intent.action.SCREEN_ON");
		//[4]通过代码的方式注册
		registerReceiver(receiver, filter);
		
		super.onCreate();
	}
	
	//当服务销毁的时候调用
	@Override
	public void onDestroy() {
		
		//当actvivity销毁的时候  取消注册广播接收者 
		unregisterReceiver(receiver);
				
		
		super.onDestroy();
	}

}
