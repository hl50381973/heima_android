package com.itheima.smslistener;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.database.ContentObserver;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]注册一个内容观察者 
		Uri uri = Uri.parse("content://sms/");
		getContentResolver().registerContentObserver(uri, true, new MyContentObserver(new Handler()));
		
	}

	private class MyContentObserver extends ContentObserver{

		public MyContentObserver(Handler handler) {
			super(handler);
		}
		//当观察的内容发生改变的时候调用
		@Override
		public void onChange(boolean selfChange) {
			System.out.println("哈哈哈  短信的数据库发生了改变");
			super.onChange(selfChange);
		}
		
	}
	

}
