package org.androidtown.hello;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    //ImageView 에 대한 변수를 선언합니다.
    ImageView imageView1;
    ImageView imageView2;

    //어떤 그림이 나올지 판별하는 변수입니다.
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ImageView 변수에 대해서 각각 id를 매칭시켜줍니다.
        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView3);

    }

    //button의 클릭이벤트를 설정합니다.
    public void onButton1Clicked(View v){
        this.ChangeImage();
    }

    //imageIndex 가 0이면 2번그림을 출력하고 1번그림을 숨기고
    //그 반대면 1번그림을 보여주고 2번그림을 숨깁니다.
    private void ChangeImage(){

        if(imageIndex == 0){
            imageIndex = 1;
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        }
        else{
            imageIndex = 0;
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        }
    }



}
