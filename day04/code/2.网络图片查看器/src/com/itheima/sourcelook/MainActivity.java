package com.itheima.sourcelook;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.itheima.piclook.R;

public class MainActivity extends Activity  implements OnClickListener{

	private EditText et_url;
	private ImageView img_pic;
	private Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext =this;
		et_url = (EditText) findViewById(R.id.et_url);
		Button bt_looksource = (Button) findViewById(R.id.bt_looksource);
		img_pic = (ImageView) findViewById(R.id.img_pic);
		
		//二.设置点击事件
		bt_looksource.setOnClickListener(this);
	
		System.out.println("oncreate方法线程："+Thread.currentThread().getName());
		
	}

	//☆☆☆1.在主线程中创建一个Handler对象
	private Handler handler = new Handler(){
		//☆☆☆2.重写handler的handlermessage方法,用来接收子线程中发来的消息
		public void handleMessage(android.os.Message msg) {
			//☆☆☆5.接收子线程发送的数据，处理数据。
			Bitmap bitmap  = (Bitmap) msg.obj;
			//☆☆☆6.当前方法属于主线程可以做UI的更新
			//五.获取服务器返回的内容，显示到textview上
			img_pic.setImageBitmap(bitmap);//设置ImageView的图片内容
		};
	};
	
	@Override
	public void onClick(View v) {
		
		
		try{
		//三.oclick方法中获取用户输入的url地址
		final String url_str = et_url.getText().toString().trim();
		if(TextUtils.isEmpty(url_str)){
			Toast.makeText(mContext, "url不能为空", 0).show();
			return ;
		}
		
		System.out.println("oclick方法线程："+Thread.currentThread().getName());
		
		
		//创建一个子线程做网络请求
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try{
					System.out.println("oclick方法runnable线程："+Thread.currentThread().getName());
					
					
				//四.请求url地址
				//1.创建一个Url对象
					URL url = new URL(url_str);
				//2.获取一个UrlConnection对象
					HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				//3.为UrlConnection对象设置一些请求的参数,请求方式，连接的超时时间 
					connection.setRequestMethod("GET");//设置请求方式
					connection.setConnectTimeout(1000*10);//设置超时时间
					
					
				//4.在获取url请求的数据前需要判断响应码，200 ：成功,206:访问部分数据成功   300：跳转或重定向  400：错误 500：服务器异常
					int code = connection.getResponseCode();
					if(code == 200){
				//5.获取有效数据，并将获取的流数据解析成String
						InputStream inputStream = connection.getInputStream();
						
						//将一个读取流转换成一个图片 Drawable , Btimap:位图  ?????
						Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
						
						
						//☆☆☆3.子线中创建一个Message对象，为了携带子线程中获取的数据给主线程。
						Message msg = Message.obtain();//获取一个Message对象，内部实现是：如果之前的Message存在直接返回，不存在创建新的Message返回
						msg.obj = bitmap;//将获取的数据封装到msg中。
						//☆☆☆4.使用handler对象将message发送到主线程。
						handler.sendMessage(msg);
			
						
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
		
				
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


}
