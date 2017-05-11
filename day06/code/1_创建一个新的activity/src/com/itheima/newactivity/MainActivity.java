package com.itheima.newactivity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载一个布局
		setContentView(R.layout.activity_main);
		
	}

	//点击按钮 实现拨打电话的逻辑
	public void click1(View v) {
		//[1]创建意图对象  意图 :你想干一件什么事情
		Intent intent = new Intent();
		//[2]设置意图的action(动作)
		intent.setAction(Intent.ACTION_CALL);
		//[3]设置数据 data
		intent.setData(Uri.parse("tel:"+119)); //给119打电话 
		//[4]开启activity   记得加上call_phone的权限
        startActivity(intent); 
		
		
	}
	
	

	//点击按钮 跳转到TestActivity
	public void click2(View v) {
		//[1]创建意图对象 
		Intent intent = new Intent();
		//[2]设置意图的action(动作)
		intent.setAction("com.itheima.testactivity");
		//[3]设置一个category
		intent.addCategory("android.intent.category.DEFAULT");
		
		//[3.2]设置数据类型 type 这个方法会自动清除通过setdata方法设置的数据
//		intent.setType("aa/bb");
		
		//[3.1]设置一个data
		intent.setData(Uri.parse("itheima:"+119));
		
	
		//☆☆☆☆☆注意 如果type 和 data同时使用的时候  应该用这个方法
//		intent.setDataAndType(Uri.parse("itheima1:"+119), "aa/bb1");
		
		//[4]开启activity   记得加上call_phone的权限
        startActivity(intent); 
		
		
	}
	
	//点击按钮 跳转到TestActivity2页面  
	public void click3(View v) {
		//[1]创建意图对象 
	    Intent intent = new Intent(this,TestActivity2.class);
		//[2]指定包名和类名 开启 页面 
//	    intent.setClassName("com.itheima.newactivity", "com.itheima.newactivity.TestActivity2");
		//[3]开启activity   
        startActivity(intent); 
	    
	}
	
	
	
	
}
