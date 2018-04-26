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
            //버튼메뉴를 길게 나올때 컨텍스트가 되도록 설정합니다.
            registerForContextMenu(mBtn);
        }

        //길게 탭을 하면 컨텍스트 메뉴가 나오게 됩니다.
        public void onCreateContextMenu (ContextMenu menu, View v,
                                         ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menu
                    Info);
            menu.setHeaderTitle("Button Menu");
            //add ( groupiD , Itemid, order, title ) 로 구성되어 있다.
            menu.add(0,1,0,"Red");
            menu.add(0,2,0,"Green");
            menu.add(0,3,0,"Blue");
        }

        //컨택스트 매뉴를 선택했을때 나오는 결과 값에 따라 출력되게 합니다.
        public boolean onContextItemSelected (MenuItem item) {
            //menu에 선택된 itemid에 따라서 선택되게 합니다.
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

