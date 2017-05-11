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
     
		//[1]��̬��ȥע����Ļ�����������Ĺ㲥
		screenReceiver = new ScreenReceiver();
		//[2]����intent-filter����
		IntentFilter filter = new IntentFilter();
		//[3]���Ҫע���action
		filter.addAction("android.intent.action.SCREEN_OFF");
		filter.addAction("android.intent.action.SCREEN_ON");
		//[4]ע��㲥������
		this.registerReceiver(screenReceiver, filter);
		
		
	}
	
	
	@Override
	protected void onDestroy() {
		//��activity���ٵ�ʱ��  ȡ��ע��㲥������
		unregisterReceiver(screenReceiver);
		
		super.onDestroy();
	}

	
}
