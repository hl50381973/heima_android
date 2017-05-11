package com.itheima.life;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("onCreate");
	}

	// 当activity销毁的时候调用
	@Override
	protected void onDestroy() {

		System.out.println("onDestroy");
		super.onDestroy();
	}

	// 当界面可见的时候调用
	@Override
	protected void onStart() {
		System.out.println("onStart");
		super.onStart();
	}

	// 当页面不可见的时候调用
	@Override
	protected void onStop() {
		System.out.println("onStop");
		super.onStop();
	}


	//当页面被重新启动的时候调用
	@Override
	protected void onRestart() {
		
		System.out.println("onRestart");
		super.onRestart();
	}
	

	//获取焦点 当按钮可以被点击了
	@Override
	protected void onResume() {
		System.out.println("onResume");
		super.onResume();
	}
	
	//当界面失去焦点  当按钮不可以被点击 
	@Override
	protected void onPause() {
		System.out.println("onPause");
		super.onPause();
	}

	//点击按钮 跳转到 TestActivity页面 
	public void click(View v) {
		
		Intent intent = new Intent(this,TestActivity.class);
		startActivity(intent);
	}
	
}
