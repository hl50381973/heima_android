package com.itheima.localservice;

import com.itheima.remoteservice.Iservice;
import com.itheima.remoteservice.Iservice.Stub;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private MyConn conn;


	private Iservice iservice; //是我们的中间人对象 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]调用bindservice 获取我们定义的中间人对象 
		
		Intent intent = new Intent();
		//设置一个action
		intent.setAction("com.itheima.remoteservice");
		conn = new MyConn();
		//[2]目的是为了获取我们定义的中间人对象
		bindService(intent, conn,BIND_AUTO_CREATE);
		
		
	}

	
	//点击按钮 调用第8个应用程序服务里面的方法
	public void click(View v) {
		try {
			iservice.callTestMethod();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	//当Activity销毁的时候调用
	@Override
	protected void onDestroy() {  
		//当Activity销毁的时候  取消绑定服务
		unbindService(conn);
		super.onDestroy();
	}
	
	//监视服务的状态
	private class MyConn implements ServiceConnection{


		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			//获取中间人对象 
			
		iservice = Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	
}
