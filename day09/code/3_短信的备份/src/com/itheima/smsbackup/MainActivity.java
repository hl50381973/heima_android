package com.itheima.smsbackup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.xmlpull.v1.XmlSerializer;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.database.Cursor;
import android.util.Xml;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	//�����ť��ѯ�������� Ȼ��Ѷ������ݽ��б���
	public void click(View v) {

		try {
			//[1]��ȡXmlSerializer��ʵ��
			XmlSerializer serializer = Xml.newSerializer();
			//[2]�������л������� 
			File file = new File(Environment.getExternalStorageDirectory().getPath(),"smsbackup.xml");
			FileOutputStream fos = new FileOutputStream(file);
			serializer.setOutput(fos, "utf-8");
			//[3]дxml�ĵ���ͷ 
			serializer.startDocument("utf-8", true);
			
			//[4]дxml�ĸ��ڵ�
			serializer.startTag(null, "smss");
			//[5]����uri
			Uri uri = Uri.parse("content://sms/");
			
			//[6]���ڶ��ŵ����ݿ��Ѿ�ͨ�������ṩ�߱�¶���� ��������ֱ��ͨ�����ݽ����߲�ѯ 
			Cursor cursor = getContentResolver().query(uri, new String[]{"address","date","body"}, null, null, null);
			while(cursor.moveToNext()){
				String address = cursor.getString(0);
				String date = cursor.getString(1);
				String body = cursor.getString(2);

				//[7]дsms�ڵ� 
				serializer.startTag(null, "sms");
				//[8]дaddress�ڵ� 
				serializer.startTag(null, "address");
				serializer.text(address);
				serializer.endTag(null, "address");
				
				//[9]дdate�ڵ� 
				serializer.startTag(null, "date");
				serializer.text(date);
				serializer.endTag(null, "date");
				//[10]дbody�ڵ� 
				serializer.startTag(null, "body");
				serializer.text(body);
				serializer.endTag(null, "body");
				
				serializer.endTag(null, "sms");
				
			}
			
			serializer.endTag(null, "smss");
			serializer.endDocument();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	

}
