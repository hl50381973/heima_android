package com.itheima.baidumusic;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;

//���ֲ��ŷ���
public class MusicService extends Service {

	private MediaPlayer player;

	//[2]�����Ƕ�����м��˶��� ����
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}
	//�����һ�ο������ǵ���
	@Override
	public void onCreate() {
		
		//[1]��ʼ��mediaplayer 
		player = new MediaPlayer();
		
		super.onCreate();
	}
	
	
	//���������ٵ�ʱ�����
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	//���ò�������ָ��λ�õķ���
	public void seekToPosition(int position){
		player.seekTo(position);
	}
	
	

	//ר�������������ֵ� 
	public void playMusic(){
		System.out.println("���ֲ�����");
		
		//[2]����Ҫ���ŵ���Դ  path �����Ǳ���Ҳ��������·�� 
				try {
					player.reset();
					
					player.setDataSource("/mnt/sdcard/xpg.mp3");
					
					//[3]׼������ 
					player.prepare(); 
					
					//[4]��ʼ���� 
					player.start();
					
					//[5]���½����� 
					updateSeekBar();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		
	}
	
	//���½������ķ��� 
	private void updateSeekBar() {
		//[1]��ȡ��ǰ������ʱ�� 
		final int duration = player.getDuration();
		//[2]һ���ӻ�ȡһ�ε�ǰ����  
		final Timer timer = new Timer();
		final TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				//[3]��ȡ��ǰ�����Ľ��� 
				int currentPosition = player.getCurrentPosition();
				
				//[4]����message����  
				Message msg = Message.obtain();
				//[5]ʹ��msgЯ���������   
				Bundle bundle = new Bundle();
				bundle.putInt("duration", duration);
				bundle.putInt("currentPosition", currentPosition);
				msg.setData(bundle);
				//������Ϣ MainActivity��handlemessage������ִ��
				MainActivity.handler.sendMessage(msg);
				
			}
		};
		//300����� ÿ��1���ӻ�ȡһ�ε�ǰ�����Ľ���
		timer.schedule(task, 300, 1000);
		//[3]������������ɵ�ʱ�� ��timer ��task ȡ�� 
		player.setOnCompletionListener(new OnCompletionListener() {
			
			//������������ɵĻص�
			@Override
			public void onCompletion(MediaPlayer mp) {
				System.out.println("������������� ");
				
				timer.cancel();
				task.cancel();
				
			}
		});
		
		
	}
	//������ͣ��
	public void pauseMusic(){
		System.out.println("������ͣ��");
		//��ͣ 
		player.pause();
		
	}
	
	//���ּ������ŵķ���
	public void  rePlayMusic(){
		System.out.println("���ּ���������");
		
		player.start();
		
	}
	
	//[1]����һ���м��˶���(IBinder) 
	private class MyBinder extends Binder implements Iservice{

		//���ò������ֵķ���
		@Override
		public void callPlayMusic() {
			
			playMusic();
		}

		//������ͣ���ֵķ���
		@Override
		public void callPauseMusic() {
			
			pauseMusic();
		}

		//���ü������ŵķ��� 
		@Override
		public void callrePlayMusic() {
			
			rePlayMusic();
		}

		//�������ò���ָ��λ�õķ��� 
		@Override
		public void callSeekToPosition(int position) {
			
			seekToPosition(position);
		}
		
	}
	
	
	
}
