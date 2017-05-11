package com.itheima.copybitmap;

import android.os.Bundle;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]找到我们关心的控件 
		ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
		ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
		
		//[2] 把tomcat.png 转换成bitmap 然后显示到iv_src 
		Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tomcat);
		
		//[2.1 test] 修改原图   原图不可以被修改
		//srcBitmap.setPixel(20, 30, Color.RED);
		
		iv_src.setImageBitmap(srcBitmap);
		
		//[3]拷贝原图   
		
		//[3.1]创建模板  
		Bitmap copybitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig());
		//[3.2]想作画 需要一个画布   以copybitmap为模板  
		Canvas  canvas = new Canvas(copybitmap);
		//[3.3]创建一个画笔  
		Paint paint = new Paint();
		//[3.4]开始作画   srcBitmap参考原图去画
		canvas.drawBitmap(srcBitmap, new Matrix(), paint);
		
		
		for (int i = 0; i < 10; i++) {
			//[一次修改一个像素]
			copybitmap.setPixel(20+i,30, Color.RED);
		}
		
		
		//[4]把copybitmap显示到iv_copy上
		iv_copy.setImageBitmap(copybitmap);
		
		
	}

	
}
