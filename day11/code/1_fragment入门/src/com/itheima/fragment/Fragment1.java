package com.itheima.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//定义一个Fragment 
public class Fragment1 extends Fragment {

	//当用户第一次画ui的时候调用  要显示Fragment自己的内容  setContentView(R.layout.activity_main);
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//[1]通过打气筒把一个布局转换成view对象 
		View view = inflater.inflate(R.layout.fragment1, null);
		
		
		return view;
	}
}
