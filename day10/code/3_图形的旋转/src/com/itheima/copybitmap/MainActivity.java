package com.itheima.copybitmap;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	

	private float degrees;// ͼƬ��ת�ĽǶ�
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]�ҵ����ǹ��ĵĿؼ� 
		ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
		final ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
		
		//[2] ��tomcat.png ת����bitmap Ȼ����ʾ��iv_src 
		final Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tomcat);
		
		//[2.1 test] �޸�ԭͼ   ԭͼ�����Ա��޸�
		//srcBitmap.setPixel(20, 30, Color.RED);
		
		iv_src.setImageBitmap(srcBitmap);
		
		
		new Thread(){public void run() {
			
			for (int i = 0; i < 100; i++) {
				
				degrees += 5;
				
				//[3]����ԭͼ   
				
				//[3.1]����ģ��  
				final Bitmap copybitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
				//[3.2]������ ��Ҫһ������   ��copybitmapΪģ��  
				Canvas  canvas = new Canvas(copybitmap);
				//[3.3]����һ������  
				Paint paint = new Paint();
				//[3.4]��ʼ����   srcBitmap�ο�ԭͼȥ��
				 Matrix matrix = new Matrix();
				
				 //[3.5]��ͼƬ������ת   
				 matrix.setRotate(degrees, srcBitmap.getWidth()/2, srcBitmap.getHeight()/2);
				canvas.drawBitmap(srcBitmap,matrix, paint);
				
				//�� ע�ⲻ�������̸߳���ui 
				runOnUiThread(new  Runnable() {
					public void run() {
						//�������������߼�һ���������߳�ִ��
						//[4]��copybitmap��ʾ��iv_copy��
						iv_copy.setImageBitmap(copybitmap);
						
					}
				});
				
				SystemClock.sleep(1000);
						
			}
			
			
			
		};}.start();
		
		
		
		
	}

	
}
