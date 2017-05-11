package com.itheima.rpcalc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_name;
	private RadioGroup rg_group;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//(1)�ҵ����ǹ��ĵĿؼ�
		et_name = (EditText) findViewById(R.id.et_name);
		rg_group = (RadioGroup) findViewById(R.id.rg_group);
		
	}

	//�����ť ��ȡ���� ��ת��resultActivityҳ�� 
	public void click(View v) {
		
		//[1]��ȡ�û���
		String name = et_name.getText().toString().trim();
		if (TextUtils.isEmpty(name)) {
			Toast.makeText(getApplicationContext(), "�û�������Ϊ��", Toast.LENGTH_LONG).show();
			return;
		}
		
		//[2]�ж�ѡ���Ա�
		int checkedRadioButtonId = rg_group.getCheckedRadioButtonId();
		//[3]�ж�һ�¾���ѡ�е��Ա� 
		int sex = 0; //Ĭ��ֵΪ0
		switch (checkedRadioButtonId) {
		case R.id.rb_male:   //ѡ�е�����
			sex = 1;
			break;
			
		case R.id.rb_female: //ѡ�е���Ů
			sex = 2;
			
			break;

		case R.id.rb_other: //����ѡ�е�������
			sex = 3;
			break;
		}
		//[4]�ж��Ա�
		if (sex == 0) {
			Toast.makeText(getApplicationContext(), "�� ��ѡ���Ա� ", 0).show();
			return;
		}

		//[5] ��ת��resutActivityҳ��  ��ʾ��ͼ
		Intent intent = new Intent(this,ResultActivity.class);
		
		//[5.1]Ҫ��name �� sex ���ݵ����ҳ��  �ײ�map
		intent.putExtra("name", name);
		intent.putExtra("sex", sex);
		
		//[6]����Activity
		startActivity(intent);
		
		
		
	}
	

}
