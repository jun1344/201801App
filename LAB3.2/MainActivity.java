package org.androidtown.hello;

import android.app.SearchManager;
import android.content.*;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import android.util.*;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    //변수 선언
    Button nextBtn;
    LinearLayout container;
    EditText editText;
    RadioButton radioButton1;
    RadioButton radioButton2;
    CheckBox checkBox1;
    CheckBox checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //editText
        editText = findViewById(R.id.editText);
        //라디오 버튼 
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        //체크박스
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        
        //버튼과 버튼이벤트
        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent를 이용해서 다른 activity에 값을 보내줍니다.
                Intent intent = new Intent(getApplicationContext(), activity_new.class);
                //수신은 어떤걸로 할지를 보내줍니다.
                String sendText = "";
                if (checkBox1.isChecked() && checkBox2.isChecked()) {
                    sendText = "SMS, E-mail";
                } else if (checkBox1.isChecked()) {
                    sendText = "SMS";
                } else if (checkBox2.isChecked()) {
                    sendText = "E-mail";
                }
                //성별을 저장한 변수입니다.
                String sexText = "";
                if (radioButton1.isChecked()) {
                    sexText = "남";
                } else if (radioButton2.isChecked()) {
                    sexText = "여";
                }
                //번들의 형태로 만들어서 각각 키를 'name', 'sex', 'send' 로 저장합니다.
                Bundle bundle = new Bundle();
                bundle.putString("name", editText.getText().toString());
                bundle.putString("sex", sexText);
                bundle.putString("send", sendText);
                //엑티비티를 저장합니다.
                intent.putExtras(bundle);
                //intent를 불러옵니다.
                startActivity(intent);
            }
        });


    }
    
}
