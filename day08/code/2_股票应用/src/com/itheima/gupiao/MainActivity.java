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
		
	
	
		//开启一个子线程 
		new Thread(){public void run() {
			//模拟一下股票应用的场景
			while(true){
				
				SystemClock.sleep(1000);
				System.out.println("去服务器取数据.....");
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
