package com.itheima.gupiao;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
	
		//����һ�����߳� 
		new Thread(){public void run() {
			//ģ��һ�¹�ƱӦ�õĳ���
			while(true){
				
				SystemClock.sleep(1000);
				System.out.println("ȥ������ȡ����.....");
			}
			
			
		};}.start();
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
