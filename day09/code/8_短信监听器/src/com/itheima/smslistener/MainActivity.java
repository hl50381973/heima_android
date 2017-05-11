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
		
		//[1]ע��һ�����ݹ۲��� 
		Uri uri = Uri.parse("content://sms/");
		getContentResolver().registerContentObserver(uri, true, new MyContentObserver(new Handler()));
		
	}

	private class MyContentObserver extends ContentObserver{

		public MyContentObserver(Handler handler) {
			super(handler);
		}
		//���۲�����ݷ����ı��ʱ�����
		@Override
		public void onChange(boolean selfChange) {
			System.out.println("������  ���ŵ����ݿⷢ���˸ı�");
			super.onChange(selfChange);
		}
		
	}
	

}
