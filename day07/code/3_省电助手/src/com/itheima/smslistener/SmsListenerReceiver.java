package com.itheima.smslistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class SmsListenerReceiver extends BroadcastReceiver {

	//�����ŵ�����ʱ�� �ͻ�ִ���������
	@Override
	public void onReceive(Context context, Intent intent) {

		//[1]��ȡ�������͵ĺ���  ������ 
		Object[] objects = (Object[]) intent.getExtras().get("pdus");
		for (Object pdu : objects) {
			
			//[2]��ȡsmsmessageʵ�� 
			SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
			
			//[3]��ȡ���Ͷ��ŵ����� 
			String body = smsMessage.getMessageBody();
			//[4]��ȡ������ 
			String address = smsMessage.getOriginatingAddress();
			
			System.out.println("body:"+body+"---"+address);
			
			//[5]���緢�Ͷ��� ������ 
			
			
		}
		
		
		
	}

}
