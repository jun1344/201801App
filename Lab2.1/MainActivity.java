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
        //View�� activity_main�� �����մϴ�.
        Button button1 = findViewById(R.id.addButton);

    }

    //addButton�� ��ư�̺�Ʈ�� �����մϴ�.
    public void eventButtonAdd(View view){
        EditText nameText = findViewById(R.id.nameText);
        EditText ageText = findViewById(R.id.ageText);
        //�ý�Ʈ�� �����´�.
        String UserName = nameText.getText().toString();
        String UserAge = ageText.getText().toString();
        //Intent�� ���� ���� �Ѱ��ش�.
        Intent intent = new Intent (getApplicationContext(), activity_new.class);
        intent.putExtra("loginName", UserName);
        intent.putExtra("loginAge", UserAge);
        startActivity(intent);
    }


}
