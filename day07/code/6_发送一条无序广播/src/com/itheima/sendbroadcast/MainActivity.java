package com.itheima.sendbroadcast;

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

	//�����ť����һ������㲥
	public void click(View v) {
		
		Intent intent = new Intent();
		//����action 
		intent.setAction("com.itheima.custombroadcast");
		
		intent.putExtra("name", "��������ÿ������7��׼ʱ����!!!");
		//����һ���㲥 ��������㲥
		sendBroadcast(intent);
		
	}
}
