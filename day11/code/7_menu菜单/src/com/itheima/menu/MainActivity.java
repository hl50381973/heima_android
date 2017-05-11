package com.itheima.menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
//		[1]getMenuInflater().inflate(R.menu.main, menu);
		
	   //[2]��Ӳ˵� 
		menu.add(0, 1, 0, "����");
		menu.add(0, 2, 0, "ǰ��");
		return true;
	}
	
	//��֪������������menu���ĸ���Ŀ ��Ҫ��д�������
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			
			System.out.println("����");
			break;
			
	case 2:
		System.out.println("ǰ��");
			break;

		default:
			break;
		}
		
		
		return super.onOptionsItemSelected(item);
	}
	
	//�����menu������ʱ��ִ��������� 
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		
		//����һ���Ի��� 
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("����");
		builder.setMessage("���������쳣");
		builder.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				System.out.println("����ȷ��");
			}
		});
		builder.setNegativeButton("ȡ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//���ȡ��ִ�� 
				System.out.println("ȡ��");
				
			}
		});
		//ʹ�öԻ���һ��Ҫ�ǵ�show���� 
		builder.show();
		
		return false;
	}
	
	//�����ť��תTestActivity
	public void click(View v) {
		Intent intent = new Intent(this,TestActity.class);
		startActivity(intent);
		
	}

}
