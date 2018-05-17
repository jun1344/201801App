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

    //���̾ƿ� ������ �����մϴ�.
    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //���̾ƿ� �������� ��Ī��ŵ�ϴ�.
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        editText = findViewById(R.id.editText1);
        button = findViewById(R.id.button);

        //���ۺ��� ��ư�̺�Ʈ�Դϴ�.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //index 0�� ������ �ִ� dog1 �������
                //index 1�� ������ �ִ� dog2 �����带 �����ϰ� �����մϴ�.
                DogThread dog1= new DogThread(0);
                dog1.start();
                DogThread dog2 = new DogThread(1);
                dog2.start();
            }
        });
    }

    //DogThread�� �����մϴ�.
    class DogThread extends Thread{

        int dogIndex; //dog�� �����ϴ� index�� �����մϴ�.
        int stateIndex; //�׸��� �����ϴ� index�� �����մϴ�.

        //�̹����� �����صδ� ArrayList�� �����մϴ�.
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

                //handler�� ���ؼ� ImageView�� �����մϴ�.
                handler.post(new Runnable(){
                    public void run() {
                        editText.append(msg + "\n");
                        //�������� image������ ��ȯ�մϴ�.
                        stateIndex =(int)(Math.random() * 3);

                        //index���� �̿��ؼ� ������ �´� View�� image�� �����մϴ�.
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

        //�������� ���� �ϴ� �����Դϴ�.
        public int getRandomTime(int min, int max){
            return min+(int)(Math.random() * (max-min));
        }
    }

}
