package com.example.administrator.broadcast_implement;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class MainReceiver extends BroadcastReceiver {
    private static int id = 0;
    public MainReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String msg = intent.getStringExtra(MainActivity.KEY_MSG);
        switch (action)
        {
            case "fishballLin.Toast":
                Log.i("XDD","Toast");
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                break;
            case "fishballLin.Dialog":
                Intent newIntent = new Intent();
                newIntent.setClass(context, DialogActivity.class);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                newIntent.putExtra(MainActivity.KEY_MSG, msg);
                context.startActivity(newIntent);
                break;
            case "fishballLin.Notification":
                newIntent = new Intent();
                newIntent.setClass(context, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, newIntent, 0);

                Notification notification = new Notification.Builder(context)
                .setContentTitle("Message Received")
                .setContentText(msg)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setTicker(msg)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .build();

                NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(id++, notification);

        }
    }
}
