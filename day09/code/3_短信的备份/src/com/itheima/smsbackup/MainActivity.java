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


	//点击按钮查询短信内容 然后把短信内容进行备份
	public void click(View v) {

		try {
			//[1]获取XmlSerializer的实例
			XmlSerializer serializer = Xml.newSerializer();
			//[2]设置序列化器参数 
			File file = new File(Environment.getExternalStorageDirectory().getPath(),"smsbackup.xml");
			FileOutputStream fos = new FileOutputStream(file);
			serializer.setOutput(fos, "utf-8");
			//[3]写xml文档开头 
			serializer.startDocument("utf-8", true);
			
			//[4]写xml的根节点
			serializer.startTag(null, "smss");
			//[5]构造uri
			Uri uri = Uri.parse("content://sms/");
			
			//[6]由于短信的数据库已经通过内容提供者暴露出来 所以我们直接通过内容解析者查询 
			Cursor cursor = getContentResolver().query(uri, new String[]{"address","date","body"}, null, null, null);
			while(cursor.moveToNext()){
				String address = cursor.getString(0);
				String date = cursor.getString(1);
				String body = cursor.getString(2);

				//[7]写sms节点 
				serializer.startTag(null, "sms");
				//[8]写address节点 
				serializer.startTag(null, "address");
				serializer.text(address);
				serializer.endTag(null, "address");
				
				//[9]写date节点 
				serializer.startTag(null, "date");
				serializer.text(date);
				serializer.endTag(null, "date");
				//[10]写body节点 
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
