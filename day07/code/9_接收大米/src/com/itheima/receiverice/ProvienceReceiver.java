
package com.itheima.receiverice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ProvienceReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		//[1]��ȡ�����͹㲥Я�������� 
		String content = getResultData();
		
		//[2]չʾ��Toast��
		Toast.makeText(context, "ʡ:"+content, 1).show();
		
		//[2.1]��ֹ�㲥 
//		abortBroadcast();
		
		//[3]�޸����� (��������)
		setResultData("ϰ����ÿ��������500�����");
		
		
	}

}
