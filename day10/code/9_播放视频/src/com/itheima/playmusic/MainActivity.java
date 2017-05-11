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
	private int currentPosition; //��ǰ��Ƶ���ŵ�λ��

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//�ҵ��ؼ� 
		final SurfaceView sfv = (SurfaceView) findViewById(R.id.sfv);
			
			
			final SurfaceHolder surfaceHolder = sfv.getHolder();
			
			//���һ��callback
			surfaceHolder.addCallback(new Callback() {
				//��surfaceview���ٵ�ʱ�����
				@Override
				public void surfaceDestroyed(SurfaceHolder holder) {
					System.out.println("surfaceDestroyed");
					if (player!=null && player.isPlaying()) {
						
						//��ȡ��ǰ��Ƶ���ŵ�λ��
						
						currentPosition = player.getCurrentPosition();
						player.stop(); 
						
					}
					
				}
				
				//��surfaceview ��ʼ����
				@Override
				public void surfaceCreated(SurfaceHolder holder) {
					//[1]��ʼ��mediaplayer 
					  player = new MediaPlayer();
					
					//[2]����Ҫ���ŵ���Դ  path �����Ǳ���Ҳ��������·�� 
					try {
						player.setDataSource("http://192.168.13.89:8080/cc.MP4");
						
						//[2.1]���ò�����Ƶ������ SurfaceHolder  ������ά����Ƶ���ŵ�����
						player.setDisplay(surfaceHolder);
						
						//[3]׼������ 
//						player.prepare();
						player.prepareAsync(); 
						//����һ��׼����ɵļ���
						player.setOnPreparedListener(new OnPreparedListener() {
							
							@Override
							public void onPrepared(MediaPlayer mp) {
								//[4]��ʼ���� 
								player.start();
								//[5]�����ϴε�λ�ü������� 
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
