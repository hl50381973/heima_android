package com.itheima.playmusic;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import com.itheima.playvide.R;

public class MainActivity extends Activity {

	private MediaPlayer player;
	private int currentPosition; //当前视频播放的位置

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//找到控件 
		final SurfaceView sfv = (SurfaceView) findViewById(R.id.sfv);
			
			
			final SurfaceHolder surfaceHolder = sfv.getHolder();
			
			//添加一个callback
			surfaceHolder.addCallback(new Callback() {
				//当surfaceview销毁的时候调用
				@Override
				public void surfaceDestroyed(SurfaceHolder holder) {
					System.out.println("surfaceDestroyed");
					if (player!=null && player.isPlaying()) {
						
						//获取当前视频播放的位置
						
						currentPosition = player.getCurrentPosition();
						player.stop(); 
						
					}
					
				}
				
				//当surfaceview 初始化了
				@Override
				public void surfaceCreated(SurfaceHolder holder) {
					//[1]初始化mediaplayer 
					  player = new MediaPlayer();
					
					//[2]设置要播放的资源  path 可以是本地也可是网络路径 
					try {
						player.setDataSource("http://192.168.13.89:8080/cc.MP4");
						
						//[2.1]设置播放视频的内容 SurfaceHolder  是用来维护视频播放的内容
						player.setDisplay(surfaceHolder);
						
						//[3]准备播放 
//						player.prepare();
						player.prepareAsync(); 
						//设置一个准备完成的监听
						player.setOnPreparedListener(new OnPreparedListener() {
							
							@Override
							public void onPrepared(MediaPlayer mp) {
								//[4]开始播放 
								player.start();
								//[5]继续上次的位置继续播放 
								player.seekTo(currentPosition);
								
							}
						});
						
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				@Override
				public void surfaceChanged(SurfaceHolder holder, int format, int width,
						int height) {
					
				}
			});
			
			

			
			
		
		
		
		
	}
	
}
