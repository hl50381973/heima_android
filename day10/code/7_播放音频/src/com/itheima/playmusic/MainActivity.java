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

	//�����ť ������������
	public void click(View v) {
		//[1]��ʼ��mediaplayer 
		final MediaPlayer player = new MediaPlayer();
		
		//[2]����Ҫ���ŵ���Դ  path �����Ǳ���Ҳ��������·�� 
		try {
			player.setDataSource("http://192.168.13.89:8080/xpg.mp3");
			
			//[3]׼������ 
//			player.prepare();
			player.prepareAsync(); 
			//����һ��׼����ɵļ���
			player.setOnPreparedListener(new OnPreparedListener() {
				
				@Override
				public void onPrepared(MediaPlayer mp) {
					//[4]��ʼ���� 
					player.start();
				}
			});
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
