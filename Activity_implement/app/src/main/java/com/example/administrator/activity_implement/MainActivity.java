package com.example.administrator.activity_implement;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button btCall;
    Button btMail;
    Button btWeb;
    Button btMap;
    Button btBgColor;
    RelativeLayout backGround;

    final static int ACTIVITY_SET_BG_COLOR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCall = (Button)findViewById(R.id.call);
        btMail = (Button)findViewById(R.id.mail);
        btWeb = (Button)findViewById(R.id.web);
        btMap = (Button)findViewById(R.id.map);
        btBgColor = (Button)findViewById(R.id.bg_color);
        backGround = (RelativeLayout)findViewById(R.id.bg);
        //backGround.setBackgroundColor(Color.BLUE);
        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:0912345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("mailto:test@gmail.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(intent);
            }
        });

        btWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:24.000000, 121.000000");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btBgColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SetBgColor.class);
                startActivityForResult(intent, ACTIVITY_SET_BG_COLOR);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if(intent == null)
            return;
        if(requestCode == ACTIVITY_SET_BG_COLOR)
        {
            int color = intent.getIntExtra(SetBgColor.INTENT_COLOR, 0); // 0 is default value
            Log.i("XDDD", String.valueOf(color));
            switch (color)
            {
                case 2: backGround.setBackgroundColor(Color.YELLOW); break;
                case 3: backGround.setBackgroundColor(Color.BLUE); break;
                case 4: backGround.setBackgroundColor(Color.GREEN); break;
                default:backGround.setBackgroundColor(Color.WHITE); // 1 is white too.
            }
        }
    }

}
