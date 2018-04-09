package org.androidtown.hello;

import android.app.SearchManager;
import android.content.*;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.util.*;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //View를 activity_main로 선언합니다.
        Button button1 = findViewById(R.id.nextButton);

    }

    //addButton의 버튼이벤트를 정의합니다.
    public void eventButtonNext(View view){
        EditText urlText = findViewById(R.id.urlText);
        //택스트를 가져온다.
        String userUrl = urlText.getText().toString();
        //Intent로 값을 쉽게 넘겨준다.
        Intent intent = new Intent (getApplicationContext(), activity_new.class);
        intent.putExtra("UserUrl", userUrl);
        startActivity(intent);
    }


}
