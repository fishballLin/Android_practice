package com.example.administrator.broadcast_implement;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class DialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Log.i("XDD", "start");
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.KEY_MSG);
        AlertDialog.Builder dialog = new AlertDialog.Builder(DialogActivity.this);
        dialog.setTitle("Receive Message :" + msg);
        //dialog.setMessage(msg);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        AlertDialog alert = dialog.create();
        alert.show();
    }
}
