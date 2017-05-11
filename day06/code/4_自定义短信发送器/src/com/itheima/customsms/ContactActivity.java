package com.itheima.customsms;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ContactActivity extends Activity {

	private List<Contact> contactLists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//���ز���
		setContentView(R.layout.activity_contact);
		//[1]�ҵ�lv�ؼ� 
		ListView lv_contact = (ListView) findViewById(R.id.lv_contact);
		//[2]������ֻ����� ��ϵ�˵�����չʾ��listview��  �Ƚ������ṩ����ȥ��ȡ��ʵ����  
		
		contactLists = new ArrayList<Contact>();  
		for (int i = 0; i < 10; i++) {
			
			Contact contact = new Contact();
			contact.setName("zhangsan"+i);
			contact.setPhone("1388900"+i);
			contactLists.add(contact);
			
		}
		//[3]չʾ����  �������������� 
		lv_contact.setAdapter(new MyAdapter());
		//[4]��listview����Ŀ���õ���¼� 
		lv_contact.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				
				//[5]ȡ�����ǵ�����Ŀ������  
				String phone = contactLists.get(position).getPhone();
				System.out.println("phone:"+phone);
				//[6]��phone ���ظ���һ��ҳ��  
				Intent intent = new Intent();
				intent.putExtra("name", phone);
				//[7]�����ݷ��ظ������� Call this to set the result that your activity will return to its caller. 
				setResult(10, intent);
				//[8]�رյ�ǰActivity mainActivity��onActivityResult�����ͻ�ִ��
				finish();
				
				
			}
		});
		
		
		
	}
	
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
	
	//�������������� 
	private class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return contactLists.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View  view;
			if (convertView == null) {
				view = View.inflate(getApplicationContext(), R.layout.contact_item, null);
			}else {
				//������ʷ�������  
				view = convertView;
				
			}
			//�ҵ����ǹ��Ŀؼ� 
			TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
			TextView tv_phone = (TextView) view.findViewById(R.id.tv_phone);
			//�������� 
			tv_name.setText(contactLists.get(position).getName());
			tv_phone.setText(contactLists.get(position).getPhone());
			
			return view;
		}
		
	}
	
	
}
