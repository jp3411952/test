package com.example.localbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyLocalReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "���ձ��صĹ㲥ֻ�����ڵ�ǰ��Ӧ�ó���",
				Toast.LENGTH_SHORT).show();
	}

}
