package com.itheima.sendrice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * ���յ�receiver ����Ҫ���嵥�ļ���������
 * @author jhon
 *
 */
public class FinalReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		String content = getResultData();

		Toast.makeText(context, "����ϰ���"+content, 1).show();
		
		
	}

}
