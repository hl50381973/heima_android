package com.itheima.crud;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.itheima.crud2_listview.R;
import com.itheima.crud.adapter.QueryAdapter;
import com.itheima.crud.bean.InfoBean;
import com.itheima.crud.dao.InfoDao;

public class MainActivity extends Activity implements OnClickListener {

	private Context mContext;
	private ListView lv_databases;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContext = this;
		//创建一个帮助类对象
		MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(mContext);
		//调用getReadableDatabase方法,来初始化数据库的创建
		SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();


		//找到相应控件
		findViewById(R.id.bt_add).setOnClickListener(this);

		findViewById(R.id.bt_del).setOnClickListener(this);
		findViewById(R.id.bt_update).setOnClickListener(this);
		findViewById(R.id.bt_query).setOnClickListener(this);
		
		//找到listview
		lv_databases = (ListView) findViewById(R.id.lv_databases);

	}
	@Override
	public void onClick(View v) {
		InfoDao infoDao = new InfoDao(mContext);//创建一个dao对象做增删改查

		switch (v.getId()) {
		case R.id.bt_add:
			
			InfoBean bean = new InfoBean();
			bean.name = "张三";
			bean.phone ="110";
			boolean result = infoDao.add(bean);
			if(result){
				Toast.makeText(mContext, "添加成功", 0).show();
			}else{
				Toast.makeText(mContext, "添加失败", 0).show();
			}
			
		
			break;

		case R.id.bt_del:
			
			int del = infoDao.del("张三");
			Toast.makeText(mContext, "成功删除"+del+"行", 0).show();
			break;

		case R.id.bt_update:
			
			InfoBean bean2 = new InfoBean();
			bean2.name = "张三";
			bean2.phone ="119";
			int update = infoDao.update(bean2);
			Toast.makeText(mContext, "成功修改"+update+"行", 0).show();
			break;


		case R.id.bt_query:
			//获取查询的数据
			ArrayList<InfoBean> arrayList = infoDao.query("张三");
			//封装adapter
			QueryAdapter queryAdapter = new QueryAdapter(mContext,arrayList);
			//将adapter设置给listview
			lv_databases.setAdapter(queryAdapter);
			break;

		default:
			break;
		}

	}




}
