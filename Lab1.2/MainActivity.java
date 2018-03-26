package org.androidtown.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    // TextView와 EditText를 변수로 선언해줍니다.
    public TextView view_print;
    public EditText edit_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //View를 activity_main로 선언합니다.
        init(); //초기화를 해줍니다.

    }

    public void init(){
        //변수와 해당하는 id 값으로 넣어줍니다.
        edit_name = findViewById(R.id.editText);
        view_print = findViewById(R.id.textView2);
    }

    //clear버튼을 클릭했을때의 이벤트입니다.
    public void clearCilcked(View v){
        //모든 텍스트를 초기값으로 설정합니다.
        edit_name.setText("");
        view_print.setText("Context");
    }

    //print버튼을 클릭했을때의 이벤트입니다.
    public void printClicked(View v){
        //스트링 변수로 editname의 값을 가져옵니다.
        String text = "";
        text = edit_name.getText().toString();

        //값을 가져온뒤에 값을 초기화 합니다.
        edit_name.setText("");

        //내용을 print 해줍니다.
        view_print.setText(view_print.getText().toString() + "\n" +text);

    }




}
