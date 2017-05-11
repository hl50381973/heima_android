package com.itheima.registerbroadcast;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class ScreenService extends Service {
	
	private ScreenReceiver receiver;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	//�������һ��������ʱ�����
	@Override
	public void onCreate() {
		
		//�������������ע��㲥������
		//[1]��ȡScreenReceiverʵ��
        receiver = new ScreenReceiver();
		
        //[2]����IntentFilter����
		IntentFilter filter = new IntentFilter();
		//[3]���ע����¼�
		filter.addAction("android.intent.action.SCREEN_OFF");
		filter.addAction("android.intent.action.SCREEN_ON");
		//[4]ͨ������ķ�ʽע��
		registerReceiver(receiver, filter);
		
		super.onCreate();
	}
	
	//���������ٵ�ʱ�����
	@Override
	public void onDestroy() {
		
		//��actvivity���ٵ�ʱ��  ȡ��ע��㲥������ 
		unregisterReceiver(receiver);
				
		
		super.onDestroy();
	}

}
