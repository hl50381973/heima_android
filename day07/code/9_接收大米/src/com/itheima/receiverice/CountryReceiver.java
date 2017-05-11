
package com.itheima.receiverice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CountryReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//[1]获取到发送广播携带的数据 
		String content = getResultData();
		
		//[2]展示到Toast上
		Toast.makeText(context, "乡:"+content, 1).show();

		//[3]修改数据 (扣留大米)
		setResultData("习大大给每个村民发了10斤大米");
		
	}

}
