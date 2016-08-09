package com.example.administrator.lobster_game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InstructionsActivity extends AppCompatActivity {
    private ImageView ivYou;
    private ImageView ivMe;
    private ImageView ivLobster;
    private ImageView ivShit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        ivYou = (ImageView)findViewById(R.id.you);
        ivMe = (ImageView)findViewById(R.id.me);
        ivLobster = (ImageView)findViewById(R.id.lobster);
        ivShit = (ImageView)findViewById(R.id.shit);

        ivYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(InstructionsActivity.this, DialogActivity.class);
                intent.putExtra(Main2Activity.MSG, "對手");
                startActivity(intent);
            }
        });
        ivMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(InstructionsActivity.this, DialogActivity.class);
                intent.putExtra(Main2Activity.MSG, "自己");
                startActivity(intent);
            }
        });
        ivLobster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(InstructionsActivity.this, DialogActivity.class);
                intent.putExtra(Main2Activity.MSG, "龍蝦");
                startActivity(intent);
            }
        });
        ivShit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(InstructionsActivity.this, DialogActivity.class);
                intent.putExtra(Main2Activity.MSG, "大便");
                startActivity(intent);
            }
        });
    }
}
