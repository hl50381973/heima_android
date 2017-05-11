package com.itheima.smslistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class SmsListenerReceiver extends BroadcastReceiver {

	//当短信到来的时候 就会执行这个方法
	@Override
	public void onReceive(Context context, Intent intent) {

		//[1]获取发短信送的号码  和内容 
		Object[] objects = (Object[]) intent.getExtras().get("pdus");
		for (Object pdu : objects) {
			
			//[2]获取smsmessage实例 
			SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdu);
			
			//[3]获取发送短信的内容 
			String body = smsMessage.getMessageBody();
			//[4]获取发送者 
			String address = smsMessage.getOriginatingAddress();
			
			System.out.println("body:"+body+"---"+address);
			
			//[5]比如发送短信 扣流量 
			
			
		}
		
		
		
	}

}
