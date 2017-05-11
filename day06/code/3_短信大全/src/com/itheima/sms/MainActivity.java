package com.itheima.sms;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	//[0]��װ����������
	String objects[] = {"����ķ�������ޱȣ�����Ļ�����Ʈ�����������ʮ�ֻ�ϲ��������ƶ�����Ц�⣻������¶����˳����������˶�������ۡ�������...",
			"Ѿͷ�����������Լ��ģ�������Ͷ���ޣ���Ц���Ͷ���Ц��ת�ۣ�����һ�꣬������ռ������������꣬�����ٲ����Ҷ����ף�������̲�ס...",
			"����������������������������ĺ���������������ů��Ц�ݣ���������ů��Ц�������裬ԭ������ʱ�Ҳ�����������ߣ�������������...",
			"������������գ�ף�㣺������ͷ�����ӱޣ�һ��ǧ���չ�ٶ������Ͻ�ˮ���Ʋ��ɵ������·�������������ﲻ����ף�����������..."}; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//(1)��ȡ�ؼ� 
		ListView lv = (ListView) findViewById(R.id.lv);
		//(2)lvչʾ������Ҫ���������� adapter
		ArrayAdapter<String>  adapter = new  ArrayAdapter<String>(getApplicationContext(), R.layout.item, objects);
		
		//(3)�������������� 
		lv.setAdapter(adapter);
		//(4)������Ŀ�ļ��� 
		lv.setOnItemClickListener(new OnItemClickListener() {

			//����Ŀ�������ʱ�����
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				//(5) ��ȡ���ǵ����Ŀ������  С����   ��������������� ��ȥ����ȥ
				String content = objects[position];
				
				System.out.println("content:"+content);
				
				//(6)��ת�����Ͷ���ҳ��  ����ʽ��ͼ  
			     /*<intent-filter>
	               <action android:name="android.intent.action.SEND" />
	               <category android:name="android.intent.category.DEFAULT" />
	               <data android:mimeType="text/plain" />
	           </intent-filter>*/
				//(7)������ͼ���� 
				Intent intent = new Intent();
				intent.setAction("android.intent.action.SEND");
				intent.addCategory("android.intent.category.DEFAULT");
				intent.setType("text/plain");
				
				//(7.1)�����ݴ��ݵ� ���ŵķ���ҳ�� 
				intent.putExtra("sms_body", content);  //Ҫ����֪���������ô���� ??
				
				//(8)������ͼ 
				startActivity(intent);
				
			}
		});
		
		
		
		
		
	}

	

}
