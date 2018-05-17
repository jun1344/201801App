package org.androidtown.hello;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.*;

import java.util.ArrayList;
import java.util.logging.LogRecord;


public class MainActivity extends AppCompatActivity {

    //레이아웃 변수를 선언합니다.
    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //레이아웃 변수들을 매칭시킵니다.
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        editText = findViewById(R.id.editText1);
        button = findViewById(R.id.button);

        //동작변경 버튼이벤트입니다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //index 0을 가지고 있는 dog1 쓰래드와
                //index 1을 가지고 있는 dog2 쓰래드를 선언하고 실행합니다.
                DogThread dog1= new DogThread(0);
                dog1.start();
                DogThread dog2 = new DogThread(1);
                dog2.start();
            }
        });
    }

    //DogThread를 선언합니다.
    class DogThread extends Thread{

        int dogIndex; //dog를 구별하는 index를 선언합니다.
        int stateIndex; //그림을 구별하는 index를 선언합니다.

        //이미지를 저장해두는 ArrayList를 선언합니다.
        ArrayList<Integer> image = new ArrayList<Integer>();


        public DogThread(int index){
            dogIndex = index;
            image.add(R.drawable.lion1);
            image.add(R.drawable.lion2);
            image.add(R.drawable.lion3);
        }

        public void run(){
            stateIndex = 0;
            for(int i = 0 ; i<9; i++){
                final String msg = "dog #" + dogIndex + " state: " + stateIndex;

                //handler를 통해서 ImageView에 접근합니다.
                handler.post(new Runnable(){
                    public void run() {
                        editText.append(msg + "\n");
                        //랜덤으로 image변수를 전환합니다.
                        stateIndex =(int)(Math.random() * 3);

                        //index들을 이용해서 각각에 맞는 View와 image를 설정합니다.
                        if (dogIndex == 0) {
                            imageView1.setImageResource(image.get(stateIndex));
                        } else if (dogIndex == 1){
                            imageView2.setImageResource(image.get(stateIndex));
                        }
                    }});
                try{
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime);
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }

        }

        //랜덤으로 쉬게 하는 변수입니다.
        public int getRandomTime(int min, int max){
            return min+(int)(Math.random() * (max-min));
        }
    }

}
