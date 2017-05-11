package com.itheima.appstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AppStateReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//��ȡ����ǰ�㲥���¼����� 
		String action = intent.getAction();
		if ("android.intent.action.PACKAGE_INSTALL".equals(action)) {
			
			System.out.println("Ӧ�ñ���װ��");
		}else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
			System.out.println("~~~~~~Ӧ�ñ���װ��");
			
		}else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
			System.out.println("Ӧ�ñ�ж����"+intent.getData());
			
		}
		
	}

}
