package com.itheima.carmea;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// 点击按钮 进行照相
	public void click1(View v) {

		// 照相 创建意图
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		// 存放图片的路径
		File file = new File(Environment.getExternalStorageDirectory()
				.getPath(), "haha.png");
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file)); // set the
																		// image
																		// file
																		// name
		// 开启一个activity 并获取结果
		startActivityForResult(intent, 1);

	}

	// 点击按钮 进行录像
	public void click2(View v) {

		// 照相 创建意图
		Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		// 存放图片的路径
		File file = new File(Environment.getExternalStorageDirectory()
				.getPath(), "haha.3gp");
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file)); // set the
																		// image
																		// file
																		// name
		// 开启一个activity 并获取结果
		startActivityForResult(intent, 2);

	}

	// 当开启的这个Activity页面的关闭的时候调用
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		System.out.println("哈哈 方法调用了");
		super.onActivityResult(requestCode, resultCode, data);
	}

}
