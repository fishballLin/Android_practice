package com.example.administrator.lobster_game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    private TextView tvEnemyScore;
    private TextView tvMyScore;
    //private MediaPlayer mpStart; /* = new MediaPlayer();*/
    //private MediaPlayer mpAgain; /* = new MediaPlayer();*/
    private ImageView ivEnemyPlay;
    private ImageView ivMyPlay;
    private ImageView ivYou;
    private ImageView ivMe;
    private ImageView ivLobster;
    private ImageView ivShit;
    private int myPlay;
    private int enemyPlay;
    private int winGames;
    private int loseGames;

    final static String MSG = "MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //mpStart = MediaPlayer.create(this, R.raw.all);
        //mpAgain = MediaPlayer.create(this, R.raw.go);
        //mpStart.start();
        /*try {
            //mpStart.prepare();

        }catch (IllegalArgumentException e) {
            Log.i("XDD", "error1");
            e.printStackTrace();
        } catch (IllegalStateException e) {
            Log.i("XDD", "error2");
            e.printStackTrace();
        } catch (IOException e) {
            Log.i("XDD", "error3");
            e.printStackTrace();
        }*/

        ivEnemyPlay = (ImageView)findViewById(R.id.enemyPlay);
        ivMyPlay = (ImageView)findViewById(R.id.myPlay);
        ivYou = (ImageView)findViewById(R.id.you);
        ivMe = (ImageView)findViewById(R.id.me);
        ivLobster = (ImageView)findViewById(R.id.lobster);
        ivShit = (ImageView)findViewById(R.id.shit);

        winGames = 0;
        loseGames = 0;

        gamePrepare();

        ivYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPlay = 1;
                ivMyPlay.setImageResource(R.drawable.you);
                play();
            }
        });
        ivMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPlay = 2;
                ivMyPlay.setImageResource(R.drawable.me);
                play();
            }
        });
        ivLobster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPlay = 3;
                ivMyPlay.setImageResource(R.drawable.lobster);
                play();
            }
        });
        ivShit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPlay = 4;
                ivMyPlay.setImageResource(R.drawable.shit);
                play();
            }
        });
    }

    private void gamePrepare(){
        myPlay = 0;
        enemyPlay = 0;
        ivMyPlay.setImageResource(R.drawable.white);
        ivEnemyPlay.setImageResource(R.drawable.white);
    }
    private void play(){

        ivEnemyPlay.setImageResource(enemy());
        if (myPlay == 0) lose();
        else {
            if ((myPlay == 1 && enemyPlay == 3) || (myPlay == 2 && enemyPlay == 4) || (myPlay == 3 && enemyPlay == 1) || (myPlay == 4 && enemyPlay == 2))
                lose();
            else if ((myPlay == 1 && enemyPlay == 4) || (myPlay == 2 && enemyPlay == 3) || (myPlay == 3 && enemyPlay == 2) || (myPlay == 4 && enemyPlay == 1))
                win();
            else tie();
        }
        /*try {
            Log.i("XDD", "1");
            mpStart.prepare();
            Log.i("XDD", "prepare");
            mpStart.start();
            } catch (IllegalArgumentException e) {
                Log.i("XDD", "error1");
                e.printStackTrace();
            } catch (IllegalStateException e) {
                Log.i("XDD", "error2");
                e.printStackTrace();
            } catch (IOException e) {
                Log.i("XDD", "error3");
                e.printStackTrace();
        }*/
        /*mpStart.start();
        ivEnemyPlay.setImageResource(enemy());
        mpStart.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mpStart.stop();
                if (myPlay == 0) lose();
                else {
                    if ((myPlay == 1 && enemyPlay == 3) || (myPlay == 2 && enemyPlay == 4) || (myPlay == 3 && enemyPlay == 1) || (myPlay == 4 && enemyPlay == 2))
                        lose();
                    else if ((myPlay == 1 && enemyPlay == 4) || (myPlay == 2 && enemyPlay == 3) || (myPlay == 3 && enemyPlay == 2) || (myPlay == 4 && enemyPlay == 1))
                        win();
                    else tie();
                }
            }
        });*/
    }

    private void again(){
        /*try {
            mpAgain.prepareAsync();
            mpAgain.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mpAgain.start();
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "播放失敗", Toast.LENGTH_SHORT).show();
        }*/
       /* mpAgain.start();
        ivEnemyPlay.setImageResource(enemy());
        mpAgain.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //mpAgain.stop();
                if (myPlay == 0) lose();
                else {
                    if ((myPlay == 1 && enemyPlay == 3) || (myPlay == 2 && enemyPlay == 4) || (myPlay == 3 && enemyPlay == 1) || (myPlay == 4 && enemyPlay == 2))
                        lose();
                    else if ((myPlay == 1 && enemyPlay == 4) || (myPlay == 2 && enemyPlay == 3) || (myPlay == 3 && enemyPlay == 2) || (myPlay == 4 && enemyPlay == 1))
                        win();
                    else tie();
                }
            }
        });*/
    }

    private void win(){
        winGames++;
        Intent intent = new Intent();
        intent.setClass(Main2Activity.this, DialogActivity.class);
        if(winGames == 3){
            intent.putExtra(MSG, "恭喜你打敗電腦了!!");
            startActivity(intent);
            finish();
        }
        else{
            intent.putExtra(MSG, "獲得一勝，繼續努力!");
            startActivity(intent);
            //gamePrepare();
        }

    }
    private void lose(){
        loseGames++;
        Intent intent = new Intent();
        intent.setClass(Main2Activity.this, DialogActivity.class);
        if(loseGames == 3){
            intent.putExtra(MSG, "抱歉你被打敗了!!");
            startActivity(intent);
            finish();
        }
        else {
            intent.putExtra(MSG, "這場輸了，繼續努力!");
            startActivity(intent);
            //gamePrepare();
        }

    }
    private void tie(){
        Intent intent = new Intent();
        intent.setClass(Main2Activity.this, DialogActivity.class);
        intent.putExtra(MSG, "平手，繼續努力!");
        startActivity(intent);
        //gamePrepare();
    }

    private int enemy(){
        switch(enemyPlay = (int)(Math.random() * 4 + 1)){
            case 1: return R.drawable.you;
            case 2: return R.drawable.me;
            case 3: return R.drawable.lobster;
            case 4: return R.drawable.shit;
            default: return 0;
        }
    }

    protected void onResume(){
        super.onResume();
        tvEnemyScore = (TextView)findViewById(R.id.enemyScore);
        tvMyScore = (TextView)findViewById(R.id.myScore);
        tvEnemyScore.setText(Integer.toString(loseGames));
        tvMyScore.setText(Integer.toString(winGames));
        gamePrepare();
    }
}
