package com.itheima.whybindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class TestService extends Service {

	//当bindservice 
	@Override
	public IBinder onBind(Intent intent) {
		
		//[3]把我们定义的中间人对象返回
		return new MyBinder();
	}


	
	@Override
	public void onCreate() {
		super.onCreate();
	}

	//测试方法
	public void banZheng(int money){
		
		if (money > 1000) {
			Toast.makeText(getApplicationContext(), "我是领导 把证给你办了", 1).show();
		}else{
			
			Toast.makeText(getApplicationContext(), "这点钱 还想办事", 1).show();
		} 
			
	}
	
	//[1定义一个中间人对象 ]
	
	public  class MyBinder extends Binder{
		
		//[2]定义一个方法 调用办证的方法 
		public void callBanZheng(int money){
			banZheng(money);
			
		}
		
	}
	
	
}
