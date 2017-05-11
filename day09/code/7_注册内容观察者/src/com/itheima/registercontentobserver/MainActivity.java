package com.itheima.registercontentobserver;

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
		
		//[1]注册内容观察者 
		Uri uri = Uri.parse("content://com.itheima.provider/");
		//false 观察的uri 必须是一个确切的uri  如果是true
		getContentResolver().registerContentObserver(uri, true, new MyContentObserver(new Handler()));
		
		
	}

	//定义内容观察者
	private class MyContentObserver extends ContentObserver{

		public MyContentObserver(Handler handler) {
			super(handler);
		}
		
		//当我们观察的uri发生改变的时候调用
		@Override
		public void onChange(boolean selfChange) {
			System.out.println("哈哈 数据库被操作了 ");
			
			super.onChange(selfChange);
		}
		
	}
	
	

}
