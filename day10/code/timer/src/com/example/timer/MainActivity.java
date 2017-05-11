package com.example.timer;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private Timer timer;
	private TimerTask task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//创建定时器
		
		timer = new Timer();
		//创建task
		task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("啊哈哈 我执行了");
			}
		};
		
		//2秒钟后 执行run方法 
		timer.schedule(task, 5000,1000);
		
		
	}

	@Override
	protected void onDestroy() {
		//当Activity销毁的时候取消timer
		timer.cancel();
		task.cancel();
		super.onDestroy();
	}

}
