package org.androidtown.hello;

import android.app.Service;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.widget.*;
import android.view.View;

public class activity_new extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        //버튼을 정의한다.
        Button button1 = findViewById(R.id.backButton);

        //Intent 의 값을 불러온다.
        Intent mainIntent=getIntent();
        //각각이름과 나이의 값을 저장하고 Toast를 이용해서 출력한다.
        String loginName = mainIntent.getStringExtra("loginName");
        String loginAge = mainIntent.getStringExtra("loginAge");

        Toast.makeText(getApplicationContext(), "Student info : " + loginName + ", " + loginAge,
                Toast.LENGTH_LONG).show();
    }

    public void backButtonEvent(View view){
        //activity_new를 완료하고 원래 main으로 돌아간다.
        finish();
    }
}
