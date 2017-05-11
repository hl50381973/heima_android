package com.itheima.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	//oncreate ：是Activity启动时调用 ， activity 相当于java web中的servlet， layout 相当于java web中的jsp
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将一个布局文件作为activity的内容显示
        setContentView(R.layout.activity_main);
        
        
        
    }


 
}
