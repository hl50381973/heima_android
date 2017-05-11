package com.itheima.carmea;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// �����ť ��������
	public void click1(View v) {

		// ���� ������ͼ
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		// ���ͼƬ��·��
		File file = new File(Environment.getExternalStorageDirectory()
				.getPath(), "haha.png");
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file)); // set the
																		// image
																		// file
																		// name
		// ����һ��activity ����ȡ���
		startActivityForResult(intent, 1);

	}

	// �����ť ����¼��
	public void click2(View v) {

		// ���� ������ͼ
		Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		// ���ͼƬ��·��
		File file = new File(Environment.getExternalStorageDirectory()
				.getPath(), "haha.3gp");
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file)); // set the
																		// image
																		// file
																		// name
		// ����һ��activity ����ȡ���
		startActivityForResult(intent, 2);

	}

	// �����������Activityҳ��Ĺرյ�ʱ�����
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		System.out.println("���� ����������");
		super.onActivityResult(requestCode, resultCode, data);
	}

}
