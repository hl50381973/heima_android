package com.itheima.whybindservice;

import com.itheima.whybindservice.TestService.MyBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private MyBinder myBinder; //这个是我们定义的中间人对象
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		//开启服务 
		Intent intent = new Intent(this,TestService.class);
		//连接服务 TestService
		MyConn conn = new  MyConn();
		//绑定服务 
		bindService(intent, conn, BIND_AUTO_CREATE);
		
	}

	
	//点击按钮 调用TestService 服务里面的办证方法 
	public void click(View v) {
		//通过我们定义的中间人对象 间接调用服务里面的方法
		myBinder.callBanZheng(102);
		
	}
	
	//监视服务的状态
	private class MyConn implements ServiceConnection{

		

		//当连接服务成功后
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			//[4]获取我们定义的中间人对象 
			
			myBinder = (MyBinder) service;
		}

		//失去连接
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	
	
}
