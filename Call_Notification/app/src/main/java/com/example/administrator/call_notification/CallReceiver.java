package com.example.administrator.call_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallReceiver extends BroadcastReceiver {
    private int id = 0;
    public CallReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("XDD", "XD");
        String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
        {
            Intent newIntent = new Intent();
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, newIntent, 0);

            Notification notification = new Notification.Builder(context)
                    .setContentTitle("來電提醒:")
                    .setContentText(number + "來電")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pendingIntent)
                    .setTicker(String.valueOf(number) + "來電")
                    .setWhen(System.currentTimeMillis())
                    .setAutoCancel(true)
                    .build();

            NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(id++, notification);
        }
    }
}
