package com.itheima.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class AccountProvider extends ContentProvider {

	
	
	//[1]��һ��һ��uri·��ƥ���� 
	private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int QUERYSUCESS = 0;  //ctrl+shift+X  ���д   Сд��y
	private static final int INSERTSUCESS = 1;
	private static final int UPDATESUCESS = 2;
	private static final int DELETESUCESS = 3;
	private MyOpenHelper myOpenHelper;
	//[2]����һ����̬����� ������������ uri 
	static{
		
		/**
		 *                                  http://www.baidu.com 
		 * authority ע��: ���嵥�ļ����涨���һ��  com.itheima.provider/query 
		 *  
		 */
		sURIMatcher.addURI("com.itheima.provider", "query", QUERYSUCESS);
		sURIMatcher.addURI("com.itheima.provider", "insert", INSERTSUCESS);
		sURIMatcher.addURI("com.itheima.provider", "update", UPDATESUCESS);
		sURIMatcher.addURI("com.itheima.provider", "delete", DELETESUCESS);
	}
	
	
	//�������ṩ�߳�ʼ��  ��ִ�д˷��� 
	@Override
	public boolean onCreate() {
		
		//[3]��ʼ�� myopenHelpler ����    �Ϳ��Ի�ȡ��sqlitedatabases���� ���ǾͿ��Բ������ݿ� 
		
		myOpenHelper = new MyOpenHelper(getContext());
		
		return false;
	}

	//����������Ⱪ¶�� 
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		int code = sURIMatcher.match(uri);
		if (code ==QUERYSUCESS ) {
			//˵��·��ƥ��ɹ�
			SQLiteDatabase db = myOpenHelper.getReadableDatabase();
			//����query����
			Cursor cursor = db.query("info", projection, selection, selectionArgs, null, null, sortOrder);
			
			//����һ����Ϣ ˵��˵�����ݿⱻ������ 
			getContext().getContentResolver().notifyChange(uri, null);
			
			
//			db.close();
			//Сϸ�� �� ���cursor���ܹ� 
			return cursor;
			
		}else{
			//˵��·����ƥ��
//			return null;
			throw new IllegalArgumentException("���� :uri·����ƥ�� ����·��");
			
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
			//˵��·��ƥ��ɹ� 
			SQLiteDatabase db = myOpenHelper.getReadableDatabase();
			
			long insert = db.insert("info", null, values);
			Uri uri2 = Uri.parse("com.hahaheheheihei/"+insert); 
			
			if (insert>0) {
				//����һ����Ϣ ˵��˵�����ݿⱻ������ 
				getContext().getContentResolver().notifyChange(uri, null);
			}
			
			
			db.close();//�ر����ݿ�
			return uri2;
			
		}else {
			throw new IllegalArgumentException("���� :uri·����ƥ�� ����·��");
		}
		
		
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		
		int code = sURIMatcher.match(uri);
		if (code == DELETESUCESS) {
			//ƥ��ɹ� 
			SQLiteDatabase db = myOpenHelper.getReadableDatabase();
			
			
			//����Ӱ�������
			int delete = db.delete("info", selection, selectionArgs);
			
			if (delete>0) {
				//����һ����Ϣ ˵��˵�����ݿⱻ������ 
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
			//·��ƥ��ɹ�
			SQLiteDatabase db = myOpenHelper.getWritableDatabase();
			
			//����Ӱ������� 
			int update = db.update("info", values, selection, selectionArgs);
			if(update>0){
				//����һ����Ϣ ˵��˵�����ݿⱻ������ 
				getContext().getContentResolver().notifyChange(uri, null);
				
			}
			
			
			
			return update;
			
			
		}else{
			throw new IllegalArgumentException("��ү:uri·����ƥ�� ����·��");
			
		}
			
		
	}

}
