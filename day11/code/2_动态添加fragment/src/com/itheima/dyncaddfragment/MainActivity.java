package com.itheima.dyncaddfragment;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.WindowManager;

@SuppressLint("CommitTransaction")
public class MainActivity extends Activity {

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

		// [3.1]��ȡfragment�Ĺ�����
		FragmentManager manager = getFragmentManager();
		// [3.2]����һ������
		FragmentTransaction transaction = manager.beginTransaction();

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
