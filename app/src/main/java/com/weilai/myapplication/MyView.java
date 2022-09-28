package com.weilai.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 ** DATE: 2022/9/28
 ** Author:tangerine
 ** Description:
 **/
public class MyView extends View {

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int leftTopX = 300;
        int leftTopY = 400;
        int rightBottomX = 500;
        int rightBottomY = 600;
        int leftBottomX = 300;
        int leftBottomY = 600;
        int rightTopX = 500;
        int rightTopY = 400;
        double angle = 90.0;
        double radians = Math.toRadians(angle);
        int centerX = (rightBottomX - leftTopX )/2 + leftTopX;
        int centerY = (rightTopY - rightBottomY) / 2 + rightTopY;
        Path path = new Path();
        path.moveTo(leftTopX,leftTopY);
        path.lineTo(rightTopX,rightTopY);
        path.lineTo(rightBottomX,rightBottomY);
        path.lineTo(leftBottomX,leftBottomY);
        path.close();
        Paint paint1 = new Paint();
        paint1.setColor(Color.RED);
        canvas.drawPath(path,paint1);
        //反算坐标
        float rorateLeftTopX = (float) ((leftTopX - centerX) * Math.cos(radians)
                        -(leftTopY - centerY) * Math.sin(radians) + centerX);
        float rorateLeftTopY = (float) ((leftTopY - centerY) * Math.cos(radians)
                        -(leftTopX - centerX) * Math.sin(radians) + centerY);
        float rorateRightTopX = (float) ((rightTopX-centerX) *Math.cos(radians)
                        -(rightTopY - centerY) * Math.sin(radians) + centerX);


//        RectF rect = new RectF(leftTopX,leftTopY,rightBottomX,rightBottomY);
//        Paint paint =new Paint();
//        paint.setColor(Color.BLACK);
//        canvas.drawRect(rect,paint);
        super.onDraw(canvas);
    }
}
