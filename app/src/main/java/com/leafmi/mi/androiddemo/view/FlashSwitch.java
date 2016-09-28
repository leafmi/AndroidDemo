package com.leafmi.mi.androiddemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Admin on 2016/9/6.
 */
public class FlashSwitch extends View {
    private float mWidth;
    private float mHeight;
    private float density;
    private Paint mPaint;
    private int mCenterX;
    private int mCenterY;
    private RectF mRectF;

    public FlashSwitch(Context context) {
        super(context);
        init(context);
    }

    public FlashSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

        mCenterX = (int) mWidth / 2;
        mCenterY = (int) mHeight / 2;

        mRectF = new RectF(mCenterX - mWidth / 3, mCenterY - mWidth / 3, mCenterX + mWidth / 3, mCenterY + mWidth / 3);
    }


    private void init(Context context) {
        WindowManager mManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mManager.getDefaultDisplay().getMetrics(displayMetrics);
        density = displayMetrics.density;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.parseColor("#7Fffffff"));
        canvas.drawCircle(mCenterX, mCenterY, mHeight / 2 - 4, mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#7Fffff00"));
        canvas.drawCircle(mCenterX, mCenterY, mHeight / 2 - 4 - 1, mPaint);

//        mPaint.setStrokeWidth(4 * density);
//        mPaint.setColor(0xffffff);
//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawArc(mRectF, 135, 270, false, mPaint);
    }
}
