package com.itheima.appstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AppStateReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//获取到当前广播的事件类型 
		String action = intent.getAction();
		if ("android.intent.action.PACKAGE_INSTALL".equals(action)) {
			
			System.out.println("应用被安装了");
		}else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
			System.out.println("~~~~~~应用被安装了");
			
		}else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
			System.out.println("应用被卸载了"+intent.getData());
			
		}
		
	}

}
