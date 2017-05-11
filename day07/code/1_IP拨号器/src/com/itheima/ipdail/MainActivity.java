package com.itheima.ipdail;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_number;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_number = (EditText) findViewById(R.id.et_number);
	}

	
	//点击按钮 获取用户输入的iP号码 进行保存 
	public void click(View v) {
		//[1]获取到用户输入的number
		String number = et_number.getText().toString().trim();
		//[2]使用sp 保存起来 
		SharedPreferences sp = getSharedPreferences("config", 0);
		//[3]存数据 
		sp.edit().putString("ipnumber", number).commit();
		Toast.makeText(getApplicationContext(), "保存成功", 0).show();
		
		
	}
	
}
