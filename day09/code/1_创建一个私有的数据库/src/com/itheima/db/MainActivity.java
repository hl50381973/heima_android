package com.itheima.db;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MyOpenHelper helper = new MyOpenHelper(getApplicationContext());
		SQLiteDatabase db = helper.getWritableDatabase();
		
		//需求把张三和李四的数据取出来  
		Cursor cursor = db.query("info", null, null, null, null, null, null);
		if (cursor!=null&&cursor.getCount()>0) {
			while(cursor.moveToNext()){
				
				String name = cursor.getString(1);
				String money = cursor.getString(2);
				
				System.out.println("name:"+name+"-----"+money);
				
			}
			cursor.close();
			
		}
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
