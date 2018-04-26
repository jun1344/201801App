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

        Button mBtn;
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mBtn = (Button)findViewById(R.id.button);
            //��ư�޴��� ��� ���ö� ���ؽ�Ʈ�� �ǵ��� �����մϴ�.
            registerForContextMenu(mBtn);
        }

        //��� ���� �ϸ� ���ؽ�Ʈ �޴��� ������ �˴ϴ�.
        public void onCreateContextMenu (ContextMenu menu, View v,
                                         ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menu
                    Info);
            menu.setHeaderTitle("Button Menu");
            //add ( groupiD , Itemid, order, title ) �� �����Ǿ� �ִ�.
            menu.add(0,1,0,"Red");
            menu.add(0,2,0,"Green");
            menu.add(0,3,0,"Blue");
        }

        //���ý�Ʈ �Ŵ��� ���������� ������ ��� ���� ���� ��µǰ� �մϴ�.
        public boolean onContextItemSelected (MenuItem item) {
            //menu�� ���õ� itemid�� ���� ���õǰ� �մϴ�.
            switch (item.getItemId()) {
                case 1:
                    mBtn.setTextColor(Color.RED);
                    return true;
                case 2:
                    mBtn.setTextColor(Color.GREEN);
                    return true;
                case 3:
                    mBtn.setTextColor(Color.BLUE);
                    return true;
            }
            return true;
        }}

