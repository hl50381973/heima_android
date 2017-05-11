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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// [1]找到我们关心的控件
		ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
		final ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);

		// [2] 把tomcat.png 转换成bitmap 然后显示到iv_src
		final Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.tomcat);

		// [2.1 test] 修改原图 原图不可以被修改
		// srcBitmap.setPixel(20, 30, Color.RED);

		iv_src.setImageBitmap(srcBitmap);

		// [3]拷贝原图

		// [3.1]创建模板
		final Bitmap copybitmap = Bitmap.createBitmap(srcBitmap.getWidth(),
				srcBitmap.getHeight(), srcBitmap.getConfig());
		// [3.2]想作画 需要一个画布 以copybitmap为模板
		Canvas canvas = new Canvas(copybitmap);
		// [3.3]创建一个画笔
		Paint paint = new Paint();
		// [3.4]开始作画 srcBitmap参考原图去画
		Matrix matrix = new Matrix();

		
		
		// [3.5]对图片缩放处理 
		//matrix.setScale(1.0f, -1.0f);
		//让图片进行移动 
//		matrix.setTranslate(0, srcBitmap.getHeight());
		//post是在上一次修改的基础上进行修改   set每次每次都是新的变化 会覆盖上一次修改 
		//matrix.postTranslate(0, srcBitmap.getHeight());
		
		
		
		//[3.6]镜面效果 
		matrix.setScale(-1.0f, 1.0f);
		matrix.postTranslate(srcBitmap.getWidth(), 0);
		
		
		canvas.drawBitmap(srcBitmap, matrix, paint);

		// [4]把copybitmap显示到iv_copy上
		iv_copy.setImageBitmap(copybitmap);

	}

}
