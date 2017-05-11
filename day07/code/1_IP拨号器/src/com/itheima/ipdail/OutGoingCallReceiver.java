package com.itheima.ipdail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * ����һ���㲥������ ��Ҫ���嵥�ļ���������һ��
 * @author jhon
 *
 */
public class OutGoingCallReceiver extends BroadcastReceiver {

	//�����յ��Ⲧ�绰���¼���ʱ���ִ���������
	@Override
	public void onReceive(Context context, Intent intent) {

		//[0]��ȡ�����Ǳ����ip���� 
		SharedPreferences sp = context.getSharedPreferences("config", 0);
		//[0.1]��ȡ���Ǳ����ip����
		String ipnumber = sp.getString("ipnumber", "");
		
		
		//[1]��ȡ��ǰ����Ҫ����ĵ绰���� 
		String currentNumber = getResultData();
		
		//[1.1]�жϲ���ĵ绰�Ƿ��ǳ�; 
		if (currentNumber.startsWith("0")) {
			//[2]�ڵ�ǰ�ĺ���ǰ�����һ��17951 
			setResultData(ipnumber+currentNumber);
		}
		
		
		
		
		
		
	}

}
