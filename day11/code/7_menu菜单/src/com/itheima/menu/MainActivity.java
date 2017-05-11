package com.itheima.menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
//		[1]getMenuInflater().inflate(R.menu.main, menu);
		
	   //[2]添加菜单 
		menu.add(0, 1, 0, "后退");
		menu.add(0, 2, 0, "前进");
		return true;
	}
	
	//想知道具体点击的是menu的哪个条目 需要重写这个方法
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			
			System.out.println("后退");
			break;
			
	case 2:
		System.out.println("前进");
			break;

		default:
			break;
		}
		
		
		return super.onOptionsItemSelected(item);
	}
	
	//当点击menu按键的时候执行这个方法 
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		
		//弹出一个对话框 
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("警告");
		builder.setMessage("您的网络异常");
		builder.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				System.out.println("点了确定");
			}
		});
		builder.setNegativeButton("取消", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//点击取消执行 
				System.out.println("取消");
				
			}
		});
		//使用对话框一定要记得show出来 
		builder.show();
		
		return false;
	}
	
	//点击按钮跳转TestActivity
	public void click(View v) {
		Intent intent = new Intent(this,TestActity.class);
		startActivity(intent);
		
	}

}
