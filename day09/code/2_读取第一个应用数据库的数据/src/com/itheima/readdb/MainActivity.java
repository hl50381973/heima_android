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

	
	//�����ť �����ݿ��������һ������
	public void click1(View v){
		//��Ϊ��һ��Ӧ�������˽�е����ݿ� �Ѿ�ͨ�������ṩ�߱�¶������ ����ͨ�����ݽ�����ȥ��ȡ����
		Uri uri = Uri.parse("content://com.itheima.provider/insert");
		ContentValues values = new ContentValues(); //ʵ����map  
		//key:  ��������  value ��Ӧ��ֵ 
		values.put("name", "zhaoliu");
		values.put("money", 1000);
		//����һ������
		Uri uri2 = getContentResolver().insert(uri, values);
		
		System.out.println("uri2:"+uri2);
		
		
		
	}
	
	//�����ťɾ�� ����ɾ��
	public void click2(View v){
		//[1]��ȡ���ݵĽ����� 
		Uri uri = Uri.parse("content://com.itheima.provider/delete");
		//[2]����Ӱ��ĺ���
		int delete = getContentResolver().delete(uri, "name=?", new String[]{"zhaoliu"});
		Toast.makeText(getApplicationContext(), "ɾ����"+delete+"��", 1).show();
		
	}
	
	//���������Ǯ  1000Ԫ
	public void click3(View v){
		//[1] ����uri
	    Uri uri = Uri.parse("content://com.itheima.provider/update");
		//[2]��ȡ���ݵĽ�����
	    ContentValues values = new ContentValues();
	    values.put("money", "10000000");
	    int update = getContentResolver().update(uri, values, "name=?",new String[]{"zhaoliu"});
	    Toast.makeText(getApplicationContext(), "������"+update+"��", 1).show();
		
	}
	
	
	//�����ť ��ѯ��һ��Ӧ���������ݿ����Ϣ 
	public void click4(View v){
		// �ڶ��� ��ѯ��ʽ  ��Ϊ��һ��Ӧ�������˽�е����ݿ� �Ѿ�ͨ�������ṩ�߱�¶������ ����ͨ�����ݽ�����ȥ��ȡ����
		Uri uri = Uri.parse("content://com.itheima.provider/query");
		//��ȡ���ݽ����߻�ȡ����
		Cursor cursor = getContentResolver().query(uri, new String[]{"name","money"}, null, null, null);
         if (cursor!=null) {
			
			while(cursor.moveToNext()){
				String name = cursor.getString(0);
				String money = cursor.getString(1);
				
				System.out.println("�ڶ���Ӧ��:"+name+"---"+money);
				
			}
         }
		
	}
	
	

}
