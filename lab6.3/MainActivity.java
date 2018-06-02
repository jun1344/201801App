package com.example.junsic.lab;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    //������ �������ݴϴ�.
    ListView listView;
    Button addBtn;
    Button deleteBtn;
    EditText nameText;
    EditText numText;

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    String listItem[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.ListView1);
        addBtn = findViewById(R.id.addBtn1);
        deleteBtn = findViewById(R.id.deleteBtn1);
        nameText = findViewById(R.id.nameEditText);
        numText = findViewById(R.id.numEditText);

        helper = new MySQLiteOpenHelper(MainActivity.this,"student.db",null,1);

        //�߰� ��ư �̺�Ʈ�Դϴ�.
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameText.getText().toString().length() == 0 || numText.getText().toString().length() ==0){
                    Toast.makeText(MainActivity.this, "��� �׸��� �Է��� �ֽʽÿ�",Toast.LENGTH_LONG).show();
                }
                else {
                    insert (nameText.getText().toString(), numText.getText().toString());
                    invalidate();
                }
            }
        });

        //���� ��ư �̺�Ʈ �Դϴ�.
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameText.getText().toString().length() ==0){
                    Toast.makeText(MainActivity.this, "�̸��� �Է��� �ֽʽÿ�",Toast.LENGTH_LONG).show();
                }
                else {
                    delete (nameText.getText().toString());
                }
            }
        });

    }

    private void invalidate(){
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItem);
        listView.setAdapter(adapter);
    }

    public void insert(String name, String num) {

        db = helper.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put("name",name);
        values.put("studentNo",num);
        db.insert("student",null,values);

    }

    public void update (String name, int num) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("studentNo", num);
        db.update("student", values, "name=?", new String[]{name});
    }

    //DB�� �ش��ϴ� NAME�� ������ �����մϴ�.
    public void delete (String name) {
        db=helper.getWritableDatabase();
        db.delete("student","name=?",new String[]{name});

    }

    //
    public void select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null);

        listItem = new String[c.getCount()];
        int count = 0;
        while (c.moveToNext()) {
            listItem[count] = c.getString(c.getColumnIndex("name"))
            +  " " +  c.getString(c.getColumnIndex("studentNo"));
            count++;
        }
        c.close();
    }
}

