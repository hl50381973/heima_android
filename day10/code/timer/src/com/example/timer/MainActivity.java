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
		
		
		//������ʱ��
		
		timer = new Timer();
		//����task
		task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("������ ��ִ����");
			}
		};
		
		//2���Ӻ� ִ��run���� 
		timer.schedule(task, 5000,1000);
		
		
	}

	@Override
	protected void onDestroy() {
		//��Activity���ٵ�ʱ��ȡ��timer
		timer.cancel();
		task.cancel();
		super.onDestroy();
	}

}
