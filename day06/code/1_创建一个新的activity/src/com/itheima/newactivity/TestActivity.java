package com.itheima.newactivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * ����һ���µ�Activity
 * @author jhon
 *
 */
public class TestActivity extends Activity {

	/**
	 * Called when the activity is starting.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//����һ������
		setContentView(R.layout.activity_test);
		//(1)Return the intent that started this activity. ���ؿ������Activity����ͼ����
		Intent intent = getIntent();
		
		//(2)��ȡ����  
		Uri data = intent.getData();
		
		String scheme = data.getScheme();
		
		System.out.println("data-:"+scheme);
		
		
		
		
	}
	
}
