package com.itheima.login;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Random;

import com.itheima.login.net.LoginHttpUtils;
import com.itheima.login.util.StreamUtils;
import com.itheima.login.util.UserInfoUtil;
import com.itheima.login_net_asynchttpclient.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private EditText et_username;
	private EditText et_password;
	private CheckBox cb_rem;
	private Button bt_login;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		cb_rem = (CheckBox) findViewById(R.id.cb_rem);
		bt_login = (Button) findViewById(R.id.bt_login);
		//b.设置按钮的点击事件
		bt_login.setOnClickListener(this);


		//f.回显用户名密码 ??
		Map<String, String> map = UserInfoUtil.getUserInfo_android(mContext);//获取用户名密码
		if(map != null){
			String username = map.get("username");
			String password = map.get("password");
			et_username.setText(username);//设置用户名
			et_password.setText(password);
			cb_rem.setChecked(true);//设置复选框选中状态
		}

	}


	//创建一个Handler
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			String result = (String) msg.obj;


			switch (msg.what) {
			case 1://get
				Toast.makeText(mContext, result, Toast.LENGTH_SHORT).show();
			/*	if(issuccess)

				{
					//e.判断是否记住密码，如果记住，将用户名密码保存本地。???? 
					if(isrem){
						boolean result = UserInfoUtil.saveUserInfo_android(mContext,username,password);
						if(result){
							Toast.makeText(mContext, "get:用户名密码保存成功", Toast.LENGTH_SHORT).show();
						}else{
							Toast.makeText(mContext, "get:用户名密码保存失败", Toast.LENGTH_SHORT).show();	
						}

					}else{
						Toast.makeText(mContext, "无需保存", Toast.LENGTH_SHORT).show();
					}

				}else{
					Toast.makeText(mContext, "get:登录失败", Toast.LENGTH_SHORT).show();
				}*/

				break;
			case 2://post

				Toast.makeText(mContext, result, Toast.LENGTH_SHORT).show();
			/*	if(issuccess)

				{
					//e.判断是否记住密码，如果记住，将用户名密码保存本地。???? 
					if(isrem){
						boolean result = UserInfoUtil.saveUserInfo_android(mContext,username,password);
						if(result){
							Toast.makeText(mContext, "post:用户名密码保存成功", Toast.LENGTH_SHORT).show();
						}else{
							Toast.makeText(mContext, "post:用户名密码保存失败", Toast.LENGTH_SHORT).show();	
						}

					}else{
						Toast.makeText(mContext, "无需保存", Toast.LENGTH_SHORT).show();
					}

				}else{
					Toast.makeText(mContext, "post:登录失败", Toast.LENGTH_SHORT).show();
				}*/
				break;
			default:
				break;
			}


		


			



		};
	};
	private boolean isrem;
	private String username;
	private String password;

	private void login(){

		//c.在onclick方法中，获取用户输入的用户名密码和是否记住密码

		username = et_username.getText().toString().trim();
		password = et_password.getText().toString().trim();
		isrem = cb_rem.isChecked();
		//d.判断用户名密码是否为空，不为空请求服务器（省略，默认请求成功）
		if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
			Toast.makeText(mContext, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
			return ;
		}

		//请求服务器，后面讲。。。。。。。。。。


		
		Random random = new Random();
		int num = random.nextInt(10);
		if(num <12){
			//带着用户名密码请求服务器验证密码是否正确
			LoginHttpUtils.requestNetForPostLogin(mContext,handler,username,password);
		}else{

			LoginHttpUtils.requestNetForGetLogin(mContext,handler,username,password);
		}













	}







	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_login:
			login();
			break;

		default:
			break;
		}
	}


}
