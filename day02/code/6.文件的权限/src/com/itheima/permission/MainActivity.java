package com.itheima.permission;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try{
			this.openFileOutput("private.txt", Context.MODE_PRIVATE).write("我是private".getBytes());
			this.openFileOutput("append.txt", Context.MODE_APPEND).write("我是append".getBytes());
			this.openFileOutput("write.txt", Context.MODE_WORLD_WRITEABLE).write("我是write".getBytes());
			this.openFileOutput("read.txt", Context.MODE_WORLD_READABLE).write("我是read".getBytes());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}


}
