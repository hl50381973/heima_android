package com.itheima.otherhandler;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	private Handler mHandler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView tv_simple = (TextView) findViewById(R.id.tv_simple);
	
		
		//审计机制  什么时候才去检测子线程更新UI, 面试：子线程一定不能更新UI？ SurfaceView ：多媒体视频播放 ,可以在子线程中更新UI； Progress（进度）相关的控件：也是可以在子线程中更新Ui
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			/*	//使用activity的runOnUiThread方法更新ui,无论当前线程是否是主线程，都将在主线程执行
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						tv_simple.setText("我被更新了");
					}
				});*/
				
				
				
				mHandler.postDelayed(new Runnable() {
					
					@Override
					public void run() {

						tv_simple.setText("我被更新了");
					}
				}, 1000*5);
				
				
			}
		}).start();
		
	}
	
	//activity的生命周期，

	@Override
	protected void onResume() {
		super.onResume();
	}

}
