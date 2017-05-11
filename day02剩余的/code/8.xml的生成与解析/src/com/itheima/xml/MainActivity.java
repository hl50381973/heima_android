package com.itheima.xml;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.itheima.xml.util.SmsUtils;

public class MainActivity extends Activity implements OnClickListener {

	private Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		//1.找到控件
		Button bt_backup = (Button) findViewById(R.id.bt_backup);
		Button bt_restore = (Button) findViewById(R.id.bt_restore);
		//2.设置点击事件
		bt_backup.setOnClickListener(this);
		bt_restore.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_backup:
			if(SmsUtils.backupSms_android(mContext)){
				Toast.makeText(mContext, "短信备份成功", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(mContext, "短信备份失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.bt_restore:
			int result = SmsUtils.restoreSms(mContext);
			Toast.makeText(mContext, "成功恢复"+result+"条短信", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}


}
