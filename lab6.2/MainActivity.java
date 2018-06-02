package com.example.junsic.lab;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //layout 변수 설정
    EditText sn;
    EditText name;
    Button readBtn;
    Button clearBtn;
    Button saveBtn;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    //string 변수 설정
    private String userName;
    private String userSN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Edit Text 설정
        sn = findViewById(R.id.sn);
        name = findViewById(R.id.name);

        //Button 설정
        readBtn = findViewById(R.id.readBtn);
        clearBtn = findViewById(R.id.clearBtn);
        saveBtn  = findViewById(R.id.saveBtn);

        //saveBtn 설정
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=name.getText().toString();
                userSN=sn.getText().toString();
                sharedPreferences();
            }
        });

        //readBtn 클릭이벤트
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applySharedPreference();
            }
        });

        //clearBtn 클릭이벤트
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sn.setText("");
                name.setText("");
            }
        });


    }

    //파일 저장
    public void sharedPreferences(){
        sh_Pref=getSharedPreferences("Student",MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("StudentSN",userSN);
        toEdit.putString("StudentName",userName);
        toEdit.commit();
    }

    //저장한 파일 불러오기
    public  void applySharedPreference(){
        sh_Pref=getSharedPreferences("Student",MODE_PRIVATE);//Load shared preference
        if(sh_Pref!=null&&sh_Pref.contains("StudentName")){
            String nameString=sh_Pref.getString("StudentName","");
            String snString=sh_Pref.getString("StudentSN","");
            name.setText(nameString);
            sn.setText(snString);
        }
    }


}

