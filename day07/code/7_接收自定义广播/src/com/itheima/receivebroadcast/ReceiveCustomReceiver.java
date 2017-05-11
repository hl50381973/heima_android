package com.itheima.receivebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiveCustomReceiver extends BroadcastReceiver {

	//���ҷ����Զ���㲥��ʱ�� ��������ͻ���յ� 
	@Override
	public void onReceive(Context context, Intent intent) {

		//[0]��ֹ�㲥
//		abortBroadcast();
		
		//[1]ȡ�����Ƿ��͹㲥Я�������� 
		String content = intent.getStringExtra("name");
		//[2]�ѻ�ȡ��������չʾ��toast��
		Toast.makeText(context, content, 0).show();
		
	}

}
