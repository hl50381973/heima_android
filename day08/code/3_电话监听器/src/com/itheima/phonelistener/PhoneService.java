package com.itheima.phonelistener;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;

public class PhoneService extends Service {

	
	private MediaRecorder recorder;
	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}
	
	//服务第一次被开启的时候调用
	@Override
	public void onCreate() {
		
		//[1]获取电话管理者的实例  
		TelephonyManager tm  = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		
		//[2]注册一个电话状态的监听
		tm.listen(new MyPhoneStateListenrer(), PhoneStateListener.LISTEN_CALL_STATE);
		
		
		super.onCreate();
	}
	
	
	//监听电话的状态
	private class MyPhoneStateListenrer extends PhoneStateListener{
		//当设备的状态发生改变的时候调用
		

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			
			//[3]具体判断一下  电话是处于什么状态
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:  //空闲状态
				if (recorder!=null) {
					 recorder.stop();  //停止录
					 recorder.reset();   // You can reuse the object by going back to setAudioSource() step
					 recorder.release(); // Now the object cannot be reused
					
				}
				
				
				break;
				
			case TelephonyManager.CALL_STATE_OFFHOOK://接听状态 
				
				System.out.println("开始录");
				//开启录
				 recorder.start();   // Recording is now started
				
				break;
				
			case TelephonyManager.CALL_STATE_RINGING:  //响铃状态

				System.out.println("我准备一个录音机出来 ");

				//[1]获取MediaRecorder类的实例
				recorder = new MediaRecorder();
				//[2]设置音频的来源
				 recorder.setAudioSource(MediaRecorder.AudioSource.MIC); //zet 
				 //[3]设置音频的输出格式 
				 recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				 //[4]设置音频的编码方式 
				 recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				 //[5]保存的文件路径
				 recorder.setOutputFile("/mnt/sdcard/luyin.3gp");
				 //[5]准备录音
				 try {
					recorder.prepare();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				break;
			}
			
			
			
			super.onCallStateChanged(state, incomingNumber);
		}
		
	}
	
	
	//当服务销毁的时候执行 
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
