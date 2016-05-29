package com.example.administrator.activity_implement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetBgColor extends AppCompatActivity {

    Button btWhite;
    Button btBlue;
    Button btYellow;
    Button btGreen;

    final static String INTENT_COLOR = "INTENT_COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_bg_color);
        Intent intent = new Intent();

        btWhite = (Button)findViewById(R.id.white);
        btYellow = (Button)findViewById(R.id.yellow);
        btBlue = (Button)findViewById(R.id.blue);
        btGreen = (Button)findViewById(R.id.green);

        btWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(INTENT_COLOR, 1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(INTENT_COLOR, 2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(INTENT_COLOR, 3);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(INTENT_COLOR, 4);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
