package com.itheima.login.net;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;

import com.itheima.login.util.StreamUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class LoginHttpUtils {

	
	public static void requestNetForGetLogin(final Context context,final Handler handler ,final String username, final String password) {
				//使用HttpClient请求服务器将用户密码发送服务器验证
				try{
				String path = "http://192.168.13.83:8080/itheima74/servlet/LoginServlet?username="+URLEncoder.encode(username,"utf-8")+"&pwd="+URLEncoder.encode(password,"utf-8");
		
				//创建一个AsyncHttpClient对象
				AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
				asyncHttpClient.get(path, new AsyncHttpResponseHandler() {
					
					@Override
					public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
						//statusCode:状态码    headers：头信息  responseBody：返回的内容，返回的实体
						//判断状态码
						if(statusCode == 200){
							//获取结果
							try {
								String result = new String(responseBody,"utf-8");
								Toast.makeText(context, result, 0).show();
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
					@Override
					public void onFailure(int statusCode, Header[] headers,
							byte[] responseBody, Throwable error) {
						
						System.out.println("...............onFailure");
						
					}
				});
				}catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public static void requestNetForPostLogin( final Context context,final Handler handler ,final String username, final String password) {

			String path = "http://192.168.13.83:8080/itheima74/servlet/LoginServlet";
					
	
			AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
			RequestParams params = new RequestParams();
			params.put("username", username);
			params.put("pwd", password);
			//url:   parmas：请求时携带的参数信息   responseHandler：是一个匿名内部类接受成功过失败
			asyncHttpClient.post(path, params, new AsyncHttpResponseHandler() {
				
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
					//statusCode:状态码    headers：头信息  responseBody：返回的内容，返回的实体
					
					//判断状态码
					if(statusCode == 200){
						//获取结果
						try {
							
							String result = new String(responseBody,"utf-8");
							Toast.makeText(context, result, 0).show();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
				@Override
				public void onFailure(int statusCode, Header[] headers,
						byte[] responseBody, Throwable error) {
					
				}
			});


	}
	
}
