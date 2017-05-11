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

	private Iservice iservice; // 这个就是我们定义的中间人对象
	private MyConn conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//[0]先调用startservice 方法开启服务 保证服务在后台长期运行
		Intent intent = new Intent(this, MusicService.class);
		startService(intent);
		
		// [1]调用bindservice 目的是为了获取我们定义的中间人对象
		conn = new MyConn();
		// 连接MusicService 服务 获取我们定义的中间人对象
		bindService(intent, conn, BIND_AUTO_CREATE);

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
