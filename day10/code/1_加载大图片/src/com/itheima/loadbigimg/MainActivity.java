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
		
		//[1]找到iv 显示加载图片 
		
		iv = (ImageView) findViewById(R.id.iv);
		
		//[2]获取手机的分辨率  获取windowmanager 实例 
		WindowManager wm  = (WindowManager) getSystemService(WINDOW_SERVICE);
		screenWidth = wm.getDefaultDisplay().getWidth();
		screenHeight = wm.getDefaultDisplay().getHeight();
		
		System.out.println("手机的宽和高:"+screenWidth+"---"+screenHeight);
		
		
		
		
	}

	
	//点击按钮  加载dog.jpg 这张图片
	@SuppressLint("SdCardPath")
	public void click(View v) {
		//[2]把dog.jpg 转换成bitmap  
		
		//创建bitmap工厂的配置参数 
		BitmapFactory.Options options = new Options();
		
		//返回一个null 没有bitmap   不去真正解析位图 但是能返回图片的一些信息(宽和高)
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile("/mnt/sdcard/dog.jpg",options);
		//[3]获取图片的宽和高  
		int imgWidth = options.outWidth;
		int imgHeight = options.outHeight;
		System.out.println("图片的宽:"+imgWidth+"-----"+imgHeight);
		
		//[4]计算缩放比 
		int scale = 1;  //我们定义的缩放比 
		int scalex =  imgWidth/screenWidth;
		int scaley = imgHeight /screenHeight;
		if (scalex >=scaley&&scalex > scale) {
			scale = scalex;
		}
		if (scaley > scalex && scaley>scale) {
			scale = scaley;
		}
		System.out.println("缩放比为:"+scale);
		
		
		//[5]按照缩放比显示图片 
		options.inSampleSize = scale;
		
		//[6]开始真正的解析位图 
		options.inJustDecodeBounds = false;
		Bitmap bitmap = BitmapFactory.decodeFile("/mnt/sdcard/dog.jpg",options);
		
		//[7]把bitmap显示到控件上
		iv.setImageBitmap(bitmap);
		
		
		
		
	}
	

}
