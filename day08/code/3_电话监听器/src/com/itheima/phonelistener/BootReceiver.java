package com.itheima.phonelistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

	//���ֻ������� ��ִ�и÷��� 
	@Override
	public void onReceive(Context context, Intent intent) {

		//�Ͱѿ���������߼� �ŵ� ��������� 
		
		Intent intent1 = new Intent(context,PhoneService.class);
		//�������� 
		context.startService(intent1);
		
	}

}
