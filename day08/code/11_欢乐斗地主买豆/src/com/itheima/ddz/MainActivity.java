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
	private Iservice iservice; //���Ƕ�����м��˶���
 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]����bindService ��ȡ���Ƕ�����м��˶��� 
		Intent intent = new Intent();
		intent.setAction("com.itheima.alipay");
		
		conn = new Myconn();
		//[2]�󶨷���
		bindService(intent, conn, BIND_AUTO_CREATE);
		
		
		
	}

	//�����ť �� 
	public void click(View v) {
		
		try {
			boolean result = iservice.callPay("abcdd", "123", 100);
			
			if (result) {
				//֧���ɹ� 
				Toast.makeText(getApplicationContext(), "�򶹳ɹ�", 1).show();
			}else {
				
				Toast.makeText(getApplicationContext(), "��ʧ��", 1).show();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private class Myconn implements ServiceConnection{

	
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
	    // ��ȡ�м��˶��� 
			
		iservice = Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	
	@Override
	protected void onDestroy() {
		//��Activity���ٵ�ʱ�� ������ 
		unbindService(conn);
		super.onDestroy();
	}
	
	
}

