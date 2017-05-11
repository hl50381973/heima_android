package com.itheima.notication;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private NotificationManager nm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//[1]��ȡ֪ͨ�Ĺ����� 
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
	}

	//�����ť����֪ͨ
	public void click1(View v) {
		//��ʽ����  �߰汾��д�� 
	/*	 Notification noti = new Notification.Builder(this)
         .setContentTitle("���Ǵ����")
         .setContentText("���Ǳ��������")
         .setSmallIcon(R.drawable.ic_launcher)
         .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
         .build();*/
 
		
		//���ݵͰ汾��д��  �ù�ʱ�ķ���
		Notification noti = new Notification(R.drawable.ic_launcher, "���յ���һ��֪ͨ", System.currentTimeMillis());
		
		//ʵ�ֺ����� ��һ��  
		noti.defaults = Notification.DEFAULT_ALL;
		
		//��ɾ��֪ͨ 
		noti.flags = Notification.FLAG_NO_CLEAR;
		
		//������ͼ����
		Intent intent = new Intent();
		//ʵ�ִ�绰���߼� 
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:"+119));
		//��Ҫ��Ӵ�绰��Ȩ�� Task
		
		PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
		noti.setLatestEventInfo(this, "С��", "��������7��Ƶ�....", pendingIntent);

		//[2]����֪ͨ 
		nm.notify(10, noti);
		
	}
	
	//�����ť �ر�֪ͨ
	public void click2(View v) {
		//ȡ��֪ͨ
		nm.cancel(10);
	}

}
