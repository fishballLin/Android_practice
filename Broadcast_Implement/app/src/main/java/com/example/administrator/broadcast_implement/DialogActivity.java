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
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.KEY_MSG);

        AlertDialog alert = new AlertDialog.Builder(DialogActivity.this)
        .setTitle("Receive Message :" + msg)
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        })
        .create();

        alert.show();
    }
}
