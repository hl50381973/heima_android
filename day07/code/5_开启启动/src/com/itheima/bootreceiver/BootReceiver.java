package com.itheima.bootreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

	//���ֻ�������ִ���������
	@Override
	public void onReceive(Context context, Intent intent) {

		//����mainActivity
		Intent intent2 = new Intent(context,MainActivity.class);
		
		//�� ����ڹ㲥���濪��Activity Ҫ����һ������ջ����
		intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		
		//�ڹ㲥���������濪��activity
		context.startActivity(intent2);
		
		
		
	}

}
