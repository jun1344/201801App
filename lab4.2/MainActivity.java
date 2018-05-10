package org.androidtown.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {

    //버튼 및 레이아웃 변수를 선언합니다.
    Button openButton;
    Button closeButton;
    FrameLayout frameLayout1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //변수와 xml에 해당하는 것으로 변수를 대입 합니다.
        frameLayout1 = findViewById(R.id.slidingArea);
        openButton = findViewById(R.id.openButton);
        closeButton = findViewById(R.id.closeButton);

        //openButton의 버튼이벤트 입니다.
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //애니메이션 하기 전에 보이게 합니다.
                frameLayout1.setVisibility(View.VISIBLE);
                //애니메이션을 선언합니다.
                Animation right = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.left_slide);
                frameLayout1.startAnimation(right);


            }
        });

        //closeButton의 버튼이벤트 입니다.
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //애니메이션을 선언합니다.
                    Animation right = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.right_slide);
                    frameLayout1.startAnimation(right);
                //레이아웃을 가립니다.
                frameLayout1.setVisibility(View.INVISIBLE);
            }
        });
    }

}

