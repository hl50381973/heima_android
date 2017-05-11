package com.itheima.rpcalc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_name;
	private RadioGroup rg_group;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//(1)找到我们关心的控件
		et_name = (EditText) findViewById(R.id.et_name);
		rg_group = (RadioGroup) findViewById(R.id.rg_group);
		
	}

	//点击按钮 获取数据 跳转到resultActivity页面 
	public void click(View v) {
		
		//[1]获取用户名
		String name = et_name.getText().toString().trim();
		if (TextUtils.isEmpty(name)) {
			Toast.makeText(getApplicationContext(), "用户名不能为空", Toast.LENGTH_LONG).show();
			return;
		}
		
		//[2]判断选中性别
		int checkedRadioButtonId = rg_group.getCheckedRadioButtonId();
		//[3]判断一下具体选中的性别 
		int sex = 0; //默认值为0
		switch (checkedRadioButtonId) {
		case R.id.rb_male:   //选中的是男
			sex = 1;
			break;
			
		case R.id.rb_female: //选中的是女
			sex = 2;
			
			break;

		case R.id.rb_other: //代表选中的是人妖
			sex = 3;
			break;
		}
		//[4]判断性别
		if (sex == 0) {
			Toast.makeText(getApplicationContext(), "亲 请选择性别 ", 0).show();
			return;
		}

		//[5] 跳转到resutActivity页面  显示意图
		Intent intent = new Intent(this,ResultActivity.class);
		
		//[5.1]要把name 和 sex 传递到结果页面  底层map
		intent.putExtra("name", name);
		intent.putExtra("sex", sex);
		
		//[6]开启Activity
		startActivity(intent);
		
		
		
	}
	

}
