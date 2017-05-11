package com.itheima.syf;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]�ҵ�iv ��ʾ���ǲ�����ͼƬ 
		final ImageView iv = (ImageView) findViewById(R.id.iv);
		
		//[2]������Ҫ������ͼƬת����bitmap
		Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pre19);
		
		//[3]����ԭͼ�ĸ���  
		
		//[3.1]����ģ��
		final Bitmap alterbBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
		//[3.2]��alterbBitmap bitmapΪģ�崴��һ������ 
		Canvas canvas = new Canvas(alterbBitmap);
		//[3.3]����һ������ 
		Paint paint = new Paint();
		//[3.4]��ʼ���� 
		canvas.drawBitmap(srcBitmap, new Matrix(), paint);
		
		//[4]��alterbitmap��ʾ��iv�� 
		iv.setImageBitmap(alterbBitmap);
		
		//[5]��iv����һ�������¼� 
		iv.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//[6]��ȡ�����¼������� 
				int action = event.getAction();
				switch (action) {
					
				case MotionEvent.ACTION_MOVE: //�ƶ�  
					
					for (int i = -7; i < 7; i++) {  //�ı�x 
						
						for (int j = -7; j <7; j++) {
							//Ϊ�� ���õ��û����� ˺һ��Բ 
							if (Math.sqrt(i*i+j*j)<7) {
								//һ���޸�һ������ 
								try {
									alterbBitmap.setPixel((int)event.getX()+i, (int)event.getY()+j, Color.TRANSPARENT);
								} catch (Exception e) {
								}
							}
							
							
						}
						
					}
				
					
					//һ��Ҫ�ǵø���iv
					iv.setImageBitmap(alterbBitmap);
					break;

				}
				
				return true;
			}
		});
		
		
		
	}

}
