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

	//点击按钮发送一条无序广播
	public void click(View v) {
		
		Intent intent = new Intent();
		//设置action 
		intent.setAction("com.itheima.custombroadcast");
		
		intent.putExtra("name", "新闻联播每天晚上7点准时开整!!!");
		//发送一条广播 发送无序广播
		sendBroadcast(intent);
		
	}
}
