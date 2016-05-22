package com.example.administrator.broadcast_implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button bt_Toast;
    private Button bt_Dialog;
    private Button bt_Notification;
    private EditText et_Input;
    final static String KEY_MSG = "KEY_MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_Toast = (Button)findViewById(R.id.toast);
        bt_Dialog = (Button)findViewById(R.id.dialog);
        bt_Notification = (Button)findViewById(R.id.notification);
        et_Input = (EditText)findViewById(R.id.input);

        bt_Toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("fishballLin.Toast");
                intent.putExtra(KEY_MSG, et_Input.getText().toString());
                Log.i("XDD", "send");
                sendBroadcast(intent);
            }
        });

        bt_Dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("fishballLin.Dialog");
                intent.putExtra(KEY_MSG, et_Input.getText().toString());
                sendBroadcast(intent);
            }
        });

        bt_Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("fishballLin.Notification");
                intent.putExtra(KEY_MSG, et_Input.getText().toString());
                sendBroadcast(intent);
            }
        });
    }
}
