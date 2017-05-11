package com.itheima.alipay;

import com.itheima.alipay.Iservice.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class PayService extends Service {

	//[2]我们定义的中间人对象返回
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}
	
	
	//支付宝支付的方法
	public boolean pay(String name,String pwd,int money){
			System.out.println("1验证用户名和密码 ");
			System.out.println("2验证手机是否携带病毒");
			System.out.println("3调用C语言 做一些加密处理 ");
			
			if ("abc".equals(name)&& "123".equals(pwd)&& money <5000) {
				
				return true;
			}else {
				return false;
				
			}
			
		
	}
	
	
	//定义中间人对象 
	private class MyBinder extends Stub{

		//调用支付的方法
		@Override
		public boolean callPay(String name, String pwd, int money) {
			
			return pay(name, pwd, money);
			
		}
		
	}
	

}
