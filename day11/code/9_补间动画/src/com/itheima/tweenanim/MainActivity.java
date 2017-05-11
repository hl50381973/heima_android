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
		//1.0意味着着完全不透明 0.0意味着完全透明
		AlphaAnimation aa = new AlphaAnimation(1.0f, 0.0f);
		aa.setDuration(2000); //设置动画执行的时间
		aa.setRepeatCount(1); //设置重复的次数
		aa.setRepeatMode(Animation.REVERSE);//设置动画执行的模式
		//iv开始执行动画 
		iv.startAnimation(aa);
		
	}
	

	//点击按钮 实现iv 执行一个旋转 动画 
	public void click2(View v) { 
		//fromDegrees 开始角度   toDegrees 结束角度
//		RotateAnimation  ra = new RotateAnimation(0, 360);	
		RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(2000); //设置动画执行的时间
		ra.setRepeatCount(1); //设置重复的次数
		ra.setRepeatMode(Animation.REVERSE);//设置动画执行的模式
		//iv开始执行动画 
		iv.startAnimation(ra);
		
	}
	
	//点击按钮进行一个缩放动画
	public void click3(View v) { 
		ScaleAnimation sa = new ScaleAnimation(1.0f,2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(2000); //设置动画执行的时间
		sa.setRepeatCount(1); //设置重复的次数
		sa.setRepeatMode(Animation.REVERSE);//设置动画执行的模式
		//iv开始执行动画 
		iv.startAnimation(sa);
	}

	//位移动画 
	public void click4(View v){
		TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.2f);
 		ta.setDuration(2000); //设置动画执行的时间
 		ta.setFillAfter(true);//当动画结束后 动画停留在结束位置
 		
 		//开始动画
 		iv.startAnimation(ta);
	}
	
	//动画一起飞
	public void click5(View v){
		AnimationSet set = new AnimationSet(false);
		
		//透明动画
		AlphaAnimation aa = new AlphaAnimation(1.0f, 0.0f);
		aa.setDuration(2000); //设置动画执行的时间
		aa.setRepeatCount(1); //设置重复的次数
		aa.setRepeatMode(Animation.REVERSE);//设置动画执行的模式
		//旋转动画
		RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(2000); //设置动画执行的时间
		ra.setRepeatCount(1); //设置重复的次数
		ra.setRepeatMode(Animation.REVERSE);//设置动画执行的模式
		//缩放
		ScaleAnimation sa = new ScaleAnimation(1.0f,2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(2000); //设置动画执行的时间
		sa.setRepeatCount(1); //设置重复的次数
		sa.setRepeatMode(Animation.REVERSE);//设置动画执行的模式
		
		TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.2f);
 		ta.setDuration(2000); //设置动画执行的时间
 		ta.setFillAfter(true);//当动画结束后 动画停留在结束位置
 		
		//添加动画
		set.addAnimation(aa);
		set.addAnimation(ra);
		set.addAnimation(sa);
		set.addAnimation(ta);
		
		//最后一步 要记得 执行动画
		iv.startAnimation(set);
		
		
	}
}
