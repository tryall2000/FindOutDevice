package com.example.administrator.findoutdevice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import junit.framework.Test;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //goTime();
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) this.findViewById(R.id.hello);
//        tv.setText(System.currentTimeMillis() + "");
//        Intent intent = new Intent("ELITOR_CLOCK");
//        intent.putExtra("msg", "五秒钟提示信息");
//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://18689417681"));

        //定义一个PendingIntent对象，PendingIntent.getBroadcast包含了sendBroadcast的动作。
        //也就是发送了action 为"ELITOR_CLOCK"的intent

        Intent intent = new Intent(MainActivity.this, Test1.class);
        Test1.tv = tv;
        Test1.dt = new Date();
        startService(intent);
        //intent = new Intent(MainActivity.this, MainActivity.class);
        //startActivity(intent);
//        PendingIntent pi = PendingIntent.getService(this, 0, intent, 0);
//        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);   //AlarmManager对象
//        //设置闹钟从当前时间开始，每隔5s执行一次PendingIntent对象pi，注意第一个参数与第二个参数的关系
//        // 5秒后通过PendingIntent pi对象发送广播
//        //am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 0, 5 * 1000, pi); //void android.app.AlarmManager.setRepeating(int type, long triggerAtMillis, long intervalMillis, PendingIntent operation)
//        am.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, 5 * 1000, pi);

//        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(MainActivity.this, MainActivity.class), 0);
//        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);   //AlarmManager对象
//        am.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 5 * 1000, pi);
        //am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 5 * 1000, pi); //void android.app.AlarmManager.setRepeating(int type, long triggerAtMillis, long intervalMillis, PendingIntent operation)
    }
}