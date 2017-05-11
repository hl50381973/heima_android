package com.itheima.tiger;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		//1.找到控件
		ListView lv_tiger1 = (ListView) findViewById(R.id.lv_tiger1);
		ListView lv_tiger2 = (ListView) findViewById(R.id.lv_tiger2);
		ListView lv_tiger3 = (ListView) findViewById(R.id.lv_tiger3);
		//创建adapter设置给listviev
		TigerAdapter tigerAdapter = new TigerAdapter();
		lv_tiger1.setAdapter(tigerAdapter);
		lv_tiger2.setAdapter(tigerAdapter);
		lv_tiger3.setAdapter(tigerAdapter);
	}

	class TigerAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return 500;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			TextView view = null;
			//复用convertView
			if(convertView != null){
				view = (TextView) convertView;
			}else{
				view = 	new TextView(mContext);
			}

			Random random = new Random();
			int number = random.nextInt(100);
			if(number <20){
				view.setTextColor(Color.parseColor("#ff00ff"));//设置textview文字颜色
				view.setText("桃");
			}else if(number < 40){
				view.setTextColor(Color.YELLOW);//设置textview文字颜色
				view.setText("杏");
			}else if(number <60){
				view.setTextColor(Color.GREEN);//设置textview文字颜色
				view.setText("梨");
			}else if(number <80){
				view.setTextColor(Color.RED);//设置textview文字颜色
				view.setText("枣");
			}else {
				view.setTextColor(Color.parseColor("#666666"));//设置textview文字颜色
				view.setText("瓜");
			}
			
			view.setTextSize(58);
			
			return view;
		}

	}
}
