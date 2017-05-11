package com.itheima.rpcalc;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ����ҳ��
		setContentView(R.layout.activity_result);
		// [1]�ҵ����ǹ��ĵĿؼ�
		TextView tv_name = (TextView) findViewById(R.id.tv_name);
		TextView tv_sex = (TextView) findViewById(R.id.tv_sex);
		TextView tv_result = (TextView) findViewById(R.id.tv_result);

		// [2]��ȡ������Activity����ͼ����
		Intent intent = getIntent();
		// [3]��ȡ����Я������������ ȡ���Ա��name ���ݵ���ʲô������������ ����ȡ��ʱ��
		String name = intent.getStringExtra("name");// ��ȡname
		int sex = intent.getIntExtra("sex", 0);

		// [4]��������ʾ���ؼ���
		tv_name.setText(name); // ��ʾ����

		// [5]��ʾ�Ա�
		byte[] bytes = null;
		
		try {
			switch (sex) {
			case 1: // ������
				tv_sex.setText("��");
				bytes = name.getBytes("gbk");
				
				break;

			case 2:
				tv_sex.setText("Ů");
				bytes = name.getBytes("utf-8");
				break;

			case 3:
				tv_sex.setText("����");
				bytes= name.getBytes("iso-8859-1");
				break;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		//[6]��������������������Ա� ��������Ʒ�÷�  ���ݵ÷���ʾ���  
		int  total = 0;
		for (byte b : bytes) {     //0001 1000
			  int number =b&0xff;             //1111 1111
			  total+=number;
		}
		
		//����÷� 
		int score = Math.abs(total)%100;
		if (score >90) {
			tv_result.setText("������Ʒ�ǳ��� ���ҵ���ض�ð������");
		}else if (score >70) {
			tv_result.setText("������������Ʒ���ǲ�����..");
		}else if (score >60) {
			tv_result.setText("������Ʒ�ոռ���");
		}else{
			tv_result.setText("������Ʒ������....");
			
		}
			
		
		
	}

}
