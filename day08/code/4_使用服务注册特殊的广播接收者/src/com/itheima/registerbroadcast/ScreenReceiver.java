package com.itheima.registerbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//��ȡ�㲥�¼�������
		String action = intent.getAction();
		
		if ("android.intent.action.SCREEN_OFF".equals(action)) {
			
			System.out.println("˵����Ļ������");
		}else if("android.intent.action.SCREEN_ON".equals(action)){
			
			System.out.println("˵����Ļ������");
		}
		
		
		
	}

}
