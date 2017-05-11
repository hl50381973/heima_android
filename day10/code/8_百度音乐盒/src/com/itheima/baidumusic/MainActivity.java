package com.itheima.baidumusic;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

	private Iservice iservice; // ����������Ƕ�����м��˶���
	private MyConn conn;
	private static SeekBar sbar;  
	public  static Handler handler = new Handler(){
		//�� ���յ���Ϣ�÷���ִ��
		public void handleMessage(android.os.Message msg) {
			//[1]��ȡmsg Я�������� 
			Bundle data = msg.getData();
			//[2]��ȡ��ǰ���Ⱥ��ܽ���
			int duration = data.getInt("duration");
			int currentPosition = data.getInt("currentPosition");
			
			//[3]����seekbar�������Ⱥ͵�ǰ���� 
			sbar.setMax(duration);  //���ý����������ֵ
			sbar.setProgress(currentPosition);//���õ�ǰ����
			
			
			
		};
	};
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sbar = (SeekBar) findViewById(R.id.seekBar1);
		
		
		//[0]�ȵ���startservice ������������ ��֤�����ں�̨��������
		Intent intent = new Intent(this, MusicService.class);
		startService(intent);
		
		// [1]����bindservice Ŀ����Ϊ�˻�ȡ���Ƕ�����м��˶���
		conn = new MyConn();
		// ����MusicService ���� ��ȡ���Ƕ�����м��˶���
		bindService(intent, conn, BIND_AUTO_CREATE);

		//[2]��seekbar ���ü��� 

		sbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			//��ֹͣ�϶�ִ��
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
				//���ò��ŵ�λ�� 
				iservice.callSeekToPosition(seekBar.getProgress());
			}
			//��ʼ�϶�
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
			}
		});
		
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
