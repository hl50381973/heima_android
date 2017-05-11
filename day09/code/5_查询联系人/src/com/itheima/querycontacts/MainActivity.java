package com.itheima.querycontacts;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		List<Contact> queryContacts = QueryContactsUtils.queryContacts(getApplicationContext());
		for (Contact contact : queryContacts) {
			System.out.println("contat:"+contact);
			
		}
		
		
		
	}

	

}
