package com.itheima.life;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("onCreate");
	}

	// ��activity���ٵ�ʱ�����
	@Override
	protected void onDestroy() {

		System.out.println("onDestroy");
		super.onDestroy();
	}

	// ������ɼ���ʱ�����
	@Override
	protected void onStart() {
		System.out.println("onStart");
		super.onStart();
	}

	// ��ҳ�治�ɼ���ʱ�����
	@Override
	protected void onStop() {
		System.out.println("onStop");
		super.onStop();
	}


	//��ҳ�汻����������ʱ�����
	@Override
	protected void onRestart() {
		
		System.out.println("onRestart");
		super.onRestart();
	}
	

	//��ȡ���� ����ť���Ա������
	@Override
	protected void onResume() {
		System.out.println("onResume");
		super.onResume();
	}
	
	//������ʧȥ����  ����ť�����Ա���� 
	@Override
	protected void onPause() {
		System.out.println("onPause");
		super.onPause();
	}

	//�����ť ��ת�� TestActivityҳ�� 
	public void click(View v) {
		
		Intent intent = new Intent(this,TestActivity.class);
		startActivity(intent);
	}
	
}
