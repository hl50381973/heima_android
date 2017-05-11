package com.itheima.whybindservice;

import com.itheima.interfacemethod.R;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private Iservice myBinder; //��������Ƕ�����м��˶���
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		//�������� 
		Intent intent = new Intent(this,TestService.class);
		//���ӷ��� TestService
		MyConn conn = new  MyConn();
		//�󶨷��� 
		bindService(intent, conn, BIND_AUTO_CREATE);
		
	}

	
	//�����ť ����TestService ��������İ�֤���� 
	public void click(View v) {
		//ͨ�����Ƕ�����м��˶��� ��ӵ��÷�������ķ���
		myBinder.callBanZheng(1020000);
//		myBinder.callPlayMaJiang();
//		myBinder.callXiSangNa();
		
		myBinder.callPlayMaJiang();
		
		
	}
	
	//���ӷ����״̬
	private class MyConn implements ServiceConnection{

		

		//�����ӷ���ɹ���
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			//[4]��ȡ���Ƕ�����м��˶��� 
			myBinder = (Iservice) service;
		}

		//ʧȥ����
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	
	
}
