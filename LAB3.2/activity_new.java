package org.androidtown.hello;

import android.app.Service;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.widget.*;
import android.view.View;

public class activity_new extends AppCompatActivity {

    //각각 위젯에 맞는 변수를 선언해줍니다.
    Button button1;
    TextView nameText;
    TextView sexText;
    TextView sendText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //변수들을 id와 매칭시켜줍니다.
        button1 = findViewById(R.id.backButton);
        nameText = findViewById(R.id.nameText);
        sexText = findViewById(R.id.sexText);
        sendText = findViewById(R.id.sendText);

        //intend를 가져옵니다.
        Intent mainIntent=getIntent();
        //각각이름과 나이의 값을 저장하고 Toast를 이용해서 출력한다.
        String name = mainIntent.getStringExtra("name");
        String sex = mainIntent.getStringExtra("sex");
        String send = mainIntent.getStringExtra("send");

        //각텍스트에 이름을 설정합니다.
        nameText.setText(name);
        sexText.setText(sex);
        sendText.setText(send);


    }

    public void backButtonEvent(View view){
        //activity_new를 완료하고 원래 main으로 돌아간다.
        finish();
    }
}
