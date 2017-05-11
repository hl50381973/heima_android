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

	private Iservice iservice; // 这个就是我们定义的中间人对象
	private MyConn conn;
	private static SeekBar sbar;  
	public  static Handler handler = new Handler(){
		//当 接收到消息该方法执行
		public void handleMessage(android.os.Message msg) {
			//[1]获取msg 携带的数据 
			Bundle data = msg.getData();
			//[2]获取当前进度和总进度
			int duration = data.getInt("duration");
			int currentPosition = data.getInt("currentPosition");
			
			//[3]设置seekbar的最大进度和当前进度 
			sbar.setMax(duration);  //设置进度条的最大值
			sbar.setProgress(currentPosition);//设置当前进度
			
			
			
		};
	};
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sbar = (SeekBar) findViewById(R.id.seekBar1);
		
		
		//[0]先调用startservice 方法开启服务 保证服务在后台长期运行
		Intent intent = new Intent(this, MusicService.class);
		startService(intent);
		
		// [1]调用bindservice 目的是为了获取我们定义的中间人对象
		conn = new MyConn();
		// 连接MusicService 服务 获取我们定义的中间人对象
		bindService(intent, conn, BIND_AUTO_CREATE);

		//[2]给seekbar 设置监听 

		sbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			//当停止拖动执行
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
				//设置播放的位置 
				iservice.callSeekToPosition(seekBar.getProgress());
			}
			//开始拖动
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
			}
		});
		
	}

	// 点击按钮 进行 音乐播放
	public void click1(View v) {

		// 调用播放音乐的方法
		iservice.callPlayMusic();
	}

	// 暂停音乐
	public void click2(View v) {

		// 调用暂停音乐的方法
		iservice.callPauseMusic();
	}

	// 继续播放
	public void click3(View v) {

		// 调用继续播放
		iservice.callrePlayMusic();
	}

	// 当Activity销毁的时候调用
	@Override
	protected void onDestroy() {
		// 在Activity销毁的时候 取消绑定服务
		unbindService(conn);

		super.onDestroy();
	}

	private class MyConn implements ServiceConnection {

		// 当连接成功时候调用
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// 获取我们定义的中间人对象
			iservice = (Iservice) service;

		}

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

	}

}
