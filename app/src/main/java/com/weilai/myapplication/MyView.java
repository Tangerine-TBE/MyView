package com.weilai.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * * DATE: 2022/9/28
 * * Author:tangerine
 * * Description:
 **/
public class MyView extends View {
    private Path path1;
    private Region re = new Region();

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private RectF rectF = new RectF();

    @Override
    protected void onDraw(Canvas canvas) {
        int leftTopX = 300;
        int leftTopY = 400;
        int rightBottomX = 500;
        int rightBottomY = 600;
        int leftBottomX = 300;
        int leftBottomY = 700;
        int rightTopX = 500;
        int rightTopY = 400;
        double angle = 90;
        double radians = Math.toRadians(angle);
        int centerX = (rightTopX - leftTopX) / 2 + leftTopX;
        int centerY = (rightBottomY - rightTopY) / 2 + rightTopY;
        Log.e("centerX,centerY", "" + centerX + "," + centerY);
        Path path = new Path();
        path.moveTo(leftTopX, leftTopY);
        path.lineTo(rightTopX, rightTopY);
        path.lineTo(rightBottomX, rightBottomY);
        path.lineTo(leftBottomX, leftBottomY);
        path.close();
        Paint paint1 = new Paint();
        Paint paint2 = new Paint();
        paint1.setColor(Color.RED);
        paint2.setColor(Color.GREEN);
        canvas.drawPath(path, paint1);
        //反算坐标
        float rorateLeftTopX = (float) (((leftTopX - centerX) * Math.cos(radians))
                - ((leftTopY - centerY) * Math.sin(radians)) + centerX);
        float rorateLeftTopY = (float) (((leftTopY - centerY) * Math.cos(radians))
                + ((leftTopX - centerX) * Math.sin(radians)) + centerY);
        float rorateRightTopX = (float) (((rightTopX - centerX) * Math.cos(radians))
                - ((rightTopY - centerY) * Math.sin(radians)) + centerX);
        float rorateRightTopY = (float) (((rightTopY - centerY) * Math.cos(radians))
                + ((rightTopX - centerX) * Math.sin(radians)) + centerY);
        float rorateRightBottomX = (float) (((rightBottomX - centerX) * Math.cos(radians))
                - ((rightBottomY - centerY) * Math.sin(radians)) + centerX);
        float rorateRightBottomY = (float) (((rightBottomY - centerY) * Math.cos(radians))
                + ((rightBottomX - centerX) * Math.sin(radians)) + centerY);
        float rorateLeftBottomX = (float) (((leftBottomX - centerX) * Math.cos(radians))
                - ((leftBottomY - centerY) * Math.sin(radians)) + centerX);
        float rorateLeftBottomY = (float) (((leftBottomY - centerY) * Math.cos(radians))
                + ((leftBottomX - centerX) * Math.sin(radians)) + centerY);
        path1 = new Path();
        path1.moveTo(rorateLeftTopX, rorateLeftTopY);
        path1.lineTo(rorateRightTopX, rorateRightTopY);
        path1.lineTo(rorateRightBottomX, rorateRightBottomY);
        path1.lineTo(rorateLeftBottomX, rorateLeftBottomY);
        path1.close();
        canvas.drawPath(path1, paint2);
//        RectF rect = new RectF(leftTopX,leftTopY,rightBottomX,rightBottomY);
//        Paint paint =new Paint();
//        paint.setColor(Color.BLACK);
//        canvas.drawRect(rect,paint);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            RectF rectF = new RectF();
            path1.computeBounds(rectF, true);
            re.setPath(path1, new Region((int) rectF.left,
                    (int) rectF.top,
                    (int) rectF.right,
                    (int) rectF.bottom));
            if (re.contains((int) event.getX(), (int) event.getY())
            ){
                Log.e("tag","true");
            }
        }

        return true;
    }
}
