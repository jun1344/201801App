package com.example.junsic.lab;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //layout ���� ����
    EditText sn;
    EditText name;
    Button readBtn;
    Button clearBtn;
    Button saveBtn;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    //string ���� ����
    private String userName;
    private String userSN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Edit Text ����
        sn = findViewById(R.id.sn);
        name = findViewById(R.id.name);

        //Button ����
        readBtn = findViewById(R.id.readBtn);
        clearBtn = findViewById(R.id.clearBtn);
        saveBtn  = findViewById(R.id.saveBtn);

        //saveBtn ����
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=name.getText().toString();
                userSN=sn.getText().toString();
                sharedPreferences();
            }
        });

        //readBtn Ŭ���̺�Ʈ
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applySharedPreference();
            }
        });

        //clearBtn Ŭ���̺�Ʈ
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sn.setText("");
                name.setText("");
            }
        });


    }

    //���� ����
    public void sharedPreferences(){
        sh_Pref=getSharedPreferences("Student",MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("StudentSN",userSN);
        toEdit.putString("StudentName",userName);
        toEdit.commit();
    }

    //������ ���� �ҷ�����
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

