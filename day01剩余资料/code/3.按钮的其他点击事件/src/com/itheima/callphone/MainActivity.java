package com.itheima.callphone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itheima.otherclick.R;

public class MainActivity extends Activity implements OnClickListener {

	private EditText et_number;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		et_number = (EditText) findViewById(R.id.et_number);
		Button bt_callphone = (Button) findViewById(R.id.bt_callphone);//�ҵ�Button��Ϊ�����õ���¼�
		//2.���ð�ť�ĵ���¼�
		bt_callphone.setOnClickListener(new MyOnclickListener());


		Button button2 = (Button) findViewById(R.id.button2);
		Button button3 = (Button) findViewById(R.id.button3);
		Button button4 = (Button) findViewById(R.id.button4);

		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		
		

	}

	
	public void callPhoneClick(View v){
		System.out.println("bt1�������");
	}
	
	class MyOnclickListener implements OnClickListener{
		//onclick :�ؼ��������ʱ��ص��ø÷���
		@Override
		public void onClick(View v) {
			callphone();
		}

	}


	private void callphone() {
		//3.��ȡ�û�����ĵ绰����
		String number = et_number.getText().toString().trim();//ͨ��EditText��ȡ�ÿؼ�����ʾ���ı�����
		//4.����绰����
		Intent intent = new Intent();//����һ����ͼ���� ū������绰
		intent.setAction(Intent.ACTION_CALL);//������ͼ����Ķ�������绰
		intent.setData(Uri.parse("tel:"+number));// ������ͼ��������ݣ�����ū������ĵ绰����
		startActivity(intent);//ȥ����һ����ͼ����
	}

	//onclick �����н���һ��view�����ĸ��ؼ��������view�ʹ����ĸ��ؼ�
	@Override
	public void onClick(View v) {
		//��ȡ�������ť��id
		int id = v.getId();
		switch (id) {
		case R.id.button1:
			callphone();
			break;
		case R.id.button2:
			System.out.println("2�������");
			break;
		case R.id.button3:
			System.out.println("3�������");
			break;
		case R.id.button4:
			//context :�����Ķ��󣬴���Ӧ��ȫ����Ϣ text:��ʾ����Ϣ  duration:ʱ��
			Toast toast = Toast.makeText(this, "4�������", Toast.LENGTH_SHORT);
			toast.show();//չʾtoast
			break;
		default:
			break;
		}

	}


}
