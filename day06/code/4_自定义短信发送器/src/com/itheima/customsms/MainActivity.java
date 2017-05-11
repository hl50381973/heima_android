package com.itheima.customsms;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText et_number;
	private EditText et_sms_content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//[1]��ȡ���ǹ��ĵĿؼ� 
		
		et_number = (EditText) findViewById(R.id.et_number);
		et_sms_content = (EditText) findViewById(R.id.et_sms_content);
		
		
	}

	//�����ť ��ת������ģ��ҳ�� 
	public void insert(View v){
		
		Intent intent = new Intent(this,SmsTemplateActivity.class);
		//�����Activity��2�ַ�ʽ  
		//(1)�����Ҫ������Activity�Ľ�������� �� startActivityForResult();
		//(2)������Ǽ�򵥵�ҳ�����ת  ����startActivity()
		startActivityForResult(intent, 2);
		
	}
	
	
	
	//���+ ��ť ��ת�� ��ϵ��ҳ�� 
	public void add(View v) {
		//[1]������ͼ����  
		Intent intent = new Intent(this,ContactActivity.class);
		//[2]����Activity
//		startActivity(intent);
		//[3]Сϸ�� �����  ���һ��ҳ�濪������һ��ҳ��  ���ҵ����������ҳ��رյ�ʱ�� ��Ҫ����һ��ҳ�������  ʹ�����������������Activity
		startActivityForResult(intent, 1);
		
		
	}
	
	//�����ťʵ�ַ��Ͷ��ŵ��߼� 
	public void click(View v) {
		String number = et_number.getText().toString().trim();
		String content = et_sms_content.getText().toString().trim();
		
		//[1]��ȡsmsManager��ʵ��  
		SmsManager smsManager = SmsManager.getDefault();
		//[1.1]����������ݹ����� ������ȥ  �������� 
		ArrayList<String> divideMessages = smsManager.divideMessage(content);
		for (String div : divideMessages) {
			
			//[2]���Ͷ������� 
			smsManager.sendTextMessage(number, null, div, null, null);
		}
		
	
		
		
	}

	//�����ǿ�����Activity��ҳ��رյ�ʱ��������������
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == 1) {
			
			//������Ҫ���� ContactActivity������
			String phone = data.getStringExtra("name");
			et_number.setText(phone);
		}else if (requestCode == 2) {
			//������Ҫ����SmsTemplateActivity ������
			String smscontent = data.getStringExtra("smscontent");
			et_sms_content.setText(smscontent);
			
			
		}
		
		
		/*if (resultCode == 10) {
			//˵���������� ContactActivity���� 
			
			String phone = data.getStringExtra("name");
			et_number.setText(phone);
			
		}else if (resultCode == 20) {
			//˵����������SmsTemplateActivity���� 
			String smscontent = data.getStringExtra("smscontent");
			et_sms_content.setText(smscontent);
			
		}
		*/
		
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	

}
