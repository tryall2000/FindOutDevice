package com.example.administrator.findoutdevice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018-08-06.
 */

public class Test1 extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    public static TextView tv;

    public static Date dt;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // TODO Auto-generated method stub
        Vibrator vibrator = (Vibrator) this.getSystemService(this.VIBRATOR_SERVICE);
        vibrator.vibrate(4 * 1000);

        //intent = new Intent(MainActivity.this, MainActivity.class);
        //startActivity(intent);
        PendingIntent pi = PendingIntent.getService(this, 0, intent, 0);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);   //AlarmManager对象
        //设置闹钟从当前时间开始，每隔5s执行一次PendingIntent对象pi，注意第一个参数与第二个参数的关系
        // 5秒后通过PendingIntent pi对象发送广播
        //am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 0, 5 * 1000, pi); //void android.app.AlarmManager.setRepeating(int type, long triggerAtMillis, long intervalMillis, PendingIntent operation)
        //am.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 30 * 1000, pi);
        am.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 60 * 1000, pi);
        Date dt_Inner = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tv.setText(tv.getText()  +"\n"+df.format(dt_Inner) + "   " + (dt_Inner.getTime() - dt.getTime()));
        dt = dt_Inner;
        return super.onStartCommand(intent, flags, startId);
    }
}