package com.itheima.phonelistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

	//当手机重启后 会执行该方法 
	@Override
	public void onReceive(Context context, Intent intent) {

		//就把开启服务的逻辑 放到 这个方法里 
		
		Intent intent1 = new Intent(context,PhoneService.class);
		//开启服务 
		context.startService(intent1);
		
	}

}
