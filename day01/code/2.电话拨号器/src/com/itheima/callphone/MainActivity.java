package com.itheima.callphone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
       //1.找到需要使用的控件  id:资源在R文件中的常量引用
        final EditText et_number = (EditText) findViewById(R.id.et_number);//找到EditeText是为了获取用户输入的电话号码
        Button bt_callphone = (Button) findViewById(R.id.bt_callphone);//找到Button是为了设置点击事件
        
        //2.设置按钮的点击事件
        bt_callphone.setOnClickListener(new OnClickListener() {
			//onclick :控件被点击的时候回调用该方法
			@Override
			public void onClick(View v) {
				//3.获取用户输入的电话号码
				String number = et_number.getText().toString().trim();//通过EditText获取该控件上显示的文本内容
				//4.拨打电话号码
				Intent intent = new Intent();//创建一个意图对象； 奴隶，打电话
				intent.setAction(Intent.ACTION_CALL);//设置意图对象的动作，打电话
				intent.setData(Uri.parse("tel:"+number));// 设置意图对象的数据，告诉奴隶拨打的电话号码
				startActivity(intent);//去启动一个意图对象
				
				
			/*	Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.baidu.com"));
				startActivity(intent);
				*/
			}
		});
        
        
        
        
    }



}
