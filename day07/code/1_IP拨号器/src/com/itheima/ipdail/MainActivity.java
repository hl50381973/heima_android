package com.itheima.ipdail;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_number;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_number = (EditText) findViewById(R.id.et_number);
	}

	
	//�����ť ��ȡ�û������iP���� ���б��� 
	public void click(View v) {
		//[1]��ȡ���û������number
		String number = et_number.getText().toString().trim();
		//[2]ʹ��sp �������� 
		SharedPreferences sp = getSharedPreferences("config", 0);
		//[3]������ 
		sp.edit().putString("ipnumber", number).commit();
		Toast.makeText(getApplicationContext(), "����ɹ�", 0).show();
		
		
	}
	
}
