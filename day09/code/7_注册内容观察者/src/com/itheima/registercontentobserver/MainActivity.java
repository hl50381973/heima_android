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
		
		//[1]ע�����ݹ۲��� 
		Uri uri = Uri.parse("content://com.itheima.provider/");
		//false �۲��uri ������һ��ȷ�е�uri  �����true
		getContentResolver().registerContentObserver(uri, true, new MyContentObserver(new Handler()));
		
		
	}

	//�������ݹ۲���
	private class MyContentObserver extends ContentObserver{

		public MyContentObserver(Handler handler) {
			super(handler);
		}
		
		//�����ǹ۲��uri�����ı��ʱ�����
		@Override
		public void onChange(boolean selfChange) {
			System.out.println("���� ���ݿⱻ������ ");
			
			super.onChange(selfChange);
		}
		
	}
	
	

}
