package com.itheima.sdcardstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SdcardReceiver extends BroadcastReceiver {

	//当sd卡被卸载 或者被挂载上来的时候 会执行
	@Override
	public void onReceive(Context context, Intent intent) {

		//[1]获取到当前广播的事件类型 
		String action = intent.getAction();
		//[2]对action做一个判断 
		if("android.intent.action.MEDIA_UNMOUNTED".equals(action)){
			System.out.println("说明sd卡 卸载了");
			
		}else if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
			
			System.out.println("说明sd卡挂载了");
		}
		
		
		
		
	}

}
