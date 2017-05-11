package com.itheima.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

	public MyOpenHelper(Context context) {
		/**
		 * name 数据库的名字 
		 * factory 游标工厂 
		 * version  版本
		 */
		super(context, "Account.db", null, 1);
	}

	/**
	 * Called when the database is created for the first time
	 * 当数据库第一次 创建的时候调用 那么这个方法特别适合做 表结构的初始化 
	 * 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("create table info(_id integer primary key autoincrement,name varchar(20),money varchar(20))");
		db.execSQL("insert into info(name,money) values(?,?)", new String[]{"张三","5000"});
		db.execSQL("insert into info(name,money) values(?,?)", new String[]{"李四","3000"});
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
