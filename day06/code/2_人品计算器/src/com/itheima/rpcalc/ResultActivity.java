package com.itheima.rpcalc;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 加载页面
		setContentView(R.layout.activity_result);
		// [1]找到我们关心的控件
		TextView tv_name = (TextView) findViewById(R.id.tv_name);
		TextView tv_sex = (TextView) findViewById(R.id.tv_sex);
		TextView tv_result = (TextView) findViewById(R.id.tv_result);

		// [2]获取开启此Activity的意图对象
		Intent intent = getIntent();
		// [3]获取我们携带过来的数据 取出性别和name 传递的是什么样的数据类型 你在取的时候
		String name = intent.getStringExtra("name");// 获取name
		int sex = intent.getIntExtra("sex", 0);

		// [4]把数据显示到控件上
		tv_name.setText(name); // 显示姓名

		// [5]显示性别
		byte[] bytes = null;
		
		try {
			switch (sex) {
			case 1: // 代表男
				tv_sex.setText("男");
				bytes = name.getBytes("gbk");
				
				break;

			case 2:
				tv_sex.setText("女");
				bytes = name.getBytes("utf-8");
				break;

			case 3:
				tv_sex.setText("人妖");
				bytes= name.getBytes("iso-8859-1");
				break;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		//[6]根据我们输入的姓名和性别 来计算人品得分  根据得分显示结果  
		int  total = 0;
		for (byte b : bytes) {     //0001 1000
			  int number =b&0xff;             //1111 1111
			  total+=number;
		}
		
		//算出得分 
		int score = Math.abs(total)%100;
		if (score >90) {
			tv_result.setText("您的人品非常好 您家的祖坟都冒青烟了");
		}else if (score >70) {
			tv_result.setText("有你这样的人品算是不错了..");
		}else if (score >60) {
			tv_result.setText("您的人品刚刚及格");
		}else{
			tv_result.setText("您的人品不及格....");
			
		}
			
		
		
	}

}
