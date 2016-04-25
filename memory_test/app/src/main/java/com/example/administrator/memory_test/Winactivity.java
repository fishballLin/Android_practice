package com.example.administrator.memory_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Winactivity extends AppCompatActivity {

    private Button bt;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winactivity);

        Intent intent = getIntent();
        String nowTime = intent.getStringExtra(MainActivity.keyTime);

        tv = (TextView)findViewById(R.id.tv);
        tv.setText(nowTime);

        bt = (Button)findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
