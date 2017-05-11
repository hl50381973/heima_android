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
 * activity ���ү �� ����
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

	// �����ť��������
	public void click1(View v) {

		Intent intent = new Intent(this, FirstService.class);
		// ��������
		startService(intent);

	}

	// �����ťֹͣ����
	public void click2(View v) {
		Intent intent = new Intent(this, FirstService.class);
		stopService(intent);
	}

	// �����ťͨ�� bindservice ��ʽȥ��������
	public void click3(View v) {
		Intent intent = new Intent(this,FirstService.class);
		
		//���ӵ�����FirstService 
		
		 conn = new MyConn();
		 System.out.println("bind----"+conn);
		 bindService(intent,conn, BIND_AUTO_CREATE);
		
		
	}

	//�����ť ȡ���󶨷���
	public void click4(View v) {
		 System.out.println("unbind----"+conn);
		unbindService(conn);
	}
	
	//��activity���ٵ�ʱ�����
	@Override
	protected void onDestroy() {
		//��activity���ٵ�ʱ��  ȡ���󶨷���
		unbindService(conn);
		
		super.onDestroy();
	}
	
	
	
	
	//�������������״̬
	private class MyConn implements ServiceConnection{

		//���ӳɹ������
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
		}

		//ʧȥ���ӵ���
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	
}
