package com.itheima.communication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment1 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment1, null);
		//[1]找到按钮设置点击事件 
		view.findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Toast.makeText(getActivity(), "jagjajgl", 1).show();
				//[2]修改Fragment2里面textview的值 
				Fragment2 f2 = (Fragment2) getActivity().getFragmentManager().findFragmentByTag("f2");
				f2.setText("haahha");
				
			}
		});
		
		return view;
	}
}
