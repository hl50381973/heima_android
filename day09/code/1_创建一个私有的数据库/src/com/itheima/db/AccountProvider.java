package com.itheima.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class AccountProvider extends ContentProvider {

	
	
	//[1]定一个一个uri路径匹配器 
	private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int QUERYSUCESS = 0;  //ctrl+shift+X  变大写   小写加y
	private static final int INSERTSUCESS = 1;
	private static final int UPDATESUCESS = 2;
	private static final int DELETESUCESS = 3;
	private MyOpenHelper myOpenHelper;
	//[2]创建一个静态代码块 在这个里面添加 uri 
	static{
		
		/**
		 *                                  http://www.baidu.com 
		 * authority 注意: 和清单文件里面定义的一样  com.itheima.provider/query 
		 *  
		 */
		sURIMatcher.addURI("com.itheima.provider", "query", QUERYSUCESS);
		sURIMatcher.addURI("com.itheima.provider", "insert", INSERTSUCESS);
		sURIMatcher.addURI("com.itheima.provider", "update", UPDATESUCESS);
		sURIMatcher.addURI("com.itheima.provider", "delete", DELETESUCESS);
	}
	
	
	//当内容提供者初始化  会执行此方法 
	@Override
	public boolean onCreate() {
		
		//[3]初始化 myopenHelpler 对象    就可以获取到sqlitedatabases对象 我们就可以操作数据库 
		
		myOpenHelper = new MyOpenHelper(getContext());
		
		return false;
	}

	//这个方法对外暴露的 
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		int code = sURIMatcher.match(uri);
		if (code ==QUERYSUCESS ) {
			//说明路径匹配成功
			SQLiteDatabase db = myOpenHelper.getReadableDatabase();
			//调用query方法
			Cursor cursor = db.query("info", projection, selection, selectionArgs, null, null, sortOrder);
			
			//发送一条消息 说明说明数据库被操作了 
			getContext().getContentResolver().notifyChange(uri, null);
			
			
//			db.close();
			//小细节 ☆ 这个cursor不能关 
			return cursor;
			
		}else{
			//说明路径不匹配
//			return null;
			throw new IllegalArgumentException("哥们 :uri路径不匹配 请检测路径");
			
		}
			
		
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		
		int code = sURIMatcher.match(uri);
		if (code == INSERTSUCESS) {
			//说明路径匹配成功 
			SQLiteDatabase db = myOpenHelper.getReadableDatabase();
			
			long insert = db.insert("info", null, values);
			Uri uri2 = Uri.parse("com.hahaheheheihei/"+insert); 
			
			if (insert>0) {
				//发送一条消息 说明说明数据库被操作了 
				getContext().getContentResolver().notifyChange(uri, null);
			}
			
			
			db.close();//关闭数据库
			return uri2;
			
		}else {
			throw new IllegalArgumentException("姐们 :uri路径不匹配 请检测路径");
		}
		
		
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		
		int code = sURIMatcher.match(uri);
		if (code == DELETESUCESS) {
			//匹配成功 
			SQLiteDatabase db = myOpenHelper.getReadableDatabase();
			
			
			//代表影响的行数
			int delete = db.delete("info", selection, selectionArgs);
			
			if (delete>0) {
				//发送一条消息 说明说明数据库被操作了 
				getContext().getContentResolver().notifyChange(uri, null);
				
			}
			
			return delete;
			
		}
		
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int code = sURIMatcher.match(uri);
		
		if (code == UPDATESUCESS) {
			//路径匹配成功
			SQLiteDatabase db = myOpenHelper.getWritableDatabase();
			
			//代表影响的行数 
			int update = db.update("info", values, selection, selectionArgs);
			if(update>0){
				//发送一条消息 说明说明数据库被操作了 
				getContext().getContentResolver().notifyChange(uri, null);
				
			}
			
			
			
			return update;
			
			
		}else{
			throw new IllegalArgumentException("大爷:uri路径不匹配 请检测路径");
			
		}
			
		
	}

}
