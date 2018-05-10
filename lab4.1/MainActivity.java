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
        //lap41 �� �����ϰ� setContentView�� ���ؼ� view�� �����մϴ�.
        lap41 vw = new lap41(this);
        setContentView(vw);
    }

    protected class lap41 extends View{

        //���콺 ����Ʈ�� �����ϴ� ���� �Դϴ�.
        private float pointX;
        private float pointY;

        //ĵ������ �׸� Paint�� path�� ������ �����մϴ�.
        private Paint paint = new Paint();
        private Path path = new Path();

        public lap41(Context context){
            super(context);
        }
        public lap41(Context context, double x, double y){
            super(context);
        }

        //��ġ �̺�Ʈ �Լ��Դϴ�
        // Point X�� Y�� ������ �����ϰ�
        // event.getAction�� ���ؼ� �̺�Ʈ�� �ҷ��ɴϴ�.
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

        //Path�� Paint������ ó���մϴ�.
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
