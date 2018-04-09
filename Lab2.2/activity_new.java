package org.androidtown.hello;

import android.app.Service;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.widget.*;
import android.view.View;
import android.net.*;

public class activity_new extends AppCompatActivity {

    String userUrl;
    TextView urltextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        //��ư�� �����Ѵ�.
        Button button1 = findViewById(R.id.backButton);

        //Intent �� ���� �ҷ��´�.
        Intent mainIntent=getIntent();
        //�����̸��� ������ ���� �����ϰ� Toast�� �̿��ؼ� ����Ѵ�.
        userUrl = mainIntent.getStringExtra("UserUrl");
        //�ؽ�Ʈ �並 �����ϰ� �� ���� �־��ݴϴ�.
        urltextView = findViewById(R.id.urltextView);
        urltextView.setText(userUrl);
    }

    public void backButtonEvent(View view){
        //back��ư�� ���ư��� toast���� ����մϴ�.
        Toast.makeText(getApplication(), "���ư����ư�� �������ϴ�.", Toast.LENGTH_LONG).show();
        //activity_new�� �Ϸ��ϰ� ���� main���� ���ư���.
        finish();
    }

    public void goButtonEvent(View view){
        if(userUrl.length() >= 1) {
            //�Էµ� Url �ּ� text�� http:// �� �ٿ��� Ȩ������ ���� �մϴ�.
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + userUrl));
            startActivity(intent);
        }
        else{
            //���ڿ��� ���̰� 1�� �ƴϸ� �� �ƹ����ڵ� ������ �� toast�� ����մϴ�.
            Toast.makeText(getApplication(), "�ּҸ� �ٽ��Է����ֽʽÿ�", Toast.LENGTH_LONG).show();
        }
    }

}
