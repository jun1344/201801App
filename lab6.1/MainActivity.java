package com.example.junsic.lab;


import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //������ �������ݴϴ�.
    EditText mainText;
    Button writeBtn;
    Button readBtn;
    Button clearBtn;
    Button finishBtn;
    char[] chars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = findViewById(R.id.txtData);
        //��ư ����
        writeBtn = findViewById(R.id.writeSDBtn);
        readBtn = findViewById(R.id.readSDBtn);
        clearBtn = findViewById(R.id.clearBtn);
        finishBtn = findViewById(R.id.finishBtn);
        
        //writeBtn ��ư�̺�Ʈ
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{File sdCard = Environment.getExternalStorageDirectory();
                    File directory = new File(sdCard.getAbsolutePath() + "");
                    directory.mkdirs();
                    File file = new File(directory, "mysdfile.txt");
                    FileOutputStream fOut = new FileOutputStream(file);
                    fOut.write(mainText.getText().toString().getBytes());
                    fOut.close();
                    Toast.makeText(getApplicationContext(), "Done writing SD 'mysdfile.txt'",Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //readBtn ��ư�̺�Ʈ
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{File sdCard = Environment.getExternalStorageDirectory();
                    File directory = new File(sdCard.getAbsolutePath() + "/MyFiles");
                    directory.mkdirs();
                    File file = new File(directory, "mysdfile.txt");
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fIn,"UTF-8");

                    isr.read(chars);
                    mainText.setText(Arrays.toString(chars));
                    fIn.close();
                    Toast.makeText(getApplicationContext(), "Done reading SD 'mysdfile.txt'",Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //clearBtn ��ư�̺�Ʈ
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText("");
            }
        });

        //finishBtn ��ư�̺�Ʈ
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}

