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

	//点击按钮 往短信数据库里面插入一条记录 
	public void click(View v) {
		//[1]由于短信的数据库已经通过内容提供者暴露出来了 所以我想操作数据库 直接通过内容的解析者 
		Uri uri = Uri.parse("content://sms/");
		//[2]创建ContentValues 
		ContentValues values = new ContentValues();
		values.put("address", "18632525");//招商银行
		values.put("body", "请您马上过来一趟 否则后果自负");
		values.put("date", System.currentTimeMillis());
		getContentResolver().insert(uri, values);
		
		
	}

}
