package com.example.administrator.memory_challenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button)findViewById(R.id.bt);
        TextView des = (TextView)findViewById(R.id.description);
        TextView score = (TextView)findViewById(R.id.tv1);
        Button[] bt = new Button[16];
        Character[] str = {'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H'};
        for(int i = 0; i < 16; i++)
            for(int j = 0; j < 16; j++)
            {
                if(Math.floor(Math.random() * 2 + 1) == 1){
                    Character c = str[i];
                    str[i] = str[j];
                    str[j] = c;
                }
            }

        start.setOnClickListener();
    }
}
