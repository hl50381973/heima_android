package com.itheima.videoview;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnPreparedListener;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// [1]插件vitamio框架检查是否可用
		if (!LibsChecker.checkVitamioLibs(this)) {
			return;
		}

		final VideoView vv = (VideoView) findViewById(R.id.vv);
		// 设置播放的路径
		vv.setVideoPath("http://192.168.13.89:8080/aa.avi");
		vv.setOnPreparedListener(new OnPreparedListener() {

			@Override
			public void onPrepared(MediaPlayer mp) {
				vv.start();

			}
		});
		// 设置video的控制器 设置一个进度条
		vv.setMediaController(new MediaController(this));

	}

}
