package com.itheima.dialog;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// �����ť ����һ����ͨ�Ի���
	public void click1(View v) {

		// ����AlertDialog
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("����");
		builder.setMessage("��������ңԶ�ľ�����û������");
		builder.setPositiveButton("ȷ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				System.out.println("�����ȷ����ť ִ�е��߼�");

			}
		});
		builder.setNegativeButton("ȡ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				System.out.println("�����ȡ����ť");
			}
		});
		// ���һ��һ��Ҫ�ǵ� show����
		builder.show();

	}

	// �����ť ����һ����ѡ�Ի���
	public void click2(View v) {

		// ����AlertDialog
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("��ѡ����ϲ���Ŀ�");
		final String items[] = { "Android", "ios", "php", "c", "C++", "html" };
		builder.setSingleChoiceItems(items, -1, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				// ȡ�����е���Ŀ
				String item = items[which];
				Toast.makeText(getApplicationContext(), item, 1).show();
				// �رյ�ǰ�Ի���
				dialog.dismiss();
			}
		});

		// ���һ��һ��Ҫ�ǵ� show����
		builder.show();

	}

	// �����ť ����һ����ѡ�Ի���
	public void click3(View v) {
		// ����AlertDialog
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle("��ѡ����ϲ���Ե�ˮ��");
		final String items[] = { "����", "ƻ��", "����", "�㽶", "�ƹ�", "������", "��֦" };
		final boolean[] checkedItems = { true, false, false, false, false,
				false, true };
		builder.setMultiChoiceItems(items, checkedItems,
				new OnMultiChoiceClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {

					}
				});
		builder.setPositiveButton("ȷ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				StringBuffer sb = new StringBuffer();
				// [1]����ѡ�е�ˮ����ȡ����
				for (int i = 0; i < checkedItems.length; i++) {
					if (checkedItems[i]) {
						// ��֤����ѡ�е�
						String fruit = items[i];
						sb.append(fruit + " ");

					}

				}

				Toast.makeText(getApplicationContext(), sb.toString(), 1)
						.show();
				// �رնԻ���
				dialog.dismiss();

			}
		});

		// ���һ��һ��Ҫ�ǵ� show����
		builder.show();

	}

	//�������Ի���
	public void click4(View v) {

		//�������صĿؼ�������ֱ�������̸߳���ui 
		final ProgressDialog dialog = new ProgressDialog(this);
		dialog.setTitle("������������ing");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.show();
		//���ý����������ֵ 
		dialog.setMax(100);
		new Thread(){public void run() {
			for (int i = 0; i <= 100; i++) {
				//���õ�ǰ�Ľ��� 
				
				SystemClock.sleep(50);//˯��50����
				dialog.setProgress(i);
			}
			//�رնԻ���
			dialog.dismiss();
			
			
		};}.start();
		
		
	}

}
