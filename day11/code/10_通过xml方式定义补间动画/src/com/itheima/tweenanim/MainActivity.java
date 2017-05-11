package com.itheima.tweenanim;

import android.os.Bundle;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView iv;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//ִ�����ǵĶ���
		iv = (ImageView) findViewById(R.id.iv);
		
		//����һ������¼�
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "���� ��㲻����", 1).show();
			}
		});
	}


	//�����ť ʵ��iv ͸����Ч��  ���� 
	public void click1(View v) { 
		Animation aa = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
		
		//iv��ʼִ�ж��� 
		iv.startAnimation(aa);
		
	}
	

	//�����ť ʵ��iv ִ��һ����ת ���� 
	public void click2(View v) { 
		Animation ra = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
		
		//iv��ʼִ�ж��� 
		iv.startAnimation(ra);
		
	}
	
	//�����ť����һ�����Ŷ���
	public void click3(View v) { 
	
		Animation sa= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
		
		//iv��ʼִ�ж��� 
		iv.startAnimation(sa);
	}

	//λ�ƶ��� 
	public void click4(View v){
		Animation ta = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
 		//��ʼ����
 		iv.startAnimation(ta);
	}
	
	//����һ���
	public void click5(View v){
		Animation set = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
		
		//���һ�� Ҫ�ǵ� ִ�ж���
		iv.startAnimation(set);
		
		
	}
}
