package com.itheima.news_listview.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;

import com.itheima.news_listview.R;
import com.itheima.news_listview.bean.NewsBean;
import com.itheima.news_listview.dao.NewsDaoUtils;

public class NewsUtils {


	public static String newsPath_url = "http://192.168.13.83:8080/itheima74/servlet/GetNewsServlet";
	//封装新闻的假数据到list中返回
	public static ArrayList<NewsBean> getAllNewsForNetWork(Context context) {
		ArrayList<NewsBean> arrayList = new ArrayList<NewsBean>();
		try{
			//1.请求服务器获取新闻数据
			//获取一个url对象，通过url对象得到一个urlconnnection对象
			URL url = new URL(newsPath_url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//设置连接的方式和超时时间
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10*1000);
			//获取请求响应码
			int code = connection.getResponseCode();
			if(code == 200){
				//获取请求到的流信息
				InputStream inputStream = connection.getInputStream();
				String result = StreamUtils.streamToString(inputStream);
				
				//2.解析获取的新闻数据到List集合中。
				
					JSONObject root_json = new JSONObject(result);//将一个字符串封装成一个json对象。
					JSONArray jsonArray = root_json.getJSONArray("newss");//获取root_json中的newss作为jsonArray对象
					
					for (int i = 0 ;i < jsonArray.length();i++){//循环遍历jsonArray
						JSONObject news_json = jsonArray.getJSONObject(i);//获取一条新闻的json
						
						NewsBean newsBean = new NewsBean();
						
						newsBean. id = news_json.getInt("id");
						newsBean. comment = news_json.getInt("comment");//评论数
						newsBean. type = news_json.getInt("type");//新闻的类型，0 ：头条 1 ：娱乐 2.体育
						newsBean. time = news_json.getString("time");
						newsBean. des = news_json.getString("des");
						newsBean. title = news_json.getString("title");
						newsBean. news_url = news_json.getString("news_url");
						newsBean. icon_url = news_json.getString("icon_url");
						
						arrayList.add(newsBean);
			
					}

				//3.清楚数据库中旧的数据，将新的数据缓存到数据库中
					new NewsDaoUtils(context).delete();
					new NewsDaoUtils(context).saveNews(arrayList);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	
	//从数据库中获取上次缓存的新闻数据做listview的展示
	public  static ArrayList<NewsBean> getAllNewsForDatabase(Context context) {
		
		return new NewsDaoUtils(context).getNews();

	}
}
