package com.itheima.paint;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
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

	private Bitmap srcBitmap;
	private ImageView iv;
	private Bitmap copyBitmap;
	private Canvas canvas;
	private Paint paint;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//[1]�ҵ�imageview  ��ʾ���ǻ������� 
		iv = (ImageView) findViewById(R.id.iv);
		
		//[2]��bgת����bitmap 
		srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
		//[2.1]����ģ�� 
		copyBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
		//[2.2]��copybitmapΪģ��  ����һ������ 
		canvas = new Canvas(copyBitmap);
		//[2.3]����һ������ 
		paint = new Paint();
		//[2.4]��ʼ���� 
		canvas.drawBitmap(srcBitmap, new Matrix(), paint);
		
//		canvas.drawLine(20, 20, 30, 50, paint);
		
		//[3]��copybitmap��ʾ��iv�� 
		iv.setImageBitmap(copyBitmap);
		
		//[4]��iv����һ�������¼� 
		iv.setOnTouchListener(new OnTouchListener() {
			
			int startX = 0;
			int startY = 0;
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				//[5]��ȡ��ָ�������¼����� 
				int action = event.getAction();
				//[6]�����ж�һ����ʲô�¼����� 
				switch (action) {
				case MotionEvent.ACTION_DOWN: //���� 
					//[7]��ȡ��ָ�������� 
				    startX = (int) event.getX();
					startY= (int) event.getY();
					System.out.println("����:"+startX+"---"+startY);
					break;
					
				case MotionEvent.ACTION_MOVE://�ƶ� 
					//[8]��ȡֹͣ������  
					int stopX = (int) event.getX();
					int stopY = (int) event.getY();
					
					System.out.println("�ƶ�:"+stopX+"---"+stopY);
					
					//[9]���� 
					canvas.drawLine(startX, startY, stopX, stopY, paint);
					
					//[9.1]����һ��������� 
					startX = stopX;
					startY = stopY;
					
					//[10]�ǵø���ui 
					iv.setImageBitmap(copyBitmap);
					
					
					break;
					
				case MotionEvent.ACTION_UP: //̧��;

					break;
				}
				return true;
			}
		});
		
		
		
	}

	//�����ť�û��ʵ���ɫ ��ɺ�ɫ 
	public void click1(View v) {
		//���û�����ɫ
		paint.setColor(Color.RED);
	}
	
	
	//�û�����ɫ���
	public void click2(View v) {
		//���û��ʵĿ��
		paint.setStrokeWidth(15);
		
	}
	
	//������� 
	public void click3(View v) {
		/**
		 * format ����ͼƬ�ĸ�ʽ 
		 * 
		 * quality ������Ƭ������
		 */
		try {
			File file = new File(Environment.getExternalStorageDirectory().getPath(),"dazuo.png");
			FileOutputStream fos = new FileOutputStream(file);
			copyBitmap.compress(CompressFormat.PNG, 100, fos);
			
			//����һ��sd�����������Ĺ㲥 ��ƭһ��ϵͳͼ��Ӧ�� ˵sd���������� ��ȥ����ͼƬ��
			
			Intent intent = new Intent();
			//����action
			intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
			//����data 
			intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
			
			//��������㲥
			sendBroadcast(intent);
			
			fos.close(); //�ر���
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}
