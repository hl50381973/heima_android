package com.itheima.alipay;

import com.itheima.alipay.Iservice.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class PayService extends Service {

	//[2]���Ƕ�����м��˶��󷵻�
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	}
	
	
	//֧����֧���ķ���
	public boolean pay(String name,String pwd,int money){
			System.out.println("1��֤�û��������� ");
			System.out.println("2��֤�ֻ��Ƿ�Я������");
			System.out.println("3����C���� ��һЩ���ܴ��� ");
			
			if ("abc".equals(name)&& "123".equals(pwd)&& money <5000) {
				
				return true;
			}else {
				return false;
				
			}
			
		
	}
	
	
	//�����м��˶��� 
	private class MyBinder extends Stub{

		//����֧���ķ���
		@Override
		public boolean callPay(String name, String pwd, int money) {
			
			return pay(name, pwd, money);
			
		}
		
	}
	

}
