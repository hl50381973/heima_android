package com.itheima.newactivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * 创建一个新的Activity
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
		//加载一个布局
		setContentView(R.layout.activity_test);
		//(1)Return the intent that started this activity. 返回开启这个Activity的意图对象
		Intent intent = getIntent();
		
		//(2)获取数据  
		Uri data = intent.getData();
		
		String scheme = data.getScheme();
		
		System.out.println("data-:"+scheme);
		
		
		
		
	}
	
}
