package com.itheima.frameanim;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// [1]找到iv控件 用来显示动画效果
		ImageView rocketImage = (ImageView) findViewById(R.id.iv);
		// [2]设置背景资源
		rocketImage.setBackgroundResource(R.drawable.my_anim);
		// [3]获取AnimationDrawable 类型
		AnimationDrawable ad = (AnimationDrawable) rocketImage.getBackground();
		// [4]开始执行动画
		ad.start();

	}

}
