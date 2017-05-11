package com.itheima.crud.adapter;

import java.util.ArrayList;

import com.itheima.crud.bean.InfoBean;
import com.itheima.crud2_listview.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class QueryAdapter  extends BaseAdapter{
	

	private Context mContext;
	private ArrayList<InfoBean> arrayList;

	public QueryAdapter(Context mContext, ArrayList<InfoBean> arrayList) {
		this.mContext = mContext;
		this.arrayList = arrayList;
	}

	@Override
	public int getCount() {
		return arrayList.size();
	}

	@Override
	public Object getItem(int position) {
		return arrayList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		//复用convertView
		View view = null;
		if(convertView != null){
			view = convertView;
		}else {
			view =  View.inflate(mContext, R.layout.item_database_layout, null);
		}
		
		//找到控件
		TextView item_tv_id = (TextView) view.findViewById(R.id.item_tv_id);
		TextView item_tv_name = (TextView) view.findViewById(R.id.item_tv_name);
		TextView item_tv_phone = (TextView) view.findViewById(R.id.item_tv_phone);
		//找到内容
		InfoBean infoBean = arrayList.get(position);
		
		//设置内容
		item_tv_id.setText(infoBean.id);
		item_tv_name.setText(infoBean.name);
		item_tv_phone.setText(infoBean.phone);
		
		return view;
	}

}
