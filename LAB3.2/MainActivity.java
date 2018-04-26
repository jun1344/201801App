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

    //���� ����
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
        //���� ��ư 
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        //üũ�ڽ�
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        
        //��ư�� ��ư�̺�Ʈ
        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent�� �̿��ؼ� �ٸ� activity�� ���� �����ݴϴ�.
                Intent intent = new Intent(getApplicationContext(), activity_new.class);
                //������ ��ɷ� ������ �����ݴϴ�.
                String sendText = "";
                if (checkBox1.isChecked() && checkBox2.isChecked()) {
                    sendText = "SMS, E-mail";
                } else if (checkBox1.isChecked()) {
                    sendText = "SMS";
                } else if (checkBox2.isChecked()) {
                    sendText = "E-mail";
                }
                //������ ������ �����Դϴ�.
                String sexText = "";
                if (radioButton1.isChecked()) {
                    sexText = "��";
                } else if (radioButton2.isChecked()) {
                    sexText = "��";
                }
                //������ ���·� ���� ���� Ű�� 'name', 'sex', 'send' �� �����մϴ�.
                Bundle bundle = new Bundle();
                bundle.putString("name", editText.getText().toString());
                bundle.putString("sex", sexText);
                bundle.putString("send", sendText);
                //��Ƽ��Ƽ�� �����մϴ�.
                intent.putExtras(bundle);
                //intent�� �ҷ��ɴϴ�.
                startActivity(intent);
            }
        });


    }
    
}
