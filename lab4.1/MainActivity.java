package org.androidtown.hello;

import android.content.*;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;


public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //lap41 을 선언하고 setContentView를 통해서 view를 설정합니다.
        lap41 vw = new lap41(this);
        setContentView(vw);
    }

    protected class lap41 extends View{

        //마우스 포인트를 저장하는 변수 입니다.
        private float pointX;
        private float pointY;

        //캔버스에 그릴 Paint와 path의 변수를 선언합니다.
        private Paint paint = new Paint();
        private Path path = new Path();

        public lap41(Context context){
            super(context);
        }
        public lap41(Context context, double x, double y){
            super(context);
        }

        //터치 이벤트 함수입니다
        // Point X와 Y의 변수를 저장하고
        // event.getAction을 통해서 이벤트를 불러옵니다.
        @Override
        public  boolean onTouchEvent(MotionEvent event){

            pointX = event.getX();
            pointY = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(pointX, pointY);
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(pointX, pointY);
                    break;
                default:
                    return false;
            }
            invalidate();
            return true;

        }

        //Path와 Paint변수를 처리합니다.
        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            paint.setStrokeWidth(2);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, paint);
        }
    }
}
