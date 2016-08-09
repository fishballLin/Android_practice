package com.example.administrator.lobster_game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btInstructions;
    private Button btGameStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btInstructions = (Button)findViewById(R.id.instructions);
        btGameStart = (Button)findViewById(R.id.gameStart);

        btInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, InstructionsActivity.class);
                startActivity(intent);
            }
        });

        btGameStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
