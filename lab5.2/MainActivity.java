package org.androidtown.hello;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    //레이아웃 변수를 선언합니다.
    EditText input;
    TextView textView1;
    TextView textView2;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //레이아웃 변수들을 매칭시킵니다.
        input = findViewById(R.id.inputEdit);
        button = findViewById(R.id.button1);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        //동작변경 버튼이벤트입니다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new factoTask().execute();

            }
        });
    }

    //펙토리알 AsyncTask를 선언합니다.
    private class factoTask extends AsyncTask<Void, Integer, Void> {

        //결과 값변수로 초기값은 1로 정의합니다.
        int result = 1;
        //EditText에 입력된 값을 변수로 받습니다.
        int max;
        @Override
        protected void onPreExecute() {
            max = Integer.valueOf(input.getText().toString());
            textView1.setText("");
        }

        //facto이 실행할 함수입니다.
        @Override
        protected Void doInBackground(Void... params) {
            for (int i = max; i > 0; i--) {
                try {
                    //onProgressUpdate()를 부릅니다.
                    publishProgress(i);
                    //0.5초 쉬게 만급니다.
                    Thread.sleep(500);
                    
                    result = result * i;

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        //진행 상황을 나타냅니다.
        @Override
        protected void onProgressUpdate(Integer... values) {
            textView1.append(" " + values[0]);
        }

        //결과 값을 표현합니다.
        @Override
        protected void onPostExecute(Void aVoid) {
            textView2.setText(" = " + String.valueOf(result));
        }
    }
}

