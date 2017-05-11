package com.itheima.dyncaddfragment;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.WindowManager;

@SuppressLint("CommitTransaction")
public class MainActivity extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// [1]获取手机的宽和高 windommanager
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		// [2]判断横竖屏

		// [3.1]获取fragment的管理者
		FragmentManager manager = getFragmentManager();
		// [3.2]开启一个事务
		FragmentTransaction transaction = manager.beginTransaction();

		if (height > width) {
			// 说明是竖屏 androind 代表系统定义好的 android.R.id.content理解成是当前手机的窗体
			transaction.replace(android.R.id.content, new Fragment1());

		} else {
			// 横屏
			transaction.replace(android.R.id.content, new Fragment2());
		}

		//[4]一定要记得 提交commit 
		transaction.commit();
		
		
	}

}
