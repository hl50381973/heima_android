package com.itheima.wx;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class WxFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_wx, null);
		view.findViewById(R.id.btn_test).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("������ �ұ������");
			}
		});
		
		return view; 
	}
	
}
