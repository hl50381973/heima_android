package com.itheima.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

	public MyOpenHelper(Context context) {
		/**
		 * name ���ݿ������ 
		 * factory �α깤�� 
		 * version  �汾
		 */
		super(context, "Account.db", null, 1);
	}

	/**
	 * Called when the database is created for the first time
	 * �����ݿ��һ�� ������ʱ����� ��ô��������ر��ʺ��� ��ṹ�ĳ�ʼ�� 
	 * 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("create table info(_id integer primary key autoincrement,name varchar(20),money varchar(20))");
		db.execSQL("insert into info(name,money) values(?,?)", new String[]{"����","5000"});
		db.execSQL("insert into info(name,money) values(?,?)", new String[]{"����","3000"});
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
