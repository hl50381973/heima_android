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
		Button bt_callphone = (Button) findViewById(R.id.bt_callphone);//找到Button是为了设置点击事件
		//2.设置按钮的点击事件
		bt_callphone.setOnClickListener(new MyOnclickListener());


		Button button2 = (Button) findViewById(R.id.button2);
		Button button3 = (Button) findViewById(R.id.button3);
		Button button4 = (Button) findViewById(R.id.button4);

		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		
		

	}

	
	public void callPhoneClick(View v){
		System.out.println("bt1被点击了");
	}
	
	class MyOnclickListener implements OnClickListener{
		//onclick :控件被点击的时候回调用该方法
		@Override
		public void onClick(View v) {
			callphone();
		}

	}


	private void callphone() {
		//3.获取用户输入的电话号码
		String number = et_number.getText().toString().trim();//通过EditText获取该控件上显示的文本内容
		//4.拨打电话号码
		Intent intent = new Intent();//创建一个意图对象； 奴隶，打电话
		intent.setAction(Intent.ACTION_CALL);//设置意图对象的动作，打电话
		intent.setData(Uri.parse("tel:"+number));// 设置意图对象的数据，告诉奴隶拨打的电话号码
		startActivity(intent);//去启动一个意图对象
	}

	//onclick 方法中接受一个view对象，哪个控件被点击，view就代表哪个控件
	@Override
	public void onClick(View v) {
		//获取被点击按钮的id
		int id = v.getId();
		switch (id) {
		case R.id.button1:
			callphone();
			break;
		case R.id.button2:
			System.out.println("2被点击了");
			break;
		case R.id.button3:
			System.out.println("3被点击了");
			break;
		case R.id.button4:
			//context :上下文对象，代表应用全局信息 text:提示的信息  duration:时长
			Toast toast = Toast.makeText(this, "4被点击了", Toast.LENGTH_SHORT);
			toast.show();//展示toast
			break;
		default:
			break;
		}

	}


}
