package com.itheima.dyncaddfragment;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.WindowManager;

@SuppressLint("CommitTransaction")
public class MainActivity extends FragmentActivity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// [1]��ȡ�ֻ��Ŀ�͸� windommanager
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		int width = wm.getDefaultDisplay().getWidth();
		int height = wm.getDefaultDisplay().getHeight();
		// [2]�жϺ�����

		// [3.1]���ʹ��v4���е�fragment ��ȡfragment�Ĺ����� ��ͨ��getsupportFragmentManager();
		FragmentManager supportFragmentManager = getSupportFragmentManager();
		
		
		// [3.2]����һ������
		FragmentTransaction transaction = supportFragmentManager.beginTransaction();

		if (height > width) {
			// ˵�������� androind ����ϵͳ����õ� android.R.id.content�����ǵ�ǰ�ֻ��Ĵ���
			transaction.replace(android.R.id.content, new Fragment1());

		} else {
			// ����
			transaction.replace(android.R.id.content, new Fragment2());
		}

		//[4]һ��Ҫ�ǵ� �ύcommit 
		transaction.commit();
		
		
	}

}
