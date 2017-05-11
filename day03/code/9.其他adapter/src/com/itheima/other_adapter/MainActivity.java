package com.itheima.other_adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	public String []  classz =  {"android","ios","javaEE","C#"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//找到控件
		ListView lv_array = (ListView) findViewById(R.id.lv_array);
		ListView lv_simple = (ListView) findViewById(R.id.lv_simple);
		
		//创建一个arrayAdapter
//		context  , resource:布局id, textViewResourceId：条目布局中 textview控件的id, objects:条目上texitview显示的内容
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_listview_layout, R.id.item_tv_class, classz);
		lv_array.setAdapter(arrayAdapter);
		
		
		//创建一个simpleAdapter,封装simpleAdapter的数据
		ArrayList<Map<String, String>> arrayList = new ArrayList<Map<String,String>>();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("class", "C++");
		arrayList.add(hashMap);
		
		HashMap<String, String> hashMap1 = new HashMap<String, String>();
		hashMap1.put("class", "android");
		arrayList.add(hashMap1);
		
		
		HashMap<String, String> hashMap2 = new HashMap<String, String>();
		hashMap2.put("class", "javaEE");
		arrayList.add(hashMap2);
		
		//context, data:显示的数据, resource:item布局id, from: map中的key, to:布局中的控件id
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.item_listview_layout, new String[]{"class"}, new int[]{R.id.item_tv_class});
		
		lv_simple.setAdapter(simpleAdapter);
	}

	

}
