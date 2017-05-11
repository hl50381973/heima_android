package com.itheima.loadbigimg;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv;
	private int screenWidth;
	private int screenHeight;


	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]�ҵ�iv ��ʾ����ͼƬ 
		
		iv = (ImageView) findViewById(R.id.iv);
		
		//[2]��ȡ�ֻ��ķֱ���  ��ȡwindowmanager ʵ�� 
		WindowManager wm  = (WindowManager) getSystemService(WINDOW_SERVICE);
		screenWidth = wm.getDefaultDisplay().getWidth();
		screenHeight = wm.getDefaultDisplay().getHeight();
		
		System.out.println("�ֻ��Ŀ�͸�:"+screenWidth+"---"+screenHeight);
		
		
		
		
	}

	
	//�����ť  ����dog.jpg ����ͼƬ
	@SuppressLint("SdCardPath")
	public void click(View v) {
		//[2]��dog.jpg ת����bitmap  
		
		//����bitmap���������ò��� 
		BitmapFactory.Options options = new Options();
		
		//����һ��null û��bitmap   ��ȥ��������λͼ �����ܷ���ͼƬ��һЩ��Ϣ(��͸�)
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile("/mnt/sdcard/dog.jpg",options);
		//[3]��ȡͼƬ�Ŀ�͸�  
		int imgWidth = options.outWidth;
		int imgHeight = options.outHeight;
		System.out.println("ͼƬ�Ŀ�:"+imgWidth+"-----"+imgHeight);
		
		//[4]�������ű� 
		int scale = 1;  //���Ƕ�������ű� 
		int scalex =  imgWidth/screenWidth;
		int scaley = imgHeight /screenHeight;
		if (scalex >=scaley&&scalex > scale) {
			scale = scalex;
		}
		if (scaley > scalex && scaley>scale) {
			scale = scaley;
		}
		System.out.println("���ű�Ϊ:"+scale);
		
		
		//[5]�������ű���ʾͼƬ 
		options.inSampleSize = scale;
		
		//[6]��ʼ�����Ľ���λͼ 
		options.inJustDecodeBounds = false;
		Bitmap bitmap = BitmapFactory.decodeFile("/mnt/sdcard/dog.jpg",options);
		
		//[7]��bitmap��ʾ���ؼ���
		iv.setImageBitmap(bitmap);
		
		
		
		
	}
	

}
