package com.example.a1605417.myapp2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;

/**
 * Created by 1605417 on 24-Oct-17.
 */

public class MyRcvr extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String num=intent.getStringExtra("abc");
        String txt=intent.getStringExtra("cde");
        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage(num,null,txt,null,null);

    }
}
