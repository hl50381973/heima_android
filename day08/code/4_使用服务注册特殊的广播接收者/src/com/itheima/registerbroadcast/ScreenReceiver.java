package com.itheima.registerbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//获取广播事件的类型
		String action = intent.getAction();
		
		if ("android.intent.action.SCREEN_OFF".equals(action)) {
			
			System.out.println("说明屏幕锁屏了");
		}else if("android.intent.action.SCREEN_ON".equals(action)){
			
			System.out.println("说明屏幕解锁了");
		}
		
		
		
	}

}
