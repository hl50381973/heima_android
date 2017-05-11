package com.itheima.newactivity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//����һ������
		setContentView(R.layout.activity_main);
		
	}

	//�����ť ʵ�ֲ���绰���߼�
	public void click1(View v) {
		//[1]������ͼ����  ��ͼ :�����һ��ʲô����
		Intent intent = new Intent();
		//[2]������ͼ��action(����)
		intent.setAction(Intent.ACTION_CALL);
		//[3]�������� data
		intent.setData(Uri.parse("tel:"+119)); //��119��绰 
		//[4]����activity   �ǵü���call_phone��Ȩ��
        startActivity(intent); 
		
		
	}
	
	

	//�����ť ��ת��TestActivity
	public void click2(View v) {
		//[1]������ͼ���� 
		Intent intent = new Intent();
		//[2]������ͼ��action(����)
		intent.setAction("com.itheima.testactivity");
		//[3]����һ��category
		intent.addCategory("android.intent.category.DEFAULT");
		
		//[3.2]������������ type ����������Զ����ͨ��setdata�������õ�����
//		intent.setType("aa/bb");
		
		//[3.1]����һ��data
		intent.setData(Uri.parse("itheima:"+119));
		
	
		//������ע�� ���type �� dataͬʱʹ�õ�ʱ��  Ӧ�����������
//		intent.setDataAndType(Uri.parse("itheima1:"+119), "aa/bb1");
		
		//[4]����activity   �ǵü���call_phone��Ȩ��
        startActivity(intent); 
		
		
	}
	
	//�����ť ��ת��TestActivity2ҳ��  
	public void click3(View v) {
		//[1]������ͼ���� 
	    Intent intent = new Intent(this,TestActivity2.class);
		//[2]ָ������������ ���� ҳ�� 
//	    intent.setClassName("com.itheima.newactivity", "com.itheima.newactivity.TestActivity2");
		//[3]����activity   
        startActivity(intent); 
	    
	}
	
	
	
	
}
