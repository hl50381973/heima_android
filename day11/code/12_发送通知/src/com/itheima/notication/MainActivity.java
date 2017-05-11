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
		//[1]获取通知的管理者 
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
	}

	//点击按钮发送通知
	public void click1(View v) {
		//链式调用  高版本的写法 
	/*	 Notification noti = new Notification.Builder(this)
         .setContentTitle("我是大标题")
         .setContentText("我是标题的内容")
         .setSmallIcon(R.drawable.ic_launcher)
         .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
         .build();*/
 
		
		//兼容低版本的写法  用过时的方法
		Notification noti = new Notification(R.drawable.ic_launcher, "接收到了一条通知", System.currentTimeMillis());
		
		//实现呼吸灯 震动一下  
		noti.defaults = Notification.DEFAULT_ALL;
		
		//不删除通知 
		noti.flags = Notification.FLAG_NO_CLEAR;
		
		//创建意图对象
		Intent intent = new Intent();
		//实现打电话的逻辑 
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:"+119));
		//需要添加打电话的权限 Task
		
		PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
		noti.setLatestEventInfo(this, "小芳", "今天晚上7天酒店....", pendingIntent);

		//[2]发送通知 
		nm.notify(10, noti);
		
	}
	
	//点击按钮 关闭通知
	public void click2(View v) {
		//取消通知
		nm.cancel(10);
	}

}
