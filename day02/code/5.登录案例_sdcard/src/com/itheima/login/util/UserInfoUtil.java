package com.itheima.login.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.os.Environment;

public class UserInfoUtil {
	//保存用户名密码
	public static boolean saveUserInfo(Context context,String username, String password) {

		try{
			String userinfo = username + "##"+ password;//封装用户名密码
//			String path = "/mnt/sdcard/";//指定保存的路径
			//通过Environment获取sdcard的目录
			String path = Environment.getExternalStorageDirectory().getPath();
			
			System.out.println("...............:"+path);
			File file = new File(path,"userinfo.txt");//创建file
			FileOutputStream fileOutputStream = new FileOutputStream(file);//创建文件写入流
			fileOutputStream.write(userinfo.getBytes());//将用户名密码写入文件
			fileOutputStream.close();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	//获取用户名密码
	public static Map<String ,String> getUserInfo(Context context){
		
		try{
			//通过Environment获取sdcard的目录
			String path = Environment.getExternalStorageDirectory().getPath();
			
			System.out.println("...............:"+path);
			File file = new File(path,"userinfo.txt");//创建file
			FileInputStream fileInputStream = new FileInputStream(file);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
			//读取一行中包含用户密码，需要解析
			String readLine = bufferedReader.readLine();
			String[] split = readLine.split("##");
			HashMap<String, String> hashMap = new HashMap<String ,String>();
			hashMap.put("username", split[0]);
			hashMap.put("password", split[1]);
			bufferedReader.close();
			fileInputStream.close();
			return hashMap;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
