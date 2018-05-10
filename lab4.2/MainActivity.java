package org.androidtown.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {

    //��ư �� ���̾ƿ� ������ �����մϴ�.
    Button openButton;
    Button closeButton;
    FrameLayout frameLayout1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //������ xml�� �ش��ϴ� ������ ������ ���� �մϴ�.
        frameLayout1 = findViewById(R.id.slidingArea);
        openButton = findViewById(R.id.openButton);
        closeButton = findViewById(R.id.closeButton);

        //openButton�� ��ư�̺�Ʈ �Դϴ�.
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //�ִϸ��̼� �ϱ� ���� ���̰� �մϴ�.
                frameLayout1.setVisibility(View.VISIBLE);
                //�ִϸ��̼��� �����մϴ�.
                Animation right = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.left_slide);
                frameLayout1.startAnimation(right);


            }
        });

        //closeButton�� ��ư�̺�Ʈ �Դϴ�.
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //�ִϸ��̼��� �����մϴ�.
                    Animation right = AnimationUtils.loadAnimation(
                            getApplicationContext(), R.anim.right_slide);
                    frameLayout1.startAnimation(right);
                //���̾ƿ��� �����ϴ�.
                frameLayout1.setVisibility(View.INVISIBLE);
            }
        });
    }

}

