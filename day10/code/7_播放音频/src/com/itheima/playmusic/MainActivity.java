package com.itheima.playmusic;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
		
		
	}

	//点击按钮 播放网络音乐
	public void click(View v) {
		//[1]初始化mediaplayer 
		final MediaPlayer player = new MediaPlayer();
		
		//[2]设置要播放的资源  path 可以是本地也可是网络路径 
		try {
			player.setDataSource("http://192.168.13.89:8080/xpg.mp3");
			
			//[3]准备播放 
//			player.prepare();
			player.prepareAsync(); 
			//设置一个准备完成的监听
			player.setOnPreparedListener(new OnPreparedListener() {
				
				@Override
				public void onPrepared(MediaPlayer mp) {
					//[4]开始播放 
					player.start();
				}
			});
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
