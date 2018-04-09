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
        //��ư�� �����Ѵ�.
        Button button1 = findViewById(R.id.backButton);

        //Intent �� ���� �ҷ��´�.
        Intent mainIntent=getIntent();
        //�����̸��� ������ ���� �����ϰ� Toast�� �̿��ؼ� ����Ѵ�.
        String loginName = mainIntent.getStringExtra("loginName");
        String loginAge = mainIntent.getStringExtra("loginAge");

        Toast.makeText(getApplicationContext(), "Student info : " + loginName + ", " + loginAge,
                Toast.LENGTH_LONG).show();
    }

    public void backButtonEvent(View view){
        //activity_new�� �Ϸ��ϰ� ���� main���� ���ư���.
        finish();
    }
}
