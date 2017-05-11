package com.itheima.muchdown_android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedUtils {

	
	public static int getLastPosition(Context context,int threadId){
		
		SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		return defaultSharedPreferences.getInt("lastPostion"+threadId, -1);
		
	}
	
	public static void setLastPosition(Context context,int threadId,int position){
		SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		defaultSharedPreferences.edit().putInt("lastPostion"+threadId, position).commit();
	}
}
