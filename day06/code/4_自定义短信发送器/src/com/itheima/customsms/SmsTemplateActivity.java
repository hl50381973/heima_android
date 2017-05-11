package com.itheima.customsms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SmsTemplateActivity extends Activity {

	
	String objects[] = {"���ڿ���,���Ժ���ϵ","���ڳԷ�,���Ժ���ϵ","���ڴ����,���Ժ���ϵ","���ڿ���,���Ժ���ϵ","����Լ��,���Ժ���ϵ"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_template);
		
		//[1]�ҵ�lv�ؼ�
		ListView lv = (ListView) findViewById(R.id.lv);
		//[2]�������������� 
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item, objects);
		//[3]������չʾ��listview�� 
		lv.setAdapter(adapter);
		//[4]��lv���õ���¼� 
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			
				//[5]��ȡ���ǵ�����Ŀ������  
				String smscontent = objects[position];
				//[6]��������ݷ��ظ������� 
				Intent intent = new Intent();
				intent.putExtra("smscontent", smscontent);
				//[7]ͨ��������������ݷ��ظ�������  
				setResult(20, intent);
				//[8]Ҫ�ǵõ���finish 
				finish();
				
				
			}
		});
		
		
		
		
	}
}
