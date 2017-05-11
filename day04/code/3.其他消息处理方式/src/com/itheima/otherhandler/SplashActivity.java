package com.itheima.otherhandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_splash);
		
		//是handler开启延时任务
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
					//跳转到应用主界面
					Intent intent = new Intent(SplashActivity.this,MainActivity.class);
					startActivity(intent);
					
					
			}
		}, 5*1000);
		
		
	}
	
}
