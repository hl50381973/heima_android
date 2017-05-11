package com.itheima.autocompletetextview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

	//[0]声明AutoCompleteTextView要显示的数据
	  private static final String[] COUNTRIES = new String[] {
	         "laofang", "laozhang", "laoli", "laobi","laoli","laowang","aab","abb","cc"
	     };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//[1]找到控件
		AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.actv);
		
		//[2]创建数据适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);

        //[3]设置数据适配器
        actv.setAdapter(adapter);
	}



}
