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
        //버튼을 정의한다.
        Button button1 = findViewById(R.id.backButton);

        //Intent 의 값을 불러온다.
        Intent mainIntent=getIntent();
        //각각이름과 나이의 값을 저장하고 Toast를 이용해서 출력한다.
        userUrl = mainIntent.getStringExtra("UserUrl");
        //텍스트 뷰를 선언하고 그 값을 넣어줍니다.
        urltextView = findViewById(R.id.urltextView);
        urltextView.setText(userUrl);
    }

    public void backButtonEvent(View view){
        //back버튼에 돌아갈때 toast값을 출력합니다.
        Toast.makeText(getApplication(), "돌아가기버튼을 눌렀습니다.", Toast.LENGTH_LONG).show();
        //activity_new를 완료하고 원래 main으로 돌아간다.
        finish();
    }

    public void goButtonEvent(View view){
        if(userUrl.length() >= 1) {
            //입력된 Url 주소 text에 http:// 를 붙여서 홈페이지 열게 합니다.
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + userUrl));
            startActivity(intent);
        }
        else{
            //문자열의 길이가 1이 아니면 즉 아무문자도 없으면 이 toast를 출력합니다.
            Toast.makeText(getApplication(), "주소를 다시입력해주십시오", Toast.LENGTH_LONG).show();
        }
    }

}
