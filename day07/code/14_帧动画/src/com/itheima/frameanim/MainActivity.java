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
		// [1]�ҵ�iv�ؼ� ������ʾ����Ч��
		ImageView rocketImage = (ImageView) findViewById(R.id.iv);
		// [2]���ñ�����Դ
		rocketImage.setBackgroundResource(R.drawable.my_anim);
		// [3]��ȡAnimationDrawable ����
		AnimationDrawable ad = (AnimationDrawable) rocketImage.getBackground();
		// [4]��ʼִ�ж���
		ad.start();

	}

}
