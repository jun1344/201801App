package org.androidtown.hello;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    //���̾ƿ� ������ �����մϴ�.
    EditText input;
    TextView textView1;
    TextView textView2;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //���̾ƿ� �������� ��Ī��ŵ�ϴ�.
        input = findViewById(R.id.inputEdit);
        button = findViewById(R.id.button1);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        //���ۺ��� ��ư�̺�Ʈ�Դϴ�.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new factoTask().execute();

            }
        });
    }

    //���丮�� AsyncTask�� �����մϴ�.
    private class factoTask extends AsyncTask<Void, Integer, Void> {

        //��� �������� �ʱⰪ�� 1�� �����մϴ�.
        int result = 1;
        //EditText�� �Էµ� ���� ������ �޽��ϴ�.
        int max;
        @Override
        protected void onPreExecute() {
            max = Integer.valueOf(input.getText().toString());
            textView1.setText("");
        }

        //facto�� ������ �Լ��Դϴ�.
        @Override
        protected Void doInBackground(Void... params) {
            for (int i = max; i > 0; i--) {
                try {
                    //onProgressUpdate()�� �θ��ϴ�.
                    publishProgress(i);
                    //0.5�� ���� ���޴ϴ�.
                    Thread.sleep(500);
                    
                    result = result * i;

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        //���� ��Ȳ�� ��Ÿ���ϴ�.
        @Override
        protected void onProgressUpdate(Integer... values) {
            textView1.append(" " + values[0]);
        }

        //��� ���� ǥ���մϴ�.
        @Override
        protected void onPostExecute(Void aVoid) {
            textView2.setText(" = " + String.valueOf(result));
        }
    }
}

