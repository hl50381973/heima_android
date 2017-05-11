package com.itheima.fileupload;

import java.io.File;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	
	public void fileupload(View v){
		try{
		EditText et_filepath = (EditText) findViewById(R.id.et_filepath);
		//获取输入的文件地址
		String filepath = et_filepath.getText().toString().trim();
		
		//使用开源Utils做上传操作
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		
		RequestParams params = new RequestParams();
		params.put("filename", new File(filepath));
		//url : 请求服务器的url
		asyncHttpClient.post("http://192.168.13.83:8080/itheima74/servlet/UploaderServlet", params, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				if(statusCode == 200){
					Toast.makeText(MainActivity.this, "上传成功", 0).show();
				}
			}
			@Override
			public void onFailure(int statusCode, Header[] headers,
					byte[] responseBody, Throwable error) {
			}
		});
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
