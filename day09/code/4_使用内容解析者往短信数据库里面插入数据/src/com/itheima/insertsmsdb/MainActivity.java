package com.itheima.insertsmsdb;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//�����ť ���������ݿ��������һ����¼ 
	public void click(View v) {
		//[1]���ڶ��ŵ����ݿ��Ѿ�ͨ�������ṩ�߱�¶������ ��������������ݿ� ֱ��ͨ�����ݵĽ����� 
		Uri uri = Uri.parse("content://sms/");
		//[2]����ContentValues 
		ContentValues values = new ContentValues();
		values.put("address", "18632525");//��������
		values.put("body", "�������Ϲ���һ�� �������Ը�");
		values.put("date", System.currentTimeMillis());
		getContentResolver().insert(uri, values);
		
		
	}

}
