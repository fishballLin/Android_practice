package com.example.administrator.abgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView description;
    EditText input;
    Button button;
    TextView answer;
    TextView score_tv;
    int []ans = new int[4];
    int []guessArray = new int[4];
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        description = (TextView)findViewById(R.id.description);
        input = (EditText)findViewById(R.id.input);
        button = (Button)findViewById(R.id.button);
        answer = (TextView)findViewById(R.id.answer);
        score_tv = (TextView)findViewById(R.id.score);

        score = 0;
        generate();
        //description.setText(Integer.toString(ans[0])+Integer.toString(ans[1])+Integer.toString(ans[2])+Integer.toString(ans[3]));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                if(str.length() != 4)
                {
                    Toast.makeText(v.getContext(), "請輸入4個數字", Toast.LENGTH_LONG).show();
                    input.setText("");
                    answer.setText("");
                    return;
                }
                int guess = Integer.valueOf(str);
                for(int i = 3; i >= 0; i--){
                    guessArray[i] = guess % 10;
                    guess = guess / 10;
                }
                if(guessArray[0] == guessArray[1] || guessArray[0] == guessArray[2] || guessArray[0] == guessArray[3] || guessArray[1] == guessArray[2] || guessArray[1] == guessArray[3] || guessArray[2] == guessArray[3]) {
                    Toast.makeText(v.getContext(), "數字不可以重複", Toast.LENGTH_LONG).show();
                    input.setText("");
                    answer.setText("");
                    return;
                }
                String result;
                answer.setText(result = check());
                if(result == "Correct!!")
                {
                    score = score + 1;
                    generate();
                    score_tv.setText(Integer.toString(score));
                    Toast.makeText(v.getContext(), "遊戲重新開始", Toast.LENGTH_LONG).show();
                }
                input.setText("");
            }
        });
    }

    void generate()
    {
        for(int i = 0; i < 4; i++)
            ans[i] = (int)(Math.random()*10);
        if(ans[0] == ans[1] || ans[0] == ans[2] || ans[0] == ans[3] || ans[1] == ans[2] || ans[1] == ans[3] || ans[2] == ans[3])
            generate();
        return;
    }

    String check(){
        int a = 0, b = 0;
        for(int i = 0; i < 4; i++)
            if(guessArray[i] == ans[i])
                a++;
        for(int i = 0; i < 4; i++)
            for(int j = 0 ; j < 4; j++)
                if(i!= j && guessArray[i] == ans[j])
                    b++;
        if(a == 4)
            return "Correct!!";
        else
            return Integer.toString(a) + 'A' + Integer.toString(b) + 'B';
    }
}
