package com.example.administrator.alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private Button bt_Set;
    private AlarmManager alarmManager;
    private Calendar calendar;
    private Intent intent;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker)findViewById(R.id.clock);
        bt_Set = (Button)findViewById(R.id.bt_set);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        calendar = Calendar.getInstance();
        intent = new Intent();
        intent.setClass(MainActivity.this, AlarmReceiver.class);

        bt_Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int setHour = timePicker.getHour();
                int setMinute = timePicker.getMinute();
                calendar.setTimeInMillis(System.currentTimeMillis());
                int nowHour = calendar.get(Calendar.HOUR_OF_DAY);
                int nowMinute = calendar.get(Calendar.MINUTE);
                if(nowHour > setHour || (nowHour == setHour && nowMinute >= setMinute) )
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.HOUR_OF_DAY, setHour);
                calendar.set(Calendar.MINUTE, setMinute);
                long interval = 1000 * 60 * 60 * 24;
                pendingIntent = PendingIntent.getBroadcast(MainActivity.this, setHour * 60 + setMinute, intent, 0);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), interval, pendingIntent);
                Toast.makeText(MainActivity.this, "鬧鐘設定完成", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
