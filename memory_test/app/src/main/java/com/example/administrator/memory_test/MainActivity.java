package com.example.administrator.memory_test;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private Button start ;
    private TextView des ;
    private TextView score ;
    private TextView[] bt = new TextView[16];

    private String[] str = {"A","A","B","B","C","C","D","D","E","E","F","F","G","G","H","H"};
    private int[] bt_id = {R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5, R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9, R.id.bt10, R.id.bt11, R.id.bt12, R.id.bt13, R.id.bt14, R.id.bt15, R.id.bt16 };
    private int nowTime, firstPress, secondPress, number, highScore;
    private boolean desc, gameStart;

    public final static String keyTime = "keyTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.bt);
        des = (TextView)findViewById(R.id.description);
        score = (TextView)findViewById(R.id.tv2);
        for(int i = 0; i < 16; i++)
            bt[i] = (TextView)findViewById(bt_id[i]);
        highScore = 6000;

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("XDD", "click");
                nowTime = 5;
                gameStart = true;
                desc = true;
                firstPress = 16;
                secondPress = 16;
                number = 0;
                randomString();
                for (int i = 0; i < 16; i++)
                    bt[i].setText(str[i]);
                des.setText(timeToString(nowTime / 60, nowTime % 60));
                start.setText("restart");
            }
        });

        Timer timerMain = new Timer();
        timerMain.schedule(task, 0, 1000);


        for (int i = 0; i < 16; i++)
        {
            bt[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("XDD","press");
                    TextView tmpTv = (TextView)findViewById(v.getId());
                    if(tmpTv.getText()!="") //翻開就不可以再按了
                        return;
                    if(secondPress == 16)
                    {
                        if(firstPress == 16)
                        {
                            int index = findIndexByid(v.getId());
                            firstPress = index;
                            bt[index].setText(str[index]);
                        }
                        else
                        {
                            int index = findIndexByid(v.getId());
                            secondPress = index;
                            bt[index].setText(str[index]);
                            if(str[firstPress] == str[index])
                            {
                                number = number + 1;
                                firstPress = 16;
                                secondPress = 16;
                                if(number == 8)
                                {
                                    if(nowTime < highScore) {
                                        highScore = nowTime;
                                        score.setText(timeToString(highScore / 60, highScore % 60));
                                    }
                                    gameStart = false;
                                    win();
                                }
                            }
                            else
                            {
                                android.os.Handler handlers = new android.os.Handler();
                                handlers.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                    bt[firstPress].setText("");
                                    bt[secondPress].setText("");
                                    firstPress = 16;
                                    secondPress = 16;
                                }}, 500);
                            }
                        }
                    }
                }
            });

        }
    }

    private int findIndexByid(int id){
        for(int i = 0; i < 16; i++)
            if(bt_id[i] == id)
                return i;
        return 0;
    }

    private void randomString() {
        for(int i = 0; i < 16; i++)
            for(int j = 0; j < 16; j++)
            {
                if(Math.floor(Math.random() * 2 + 1) == 1){
                    String c = str[i];
                    str[i] = str[j];
                    str[j] = c;
                }
            }
    }

    private String timeToString(int min, int sec){
        if(min >= 100)
            return "error";
        else
            return String.format("%02d:%02d",min, sec);
    }

    private android.os.Handler handler = new android.os.Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch(msg.what){
                case 1:
                    nowTime = nowTime - 1;
                    des.setText(timeToString(nowTime / 60, nowTime % 60));
                    if(nowTime == 0)
                    {
                        desc = false;
                        for(int i = 0; i < 16; i++)
                            bt[i].setText("");
                    }
                    break;
                case 2:
                    nowTime = nowTime + 1;
                    des.setText(timeToString(nowTime / 60, nowTime % 60));
                    break;
            }
        }
    };

    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Message message = new Message();
            if(gameStart) {
                if (desc) {
                    message.what = 1;
                    handler.sendMessage(message);
                } else {
                    message.what = 2;
                    handler.sendMessage(message);
                }
            }
        }
    };

    private void win()
    {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Winactivity.class);
        intent.putExtra(keyTime, timeToString(nowTime / 60, nowTime % 60));
        startActivity(intent);
    }
}
