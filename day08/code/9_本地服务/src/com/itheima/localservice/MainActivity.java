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


	private Iservice iservice; //�����ǵ��м��˶��� 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]����bindservice ��ȡ���Ƕ�����м��˶��� 
		
		Intent intent = new Intent();
		//����һ��action
		intent.setAction("com.itheima.remoteservice");
		conn = new MyConn();
		//[2]Ŀ����Ϊ�˻�ȡ���Ƕ�����м��˶���
		bindService(intent, conn,BIND_AUTO_CREATE);
		
		
	}

	
	//�����ť ���õ�8��Ӧ�ó����������ķ���
	public void click(View v) {
		try {
			iservice.callTestMethod();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	//��Activity���ٵ�ʱ�����
	@Override
	protected void onDestroy() {  
		//��Activity���ٵ�ʱ��  ȡ���󶨷���
		unbindService(conn);
		super.onDestroy();
	}
	
	//���ӷ����״̬
	private class MyConn implements ServiceConnection{


		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			//��ȡ�м��˶��� 
			
		iservice = Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	
}
