package org.androidtown.hello;

import android.app.Service;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.widget.*;
import android.view.View;

public class activity_new extends AppCompatActivity {

    //���� ������ �´� ������ �������ݴϴ�.
    Button button1;
    TextView nameText;
    TextView sexText;
    TextView sendText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //�������� id�� ��Ī�����ݴϴ�.
        button1 = findViewById(R.id.backButton);
        nameText = findViewById(R.id.nameText);
        sexText = findViewById(R.id.sexText);
        sendText = findViewById(R.id.sendText);

        //intend�� �����ɴϴ�.
        Intent mainIntent=getIntent();
        //�����̸��� ������ ���� �����ϰ� Toast�� �̿��ؼ� ����Ѵ�.
        String name = mainIntent.getStringExtra("name");
        String sex = mainIntent.getStringExtra("sex");
        String send = mainIntent.getStringExtra("send");

        //���ؽ�Ʈ�� �̸��� �����մϴ�.
        nameText.setText(name);
        sexText.setText(sex);
        sendText.setText(send);


    }

    public void backButtonEvent(View view){
        //activity_new�� �Ϸ��ϰ� ���� main���� ���ư���.
        finish();
    }
}
