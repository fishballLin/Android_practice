package com.example.administrator.broadcast_implement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MainReceiver extends BroadcastReceiver {
    public MainReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String msg = intent.getStringExtra(MainActivity.KEY_MSG);
        Log.i("XDD","receive");
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
                Log.i("XDD","dialog");
                context.startActivity(newIntent);
                break;
            case "fishballLin.Notification":

        }
    }
}
