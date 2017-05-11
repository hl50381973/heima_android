package com.itheima.autocompletetextview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

	//[0]����AutoCompleteTextViewҪ��ʾ������
	  private static final String[] COUNTRIES = new String[] {
	         "laofang", "laozhang", "laoli", "laobi","laoli","laowang","aab","abb","cc"
	     };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//[1]�ҵ��ؼ�
		AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.actv);
		
		//[2]��������������
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);

        //[3]��������������
        actv.setAdapter(adapter);
	}



}
