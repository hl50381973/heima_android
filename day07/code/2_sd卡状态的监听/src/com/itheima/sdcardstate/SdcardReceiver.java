package com.itheima.sdcardstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SdcardReceiver extends BroadcastReceiver {

	//��sd����ж�� ���߱�����������ʱ�� ��ִ��
	@Override
	public void onReceive(Context context, Intent intent) {

		//[1]��ȡ����ǰ�㲥���¼����� 
		String action = intent.getAction();
		//[2]��action��һ���ж� 
		if("android.intent.action.MEDIA_UNMOUNTED".equals(action)){
			System.out.println("˵��sd�� ж����");
			
		}else if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
			
			System.out.println("˵��sd��������");
		}
		
		
		
		
	}

}
