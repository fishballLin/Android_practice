package com.example.administrator.alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
                int setHour, setMinute;
                if(Build.VERSION.SDK_INT < 23){
                    setHour = timePicker.getCurrentHour();
                    setMinute = timePicker.getCurrentMinute();
                }
                else{
                    setHour = timePicker.getHour();
                    setMinute = timePicker.getMinute();
                }
                calendar.setTimeInMillis(System.currentTimeMillis());
                Log.i("XDD", "time" + String.valueOf(setHour) + " " + String.valueOf(setMinute));
                calendar.set(Calendar.HOUR_OF_DAY, setHour);
                calendar.set(Calendar.MINUTE, setMinute);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                if(System.currentTimeMillis() > calendar.getTimeInMillis())
                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                //Long interval = 1000L * 5;
                pendingIntent = PendingIntent.getBroadcast(MainActivity.this, setHour * 60 + setMinute, intent, 0);
                Log.i("XDD", "before manager");
                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 5000, pendingIntent);
                //alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                String str = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + " " + String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":"+ String.valueOf(calendar.get(Calendar.MINUTE));
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
