package com.itheima.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//����һ��Fragment 
public class Fragment1 extends Fragment {

	//���û���һ�λ�ui��ʱ�����  Ҫ��ʾFragment�Լ�������  setContentView(R.layout.activity_main);
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//[1]ͨ������Ͳ��һ������ת����view���� 
		View view = inflater.inflate(R.layout.fragment1, null);
		
		
		return view;
	}
}
