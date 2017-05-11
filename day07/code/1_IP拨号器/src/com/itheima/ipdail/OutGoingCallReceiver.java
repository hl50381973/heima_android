package com.itheima.ipdail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * 定义一个广播接收者 就要在清单文件里面配置一下
 * @author jhon
 *
 */
public class OutGoingCallReceiver extends BroadcastReceiver {

	//当接收到外拨电话的事件的时候回执行这个方法
	@Override
	public void onReceive(Context context, Intent intent) {

		//[0]获取到我们保存的ip号码 
		SharedPreferences sp = context.getSharedPreferences("config", 0);
		//[0.1]获取我们保存的ip号码
		String ipnumber = sp.getString("ipnumber", "");
		
		
		//[1]获取当前我们要拨打的电话号码 
		String currentNumber = getResultData();
		
		//[1.1]判断拨打的电话是否是长途 
		if (currentNumber.startsWith("0")) {
			//[2]在当前的号码前面加上一个17951 
			setResultData(ipnumber+currentNumber);
		}
		
		
		
		
		
		
	}

}
