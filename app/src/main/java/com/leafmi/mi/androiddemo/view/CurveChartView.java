package com.leafmi.mi.androiddemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Admin on 2016/8/29.
 */
public class CurveChartView extends View {

    private int areaCount = 5;
    private int mWidth;
    private int mHeight;

    //每块区域大小
    private int areaSize;
    private float density;

    //画笔
    private Paint solidLinesPaint;
    private Paint effectsPaint;

    public CurveChartView(Context context) {
        super(context);
        init(context);
    }

    public CurveChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public void init(Context context) {
        WindowManager mManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mManager.getDefaultDisplay().getMetrics(displayMetrics);
        density = displayMetrics.density;

        initPaint();
    }

    private void initPaint() {
        //实线画笔
        solidLinesPaint = new Paint();
        solidLinesPaint.setAntiAlias(true);
        solidLinesPaint.setStyle(Paint.Style.STROKE);
        solidLinesPaint.setColor(0xffd9d9d9);

        //虚线画笔
        effectsPaint = new Paint();
        effectsPaint.setAntiAlias(true);
        effectsPaint.setStyle(Paint.Style.STROKE);
        effectsPaint.setColor(0xffd9d9d9);
        PathEffect effects = new DashPathEffect(new float[]{3 * density, 3 * density}, 1);
        effectsPaint.setPathEffect(effects);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        calculateAreaSize();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawYCoordinateLine(canvas);
    }


    private void calculateAreaSize() {
        areaSize = mHeight / areaCount;
    }


    /**
     * 绘制Y坐标虚线和实线
     */
    private void drawYCoordinateLine(Canvas canvas) {
        if (canvas != null) {


            int linesCount = areaCount - 1;
            //第一条和最后一条线画实线，其他画虚线
            for (int i = 0; i < linesCount; i++) {
                if (i == 0 || i == linesCount - 1) {
                    canvas.drawPath(getLinesPath(i + 1), solidLinesPaint);
                } else {
                    canvas.drawPath(getLinesPath(i + 1), effectsPaint);
                }
            }
        }
    }

    private Path getLinesPath(int multiple) {
        //虚线和实线的路径
        Path linePath = new Path();
        linePath.moveTo(16 * density, areaSize * multiple);
        linePath.lineTo(mWidth - 16 * density, areaSize * multiple);
        return linePath;
    }
}
