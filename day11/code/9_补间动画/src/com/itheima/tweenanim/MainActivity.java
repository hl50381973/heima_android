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
		//1.0��ζ������ȫ��͸�� 0.0��ζ����ȫ͸��
		AlphaAnimation aa = new AlphaAnimation(1.0f, 0.0f);
		aa.setDuration(2000); //���ö���ִ�е�ʱ��
		aa.setRepeatCount(1); //�����ظ��Ĵ���
		aa.setRepeatMode(Animation.REVERSE);//���ö���ִ�е�ģʽ
		//iv��ʼִ�ж��� 
		iv.startAnimation(aa);
		
	}
	

	//�����ť ʵ��iv ִ��һ����ת ���� 
	public void click2(View v) { 
		//fromDegrees ��ʼ�Ƕ�   toDegrees �����Ƕ�
//		RotateAnimation  ra = new RotateAnimation(0, 360);	
		RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(2000); //���ö���ִ�е�ʱ��
		ra.setRepeatCount(1); //�����ظ��Ĵ���
		ra.setRepeatMode(Animation.REVERSE);//���ö���ִ�е�ģʽ
		//iv��ʼִ�ж��� 
		iv.startAnimation(ra);
		
	}
	
	//�����ť����һ�����Ŷ���
	public void click3(View v) { 
		ScaleAnimation sa = new ScaleAnimation(1.0f,2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(2000); //���ö���ִ�е�ʱ��
		sa.setRepeatCount(1); //�����ظ��Ĵ���
		sa.setRepeatMode(Animation.REVERSE);//���ö���ִ�е�ģʽ
		//iv��ʼִ�ж��� 
		iv.startAnimation(sa);
	}

	//λ�ƶ��� 
	public void click4(View v){
		TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.2f);
 		ta.setDuration(2000); //���ö���ִ�е�ʱ��
 		ta.setFillAfter(true);//������������ ����ͣ���ڽ���λ��
 		
 		//��ʼ����
 		iv.startAnimation(ta);
	}
	
	//����һ���
	public void click5(View v){
		AnimationSet set = new AnimationSet(false);
		
		//͸������
		AlphaAnimation aa = new AlphaAnimation(1.0f, 0.0f);
		aa.setDuration(2000); //���ö���ִ�е�ʱ��
		aa.setRepeatCount(1); //�����ظ��Ĵ���
		aa.setRepeatMode(Animation.REVERSE);//���ö���ִ�е�ģʽ
		//��ת����
		RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(2000); //���ö���ִ�е�ʱ��
		ra.setRepeatCount(1); //�����ظ��Ĵ���
		ra.setRepeatMode(Animation.REVERSE);//���ö���ִ�е�ģʽ
		//����
		ScaleAnimation sa = new ScaleAnimation(1.0f,2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(2000); //���ö���ִ�е�ʱ��
		sa.setRepeatCount(1); //�����ظ��Ĵ���
		sa.setRepeatMode(Animation.REVERSE);//���ö���ִ�е�ģʽ
		
		TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.2f);
 		ta.setDuration(2000); //���ö���ִ�е�ʱ��
 		ta.setFillAfter(true);//������������ ����ͣ���ڽ���λ��
 		
		//��Ӷ���
		set.addAnimation(aa);
		set.addAnimation(ra);
		set.addAnimation(sa);
		set.addAnimation(ta);
		
		//���һ�� Ҫ�ǵ� ִ�ж���
		iv.startAnimation(set);
		
		
	}
}
