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
		//执行我们的动画
		iv = (ImageView) findViewById(R.id.iv);
		
		//设置一个点击事件
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "哈哈 你点不到我", 1).show();
			}
		});
	}


	//点击按钮 实现iv 透明的效果  动画 
	public void click1(View v) { 
		Animation aa = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
		
		//iv开始执行动画 
		iv.startAnimation(aa);
		
	}
	

	//点击按钮 实现iv 执行一个旋转 动画 
	public void click2(View v) { 
		Animation ra = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
		
		//iv开始执行动画 
		iv.startAnimation(ra);
		
	}
	
	//点击按钮进行一个缩放动画
	public void click3(View v) { 
	
		Animation sa= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
		
		//iv开始执行动画 
		iv.startAnimation(sa);
	}

	//位移动画 
	public void click4(View v){
		Animation ta = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
 		//开始动画
 		iv.startAnimation(ta);
	}
	
	//动画一起飞
	public void click5(View v){
		Animation set = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
		
		//最后一步 要记得 执行动画
		iv.startAnimation(set);
		
		
	}
}
