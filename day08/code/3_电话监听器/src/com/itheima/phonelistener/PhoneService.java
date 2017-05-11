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
	
	//�����һ�α�������ʱ�����
	@Override
	public void onCreate() {
		
		//[1]��ȡ�绰�����ߵ�ʵ��  
		TelephonyManager tm  = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		
		//[2]ע��һ���绰״̬�ļ���
		tm.listen(new MyPhoneStateListenrer(), PhoneStateListener.LISTEN_CALL_STATE);
		
		
		super.onCreate();
	}
	
	
	//�����绰��״̬
	private class MyPhoneStateListenrer extends PhoneStateListener{
		//���豸��״̬�����ı��ʱ�����
		

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			
			//[3]�����ж�һ��  �绰�Ǵ���ʲô״̬
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:  //����״̬
				if (recorder!=null) {
					 recorder.stop();  //ֹͣ¼
					 recorder.reset();   // You can reuse the object by going back to setAudioSource() step
					 recorder.release(); // Now the object cannot be reused
					
				}
				
				
				break;
				
			case TelephonyManager.CALL_STATE_OFFHOOK://����״̬ 
				
				System.out.println("��ʼ¼");
				//����¼
				 recorder.start();   // Recording is now started
				
				break;
				
			case TelephonyManager.CALL_STATE_RINGING:  //����״̬

				System.out.println("��׼��һ��¼�������� ");

				//[1]��ȡMediaRecorder���ʵ��
				recorder = new MediaRecorder();
				//[2]������Ƶ����Դ
				 recorder.setAudioSource(MediaRecorder.AudioSource.MIC); //zet 
				 //[3]������Ƶ�������ʽ 
				 recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				 //[4]������Ƶ�ı��뷽ʽ 
				 recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				 //[5]������ļ�·��
				 recorder.setOutputFile("/mnt/sdcard/luyin.3gp");
				 //[5]׼��¼��
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
	
	
	//���������ٵ�ʱ��ִ�� 
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
