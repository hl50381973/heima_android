package com.itheima.sendrice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	//�����ť  ���ʹ��� 
	public void click(View v) {
		
		//����һ������㲥 
		Intent intent = new Intent();
		//����һ��action
		intent.setAction("com.itheima.rice");
		/**
		 * receiverPermission ���յ�Ȩ��
		 * resultReceiver ��Ϊһ�����յ�receive  ����ܹ����յ��㲥 
		 */
		sendOrderedBroadcast(intent, null, new FinalReceiver(), null, 1, "ϰ����ÿ��������1000�����", null);
		
		
	}

}
