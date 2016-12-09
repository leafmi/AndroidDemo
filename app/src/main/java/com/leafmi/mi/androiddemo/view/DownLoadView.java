package com.leafmi.mi.androiddemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by JLang on 2016/12/5.
 */

public class DownLoadView extends View {
    private Context mContext;
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private float density;
    private Path path;
    private float mLineShrinkPercent;
    private int mPathPercent;
    private int mRisePercent;

    private boolean isPathToCircle;
    private boolean isPathToLine;
    private boolean isStartAnimation;
    private Paint mPaintLine;
    private int mLinePercent;
    private int mCirclePercent;
    private boolean isRiseDone;
    private RectF rectF;

    public DownLoadView(Context context) {
        super(context);
        init(context);
    }

    public DownLoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {
        this.mContext = context;
        WindowManager mManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mManager.getDefaultDisplay().getMetrics(displayMetrics);
        density = displayMetrics.density;

        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#2EA4F2"));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6 * density);
        mPaint.setAntiAlias(true);


        mPaintLine = new Paint();
        mPaintLine.setColor(Color.WHITE);
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setStrokeWidth(6 * density);
        mPaintLine.setAntiAlias(true);


        rectF = new RectF(0, 0, mWidth, mHeight);
        path = new Path();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2 - density * 3, mPaint);

        //绘制静态箭头
        mPaint.setColor(Color.WHITE);
        if (!isPathToCircle)
            canvas.drawLine(mWidth / 2, mHeight / 4, mWidth / 2, mHeight * 0.75f, mPaint);
        if (!isPathToLine) {
            path.moveTo(mWidth / 4, mHeight * 0.5f);
            path.lineTo(mWidth / 2, mHeight * 0.75f);
            path.lineTo(mWidth * 0.75f, mHeight * 0.5f);
            canvas.drawPath(path, mPaintLine);
        }


        if (isStartAnimation) {
            mPaint.setColor(Color.WHITE);
            //如果小于95 就继续缩短。 95是微调值 和point大小相等
            if (mLineShrinkPercent < 95) {
                isPathToCircle = true;
                //线段逐渐缩短（终点为mWidth/2,mHeight/2）
                float tmp = (mWidth / 2 - mHeight / 4) * mLineShrinkPercent / 100;
                canvas.drawLine(mWidth / 2, mHeight / 4 + tmp, mWidth / 2, mHeight * 0.75f - tmp, mPaint);
                mLineShrinkPercent += 5;
            } else {
                if (mPathPercent < 100) {
                    isPathToLine = true;
                    path.reset();
                    path.moveTo(mWidth / 4, mHeight * 0.5f);
                    path.lineTo(mWidth / 2, mHeight * 0.75f - mPathPercent / 100f * 0.25f * mHeight);
                    path.lineTo(mWidth * 0.75f, mHeight * 0.5f);
                    canvas.drawPath(path, mPaintLine);
                    mPathPercent += 5;


                    //在变成直线的过程中这个点一直存在
                    canvas.drawCircle(mWidth / 2, mHeight / 2, 2.5f, mPaint);
                } else {
                    //画上升的点
                    if (mRisePercent < 100) {
                        //在点移动到圆弧上的时候 线是一直存在的
                        canvas.drawLine(mWidth / 4, mHeight * 0.5f, mWidth * 0.75f, mHeight * 0.5f, mPaint);
                        canvas.drawCircle(mWidth / 2, mHeight / 2 - mHeight / 2 * mRisePercent / 100 + 5, 2.5f, mPaint);
                        mRisePercent += 5;
                    } else {
                        canvas.drawPoint(mWidth / 2, 5, mPaint);

                        mPaint.setColor(Color.parseColor("#2EA4F2"));
                        canvas.drawCircle(mWidth / 2, mHeight / 2 - mHeight / 2 * mRisePercent / 100 + 5, 2.5f, mPaint);
                        //动态绘制圆形百分比
                        if (mCirclePercent < 100) {
                            canvas.drawArc(rectF, 270, -mCirclePercent / 100.0f * 360, false, mPaint);
                            mCirclePercent += 5;
                        } else {
                            //改变对勾形状
                            if (mLinePercent < 100 && !isRiseDone) {
                                path.reset();
                                path.moveTo(mWidth / 4, mHeight * 0.5f);
                                path.lineTo(mWidth / 2, mHeight * 0.5f + mLinePercent / 100f * mHeight * 0.25f);
                                path.lineTo(mWidth * 0.75f, mHeight * 0.5f - mLinePercent / 100f * mHeight * 0.3f);
                                canvas.drawPath(path, mPaint);
                                mLinePercent += 5;

                            } else {
                                isRiseDone = true;
                                path.reset();
                                path.moveTo(mWidth / 4, mHeight * 0.5f);
                                path.lineTo(mWidth / 2, mHeight * 0.5f + mLinePercent / 100f * mHeight * 0.25f);
                                path.lineTo(mWidth * 0.75f, mHeight * 0.5f - mLinePercent / 100f * mHeight * 0.3f);
                                canvas.drawPath(path, mPaint);
                            }
                        }

                    }
                }
            }
        }
        if (isStartAnimation && !isRiseDone)
            postInvalidateDelayed(10);
    }


    public void startAni() {
        isStartAnimation = true;
        postInvalidate();
    }

}
