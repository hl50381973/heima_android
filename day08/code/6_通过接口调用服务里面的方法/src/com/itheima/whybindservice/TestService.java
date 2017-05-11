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
	
	//打麻将的方法
	public void playMaJiang(){
		
		System.out.println("陪客户打麻将");
	}
	
	
	//洗桑拿的方法
	public void 洗桑拿(){
		System.out.println("洗桑拿");
	}
	
	
	//[1定义一个中间人对象 ]
	
	private  class MyBinder extends Binder implements Iservice{
		
		//[2]定义一个方法 调用办证的方法 
		public void callBanZheng(int money){
			banZheng(money);
			
		}
		//定义一个调用打麻将的方法
		public void callPlayMaJiang(){
			playMaJiang();
		}
		
		//调用洗桑拿的方法
		public void callXiSangNa(){
			洗桑拿();
		}
		
		
	}
	
	
}
