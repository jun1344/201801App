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
    public Button btn_frag1;
    public Button btn_frag2;
    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //�ʱⰪ�� �������ݴϴ�.
        init();
        //��ư �����ʸ� �����մϴ�.
        setListener();
    }

    public void setListener(){

        //�� ��ư�� �ش��ϴ� fragment�� �ҷ��ɴϴ�.
        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
            }
        });

        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
            }
        });
    }

    public void init(){
        //��ư ������ �����մϴ�
        btn_frag1 = findViewById(R.id.btn_frag1);
        btn_frag2 = findViewById(R.id.btn_frag2);
        //fragment�� ������ ���� �����ݴϴ�.
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
    }
}

