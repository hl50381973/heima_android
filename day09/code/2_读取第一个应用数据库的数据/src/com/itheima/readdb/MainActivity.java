package com.itheima.readdb;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}

	
	//点击按钮 往数据库里面插入一条数据
	public void click1(View v){
		//因为第一个应用里面的私有的数据库 已经通过内容提供者暴露出来了 所以通过内容解析者去获取数据
		Uri uri = Uri.parse("content://com.itheima.provider/insert");
		ContentValues values = new ContentValues(); //实际是map  
		//key:  代表列名  value 对应的值 
		values.put("name", "zhaoliu");
		values.put("money", 1000);
		//插入一条数据
		Uri uri2 = getContentResolver().insert(uri, values);
		
		System.out.println("uri2:"+uri2);
		
		
		
	}
	
	//点击按钮删除 赵六删掉
	public void click2(View v){
		//[1]获取内容的解析者 
		Uri uri = Uri.parse("content://com.itheima.provider/delete");
		//[2]代表影响的函数
		int delete = getContentResolver().delete(uri, "name=?", new String[]{"zhaoliu"});
		Toast.makeText(getApplicationContext(), "删除了"+delete+"行", 1).show();
		
	}
	
	//给赵六多点钱  1000元
	public void click3(View v){
		//[1] 创建uri
	    Uri uri = Uri.parse("content://com.itheima.provider/update");
		//[2]获取内容的解析者
	    ContentValues values = new ContentValues();
	    values.put("money", "10000000");
	    int update = getContentResolver().update(uri, values, "name=?",new String[]{"zhaoliu"});
	    Toast.makeText(getApplicationContext(), "更新了"+update+"行", 1).show();
		
	}
	
	
	//点击按钮 查询第一个应用里面数据库的信息 
	public void click4(View v){
		// 第二种 查询方式  因为第一个应用里面的私有的数据库 已经通过内容提供者暴露出来了 所以通过内容解析者去获取数据
		Uri uri = Uri.parse("content://com.itheima.provider/query");
		//获取内容解析者获取数据
		Cursor cursor = getContentResolver().query(uri, new String[]{"name","money"}, null, null, null);
         if (cursor!=null) {
			
			while(cursor.moveToNext()){
				String name = cursor.getString(0);
				String money = cursor.getString(1);
				
				System.out.println("第二个应用:"+name+"---"+money);
				
			}
         }
		
	}
	
	

}
