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
    public Button btn_frag1;
    public Button btn_frag2;
    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //초기값을 설정해줍니다.
        init();
        //버튼 리스너를 설정합니다.
        setListener();
    }

    public void setListener(){

        //각 버튼에 해당하는 fragment를 불러옵니다.
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
        //버튼 변수를 선언합니다
        btn_frag1 = findViewById(R.id.btn_frag1);
        btn_frag2 = findViewById(R.id.btn_frag2);
        //fragment의 변수의 값을 정해줍니다.
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
    }
}

