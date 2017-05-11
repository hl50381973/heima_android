package com.itheima.registerbroadcast;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//开启服务 
		
		Intent intent = new Intent(this,ScreenService.class);
		//开启服务
		startService(intent);
		
	}

	
	

}
