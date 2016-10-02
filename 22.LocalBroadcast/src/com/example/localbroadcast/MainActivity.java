package com.example.localbroadcast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
     private Button send_BUT;
     private LocalBroadcastManager localBroadcastManager;
     private MyLocalReceiver myLocalReceiver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		localBroadcastManager =LocalBroadcastManager.getInstance(this);
		send_BUT =(Button) findViewById(R.id.sendBut);
		
		//1.创建广播过滤活动
		IntentFilter filter =new IntentFilter("com.zjy.localBroadcast.MY_LOCALBROADCAST");
		
		//2.注册本地广播接收者
		 myLocalReceiver = new MyLocalReceiver();
		localBroadcastManager.registerReceiver(myLocalReceiver, filter);
		
		send_BUT.setOnClickListener(this);
	}
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	localBroadcastManager.unregisterReceiver(myLocalReceiver);
    }
	@Override
	public void onClick(View v) {
		
		//1.建立发送广播的意图，由于是动态的注册所以要注册地址
		Intent intent  =new Intent("com.zjy.localBroadcast.MY_LOCALBROADCAST");
		localBroadcastManager.sendBroadcast(intent);
	}
}
