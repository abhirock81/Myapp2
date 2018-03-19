package com.example.a1605417.myapp2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calling(View view) {
        EditText editText1 = (EditText) findViewById(R.id.q);
        String num = editText1.getText().toString();

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
        startActivity(intent);
    }
    public void messaging(View view) {
        EditText editText2=(EditText)findViewById(R.id.e);
        EditText editText3=(EditText)findViewById(R.id.w);
        EditText editText4=(EditText)findViewById(R.id.t);
        String num=editText2.getText().toString();
        String txt=editText3.getText().toString();
        long time= Long.parseLong(editText4.getText().toString());
        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent=new Intent(this,MyRcvr.class);
        intent.putExtra("abc",num);
        intent.putExtra("cde",txt);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),10,intent,0);
        alarmManager.set(AlarmManager.RTC,(System.currentTimeMillis()+time)*1000,pendingIntent);
    }
}
