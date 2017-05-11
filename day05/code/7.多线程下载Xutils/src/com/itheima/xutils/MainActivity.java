package com.itheima.xutils;

import java.io.File;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	public void download(View v){
		EditText et_url = (EditText) findViewById(R.id.et_url);
		String url = et_url.getText().toString().trim();
		//1.创建httpUtils对象
		HttpUtils httpUtils = new HttpUtils();
		//2.调用download方法  url:下载的地址  target：下载的目录   callback：回调 
		httpUtils.download(url, "/sdcard/feiqiu/feiq.exe", new RequestCallBack<File>() {
			@Override
			public void onLoading(long total, long current, boolean isUploading) {
				System.out.println("total:"+total+";current:"+current);
				super.onLoading(total, current, isUploading);
			}
			@Override
			public void onSuccess(ResponseInfo<File> responseInfo) {
				System.out.println(responseInfo.result);
			}
			@Override
			public void onFailure(HttpException error, String msg) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
