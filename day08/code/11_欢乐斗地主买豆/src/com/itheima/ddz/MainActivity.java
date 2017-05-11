package com.itheima.ddz;

import com.itheima.alipay.Iservice;
import com.itheima.alipay.Iservice.Stub;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Myconn conn;
	private Iservice iservice; //我们定义的中间人对象
 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]调用bindService 获取我们定义的中间人对象 
		Intent intent = new Intent();
		intent.setAction("com.itheima.alipay");
		
		conn = new Myconn();
		//[2]绑定服务
		bindService(intent, conn, BIND_AUTO_CREATE);
		
		
		
	}

	//点击按钮 买豆 
	public void click(View v) {
		
		try {
			boolean result = iservice.callPay("abcdd", "123", 100);
			
			if (result) {
				//支付成功 
				Toast.makeText(getApplicationContext(), "买豆成功", 1).show();
			}else {
				
				Toast.makeText(getApplicationContext(), "买豆失败", 1).show();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private class Myconn implements ServiceConnection{

	
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
	    // 获取中间人对象 
			
		iservice = Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	
	@Override
	protected void onDestroy() {
		//当Activity销毁的时候 解绑服务 
		unbindService(conn);
		super.onDestroy();
	}
	
	
}

