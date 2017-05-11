package com.itheima.logcat;

import com.itheima.logcat.utils.LogUtils;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	private String tag ="MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//tag: 标签  msg:信息
		LogUtils.e(tag, "我是e级别");
		LogUtils.w(tag, "我是w级别");
		LogUtils.i(tag, "我是i级别");
		LogUtils.d(tag, "我是d级别");
		LogUtils.v(tag, "我是v级别");
		
	}



}
