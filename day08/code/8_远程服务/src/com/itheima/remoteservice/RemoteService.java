package com.itheima.remoteservice;

import com.itheima.remoteservice.Iservice.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

//远程服务
public class RemoteService extends Service {

	//[2]把我们定义的中间人对象返回
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}

	
	//在服务里面定义一个方法
	
	public void testMethod(){
		System.out.println("我是远程服务里面的方法");
	}
	
	//[1]定义中间人对象 
	private class MyBinder extends Stub{

		//调用testMethod方法
		@Override
		public void callTestMethod() {
			
			testMethod();
		}
		
	}
	
}
