package com.itheima.screen;

import android.os.Bundle;
import android.app.Activity;
import android.content.IntentFilter;
import android.view.Menu;

public class MainActivity extends Activity {

	private ScreenReceiver screenReceiver;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		
		/* <receiver android:name="com.itheima.screen.ScreenReceiver">
         <intent-filter >
             <action android:name="android.intent.action.SCREEN_OFF"/>
             <action android:name="android.intent.action.SCREEN_ON"/>
         </intent-filter>
     </receiver>*/
     
		//[1]动态的去注册屏幕解锁和锁屏的广播
		screenReceiver = new ScreenReceiver();
		//[2]创建intent-filter对象
		IntentFilter filter = new IntentFilter();
		//[3]添加要注册的action
		filter.addAction("android.intent.action.SCREEN_OFF");
		filter.addAction("android.intent.action.SCREEN_ON");
		//[4]注册广播接收者
		this.registerReceiver(screenReceiver, filter);
		
		
	}
	
	
	@Override
	protected void onDestroy() {
		//当activity销毁的时候  取消注册广播接收者
		unregisterReceiver(screenReceiver);
		
		super.onDestroy();
	}

	
}
