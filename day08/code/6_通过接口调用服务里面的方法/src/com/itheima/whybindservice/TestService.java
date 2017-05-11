package com.itheima.whybindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class TestService extends Service {

	//��bindservice 
	@Override
	public IBinder onBind(Intent intent) {
		
		//[3]�����Ƕ�����м��˶��󷵻�
		return new MyBinder();
	}


	
	@Override
	public void onCreate() {
		super.onCreate();
	}

	//���Է���
	public void banZheng(int money){
		
		if (money > 1000) {
			Toast.makeText(getApplicationContext(), "�����쵼 ��֤�������", 1).show();
		}else{
			
			Toast.makeText(getApplicationContext(), "���Ǯ �������", 1).show();
		} 
			
	}
	
	//���齫�ķ���
	public void playMaJiang(){
		
		System.out.println("��ͻ����齫");
	}
	
	
	//ϴɣ�õķ���
	public void ϴɣ��(){
		System.out.println("ϴɣ��");
	}
	
	
	//[1����һ���м��˶��� ]
	
	private  class MyBinder extends Binder implements Iservice{
		
		//[2]����һ������ ���ð�֤�ķ��� 
		public void callBanZheng(int money){
			banZheng(money);
			
		}
		//����һ�����ô��齫�ķ���
		public void callPlayMaJiang(){
			playMaJiang();
		}
		
		//����ϴɣ�õķ���
		public void callXiSangNa(){
			ϴɣ��();
		}
		
		
	}
	
	
}
