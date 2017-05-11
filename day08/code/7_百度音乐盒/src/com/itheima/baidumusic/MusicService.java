package com.itheima.baidumusic;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

//音乐播放服务
public class MusicService extends Service {

	//[2]把我们定义的中间人对象 返回
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}
	//服务第一次开启的是调用
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	
	//当服务销毁的时候调用
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	//专门用来播放音乐的 
	public void playMusic(){
		System.out.println("音乐播放了");
		//TODO 等讲完多媒体 把该功能完善
		
	}
	
	//音乐暂停了
	public void pauseMusic(){
		System.out.println("音乐暂停了");
	}
	
	//音乐继续播放的方法
	public void  rePlayMusic(){
		System.out.println("音乐继续播放了");
	}
	
	//[1]定义一个中间人对象(IBinder) 
	private class MyBinder extends Binder implements Iservice{

		//调用播放音乐的方法
		@Override
		public void callPlayMusic() {
			
			playMusic();
		}

		//调用暂停音乐的方法
		@Override
		public void callPauseMusic() {
			
			pauseMusic();
		}

		//调用继续播放的方法 
		@Override
		public void callrePlayMusic() {
			
			rePlayMusic();
		}
		
	}
	
	
	
}
