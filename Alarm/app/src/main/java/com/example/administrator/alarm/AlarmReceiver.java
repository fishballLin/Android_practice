package com.example.administrator.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    private static long time;
    private static boolean t = false;

    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("XDD", "receive");
        /*Intent newIntent = new Intent();
        newIntent.setClass(context, AlarmActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(newIntent);*/
        /*Log.i("XDD",  Boolean.toString(t));
        t = true;*/
        //Log.i("XDD",  Boolean.toString(t));
        if(!t)
        {
            //Log.i("XDD",  "OK");
            time = System.currentTimeMillis();
            //Log.i("XDD", Boolean.toString(t));
            //Log.i("XDD",  "SET");
            t = true;
            Log.i("XDD",  "GG");
            //Log.i("XDD", Boolean.toString(t));
            //Log.i("XDD", "XDD");
        }
        else
        {
            //Log.i("XDD", Long.toString(time));
            //Log.i("XDD", Long.toString(System.currentTimeMillis()));
            Log.i("XDD", Long.toString(System.currentTimeMillis() - time));
            Toast.makeText(context, Long.toString(System.currentTimeMillis() - time), Toast.LENGTH_SHORT).show();
            time = System.currentTimeMillis();
        }

    }
}
