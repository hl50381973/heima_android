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


	//点击按钮  发送大米 
	public void click(View v) {
		
		//发送一条有序广播 
		Intent intent = new Intent();
		//设置一个action
		intent.setAction("com.itheima.rice");
		/**
		 * receiverPermission 接收的权限
		 * resultReceiver 最为一个最终的receive  最后都能够接收到广播 
		 */
		sendOrderedBroadcast(intent, null, new FinalReceiver(), null, 1, "习大大给每个村民发了1000斤大米", null);
		
		
	}

}
