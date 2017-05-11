package com.itheima.service;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources.Theme;
import android.view.Menu;
import android.view.View;

/**
 * activity 你大爷 是 服务
 * 
 * @author jhon
 * 
 */
public class MainActivity extends Activity {

	private MyConn conn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	// 点击按钮开启服务
	public void click1(View v) {

		Intent intent = new Intent(this, FirstService.class);
		// 开启服务
		startService(intent);

	}

	// 点击按钮停止服务
	public void click2(View v) {
		Intent intent = new Intent(this, FirstService.class);
		stopService(intent);
	}

	// 点击按钮通过 bindservice 方式去开启服务
	public void click3(View v) {
		Intent intent = new Intent(this,FirstService.class);
		
		//连接到服务FirstService 
		
		 conn = new MyConn();
		 System.out.println("bind----"+conn);
		 bindService(intent,conn, BIND_AUTO_CREATE);
		
		
	}

	//点击按钮 取消绑定服务
	public void click4(View v) {
		 System.out.println("unbind----"+conn);
		unbindService(conn);
	}
	
	//当activity销毁的时候调用
	@Override
	protected void onDestroy() {
		//当activity销毁的时候  取消绑定服务
		unbindService(conn);
		
		super.onDestroy();
	}
	
	
	
	
	//用来监听服务的状态
	private class MyConn implements ServiceConnection{

		//连接成功后调用
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
		}

		//失去连接调用
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	
}
