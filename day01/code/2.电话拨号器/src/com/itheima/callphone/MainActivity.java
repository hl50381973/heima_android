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
        
        
       //1.�ҵ���Ҫʹ�õĿؼ�  id:��Դ��R�ļ��еĳ�������
        final EditText et_number = (EditText) findViewById(R.id.et_number);//�ҵ�EditeText��Ϊ�˻�ȡ�û�����ĵ绰����
        Button bt_callphone = (Button) findViewById(R.id.bt_callphone);//�ҵ�Button��Ϊ�����õ���¼�
        
        //2.���ð�ť�ĵ���¼�
        bt_callphone.setOnClickListener(new OnClickListener() {
			//onclick :�ؼ��������ʱ��ص��ø÷���
			@Override
			public void onClick(View v) {
				//3.��ȡ�û�����ĵ绰����
				String number = et_number.getText().toString().trim();//ͨ��EditText��ȡ�ÿؼ�����ʾ���ı�����
				//4.����绰����
				Intent intent = new Intent();//����һ����ͼ���� ū������绰
				intent.setAction(Intent.ACTION_CALL);//������ͼ����Ķ�������绰
				intent.setData(Uri.parse("tel:"+number));// ������ͼ��������ݣ�����ū������ĵ绰����
				startActivity(intent);//ȥ����һ����ͼ����
				
				
			/*	Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://www.baidu.com"));
				startActivity(intent);
				*/
			}
		});
        
        
        
        
    }



}
