package com.itheima.insertcontactdb;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et_name;
	private EditText et_phone;
	private EditText et_email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//[1]�ҵ����ǹ��ĵĿؼ� 
		
		et_name = (EditText) findViewById(R.id.et_name);
		et_phone = (EditText) findViewById(R.id.et_phone);
		et_email = (EditText) findViewById(R.id.et_email);
		
		
	}

	//�����ť ����һ����ϵ����Ϣ 
	public void click(View v) {
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Uri dataUri = Uri.parse("content://com.android.contacts/data");
		
		//[2]��ȡname phone email Textutils
		String name = et_name.getText().toString().trim();
		String phone = et_phone.getText().toString().trim();
		String email = et_email.getText().toString().trim();
		
		//[2.1]�ڲ�����ϵ��id��ʱ�� �Ȳ�ѯһ�� row_contact һ���м�������    ��+1������ϵ�˵�id 
		Cursor cursor = getContentResolver().query(uri, null, null, null, null);
		int count = cursor.getCount();
		int contact_id = count +1;
		
		//[3] ����row_contact��  ������ϵ�˵�id (contact_id)  
		ContentValues values = new ContentValues();
		values.put("contact_id", contact_id);
		getContentResolver().insert(uri,values);
		
		//[4]�ڰ�name phone email ���뵽data�� 
		ContentValues nameValues = new ContentValues();
		nameValues.put("data1", name);
		//�� �� �� �� �� ���������Ҫ�������ݿ� ���ڵڼ�����ϵ��  ��  �������� 
		nameValues.put("raw_contact_id", contact_id);
		nameValues.put("mimetype", "vnd.android.cursor.item/name");
		getContentResolver().insert(dataUri, nameValues);
		
		//[5]��phone���� ���뵽data�� 
		ContentValues phoneValues = new ContentValues();
		phoneValues.put("data1", phone);
		phoneValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
		phoneValues.put("raw_contact_id", contact_id);
		getContentResolver().insert(dataUri, phoneValues);
		
		
		//[5]��phone���� ���뵽data�� 
		ContentValues emailValues = new ContentValues();
		emailValues.put("data1", email);
		emailValues.put("mimetype", "vnd.android.cursor.item/email_v2");
		emailValues.put("raw_contact_id", contact_id);
		getContentResolver().insert(dataUri, emailValues);
		
	}
	
	

}
