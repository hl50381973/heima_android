package com.itheima.propertyanimator;

import android.os.Bundle;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载的布局
		setContentView(R.layout.activity_main);
		
		//找到iv 执行动画
		iv = (ImageView) findViewById(R.id.iv);
		//设置了一个点击事件
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(MainActivity.this, "你点不到我", 0).show();
			}
		});
		

//		iv.setTranslationX(translationX)
//		iv.setScaleX(scaleX)
//		iv.setAlpha(alpha)
//		iv.setRotation(rotation)
		
		
	}

	//位移动画
	public void translate(View v){
		//创建属性动画
		/**
		 * target 执行的目标  
		 * propertyName 属性名字  The name of the property being animated.
		 * float... values 可变参数 
		 */
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationX", 10, 50,20,100);
		oa.setDuration(2000);
		oa.start(); //开始动画
		
	}
	//缩放动画
	public void scale(View v){
		
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "scaleY", 0.1f, 2, 1, 2);
		oa.setDuration(2000);
		oa.start();
	}
	
	//实现透明的效果 
	public void alpha(View v){
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "alpha", 0, 0.5f, 0, 1,0,1);
		oa.setDuration(2000);
		oa.start();
	}
	
	//实现旋转的效果
	public void rotate(View v){
//		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotation", 0, 180, 90, 360);
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotationX", 0, 180, 90, 360);
		oa.setDuration(2000);
		oa.start();
	}
	
	
	//一起飞 
	public void fly(View v){
		AnimatorSet as = new AnimatorSet();
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationX", 10, 50, 20, 100);
		ObjectAnimator oa2 = ObjectAnimator.ofFloat(iv, "scaleY", 0.1f, 2, 1, 2);
		ObjectAnimator oa3 = ObjectAnimator.ofFloat(iv, "alpha", 0, 0.5f, 0, 1);
		ObjectAnimator oa4 = ObjectAnimator.ofFloat(iv, "rotationY", 0, 180, 90, 360);
		as.setDuration(2000);//执行动画时长
		as.setTarget(iv);//iv执行动画
		//往集合中添加动画
		//挨个飞
		as.playSequentially(oa, oa2, oa3, oa4);
		//一起飞
//		as.playTogether(oa, oa2, oa3, oa4);
		as.start();
	}
	
	//使用xml的方式创建属性动画
	public void playxml(View v){
		
		ObjectAnimator oa = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.oanimator);
		//设置执行目标
		oa.setTarget(iv);
		oa.start();//开始执行
	}
}
