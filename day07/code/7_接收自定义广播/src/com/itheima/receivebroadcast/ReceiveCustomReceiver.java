package com.itheima.receivebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiveCustomReceiver extends BroadcastReceiver {

	//当我发送自定义广播的时候 这个方法就会接收到 
	@Override
	public void onReceive(Context context, Intent intent) {

		//[0]终止广播
//		abortBroadcast();
		
		//[1]取出我们发送广播携带的数据 
		String content = intent.getStringExtra("name");
		//[2]把获取到的数据展示到toast上
		Toast.makeText(context, content, 0).show();
		
	}

}
