package com.itheima.baidumusic;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MainActivity extends Activity {

	private Iservice iservice; // ����������Ƕ�����м��˶���
	private MyConn conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//[0]�ȵ���startservice ������������ ��֤�����ں�̨��������
		Intent intent = new Intent(this, MusicService.class);
		startService(intent);
		
		// [1]����bindservice Ŀ����Ϊ�˻�ȡ���Ƕ�����м��˶���
		conn = new MyConn();
		// ����MusicService ���� ��ȡ���Ƕ�����м��˶���
		bindService(intent, conn, BIND_AUTO_CREATE);

	}

	// �����ť ���� ���ֲ���
	public void click1(View v) {

		// ���ò������ֵķ���
		iservice.callPlayMusic();
	}

	// ��ͣ����
	public void click2(View v) {

		// ������ͣ���ֵķ���
		iservice.callPauseMusic();
	}

	// ��������
	public void click3(View v) {

		// ���ü�������
		iservice.callrePlayMusic();
	}

	// ��Activity���ٵ�ʱ�����
	@Override
	protected void onDestroy() {
		// ��Activity���ٵ�ʱ�� ȡ���󶨷���
		unbindService(conn);

		super.onDestroy();
	}

	private class MyConn implements ServiceConnection {

		// �����ӳɹ�ʱ�����
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// ��ȡ���Ƕ�����м��˶���
			iservice = (Iservice) service;

		}

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

	}

}
