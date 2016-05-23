package com.example.administrator.batterymanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver batteryReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if(action.equals(Intent.ACTION_BATTERY_CHANGED))
                {
                    int level = intent.getIntExtra("level", -1);
                    String battery = String.valueOf(level);
                    Intent newIntent = new Intent();
                    PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, newIntent, 0);

                    if(level >= 0 && level % 10 == 0)
                    {
                        Toast.makeText(context, "battery left: " + battery, Toast.LENGTH_SHORT).show();

                        Notification notification = new Notification.Builder(context)
                                .setContentTitle("Battery Notify: ")
                                .setContentText("battery left: "+ battery)
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentIntent(pendingIntent)
                                .setTicker("battery left: " + battery)
                                .setWhen(System.currentTimeMillis())
                                .setAutoCancel(true)
                                .build();

                        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.notify(level / 10, notification);
                    }

                }
            }
        };
    }

    @Override
    protected  void onResume(){
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, intentFilter);
    }

    @Override
    protected  void onPause(){
        super.onPause();
        unregisterReceiver(batteryReceiver);
    }
}
