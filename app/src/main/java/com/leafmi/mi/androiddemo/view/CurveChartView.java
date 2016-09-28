package com.leafmi.mi.androiddemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.bean.other.Point;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Admin on 2016/8/29.
 */
public class CurveChartView extends View {
    private int dataStartXDiff;
    private final int areaCount = 5;
    private int mWidth;
    private int mHeight;

    //每块区域大小
    private int areaSize;
    private float density;

    //画笔
    private Paint solidLinesPaint, effectsPaint, curveChartPaint, fillPaint, textPaint;

    // 曲线路径
    private Path curvePath;
    private Paint pointPaint;
    private Point[] mPoints;

    private List<Long> listData;
    List<String> xShowText;
    private float linesWidth;
    private Point[] mXTextPoints;
    private Point[] xLinesPoints;
    private int monthDays;
    private float curveXDiffSize;
    private Context mContext;


    public CurveChartView(Context context) {
        super(context);
        init(context);
    }

    public CurveChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public void init(Context context) {
        this.mContext=context;
        WindowManager mManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mManager.getDefaultDisplay().getMetrics(displayMetrics);
        density = displayMetrics.density;
        xShowText = getXShowText();
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

        //曲线画笔
        curveChartPaint = new Paint();
        curveChartPaint.setColor(Color.parseColor("#C4F60B"));
        curveChartPaint.setAntiAlias(true);
        curveChartPaint.setStyle(Paint.Style.STROKE);
        curveChartPaint.setStrokeWidth(4);

        //点画笔
        pointPaint = new Paint();
        pointPaint.setAntiAlias(true);
        pointPaint.setStyle(Paint.Style.FILL);
        pointPaint.setColor(Color.parseColor("#ffc800"));

        //曲线填充画笔
        fillPaint = new Paint();
        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setColor(Color.parseColor("#15ffffff"));
        fillPaint.setAntiAlias(true);

        //文字画笔
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.parseColor("#ffffff"));
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(12 * density);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        calculateData();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawYCoordinateLine(canvas);
        drawCurveChart(canvas);

        pointPaint.setColor(Color.parseColor("#ffffff"));
        for (int i = 0; i < xShowText.size(); i++) {
            canvas.drawText(xShowText.get(i), mXTextPoints[i].x, mXTextPoints[i].y, textPaint);
            canvas.drawCircle(xLinesPoints[i].x, xLinesPoints[i].y, 1 * density, pointPaint);

        }

        pointPaint.setColor(Color.parseColor("#C4F60B"));
        if (null != mPoints && mPoints.length > 0) {
            canvas.drawCircle(mPoints[mPoints.length - 1].x, mPoints[mPoints.length - 1].y, 4 * density, pointPaint);
            canvas.drawCircle(mPoints[mPoints.length - 1].x, areaSize * (areaCount - 1), 2 * density, pointPaint);
        }
//
//        for (int i = 0; i < mPoints.length; i++) {
//            canvas.drawCircle(mPoints[i].x, mPoints[i].y, 2 * density, pointPaint);
//        }
    }


    private void calculateData() {
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

        dataStartXDiff = (int) (24 * density);
        //计算没块大小
        areaSize = mHeight / areaCount;

        linesWidth = mWidth - 48 * density;
        //曲线每个数据X坐标相差距离
        curveXDiffSize = linesWidth / monthDays;

        //计算x坐标文字坐标
        mXTextPoints = new Point[xShowText.size()];
        xLinesPoints = new Point[xShowText.size()];
        int yText = areaSize / 2 + areaSize * (areaCount - 1);
        int textDistance = (int) curveXDiffSize * 4;
        for (int i = 0; i < xShowText.size(); i++) {
            mXTextPoints[i] = new Point(dataStartXDiff + textDistance * i, yText);
            xLinesPoints[i] = new Point(dataStartXDiff + textDistance * i, areaSize * (areaCount - 1));
        }

        //计算曲线坐标
        calculatePoints(listData);
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

    private List<Float> calculatepoitX(int dayCount) {

        List<Float> pointX = new ArrayList<>();
        for (int i = 1; i < dayCount; i++) {
            pointX.add(dataStartXDiff + (i - 1) * curveXDiffSize);
        }
        return pointX;
    }


    private List<Float> calculatePointY(List<Long> listData) {
        List<Float> pointY = new ArrayList<>();
        if (listData.size() > 0) {
            Long aLong = listData.get(0);
            float heightByte = (float) ((areaSize * (areaCount - 2)) * 1.0 / aLong);

            for (int i = 1; i < listData.size(); i++) {
                float l = listData.get(i) * heightByte;
                float v = areaSize * (areaCount - 1) - l;
                pointY.add(v);
            }
        }

        for (int i = 0; i < pointY.size(); i++) {
            Log.e("Point", "calculatePointY: " + pointY.get(i) + "===========" + areaSize + "=======" + density);
        }
        return pointY;
    }

    /**
     * 计算曲线的所有点
     *
     * @return
     */
    private Point[] calculatePoints(List<Long> listData) {
        List<Float> pointX = calculatepoitX(listData.size());
        List<Float> pointY = calculatePointY(listData);
        if ((null != pointX || null != pointY) && pointX.size() == pointY.size()) {
            int size = pointX.size();
            mPoints = new Point[size];
            for (int i = 0; i < size; i++) {
                mPoints[i] = new Point(pointX.get(i), pointY.get(i));
            }

            return mPoints;
        }
        return null;
    }


    /**
     * 画曲线
     *
     * @param canvas
     */
    private void drawCurveChart(Canvas canvas) {
        Path curvePath = new Path();
        Path fillPath = new Path();
        if (null != mPoints && mPoints.length > 0) {
            buildPath3(curvePath, mPoints);
            buildPath3(fillPath, mPoints);


            fillPath.lineTo(mPoints[mPoints.length - 1].x, areaSize * 4 - 0);
            fillPath.lineTo(mPoints[0].x, areaSize * 4 - 0);
            fillPath.lineTo(mPoints[0].x, mPoints[0].y);
            fillPath.close();
            canvas.drawPath(curvePath, curveChartPaint);
            canvas.drawPath(fillPath, fillPaint);
//
//            canvas.save();
//            canvas.clipPath(fillPath);
////            Drawable drawable = mContext.getResources().getDrawable(mContext,R.drawable.fade_red);
//            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_red);
//            drawable.setBounds(0,0,mWidth,mHeight);
//            drawable.draw(canvas);
//            canvas.restore();
//            fillPath.rewind();
        }
    }

    /**
     * 二阶贝塞尔曲线 Path
     *
     * @param path
     * @param mPoints
     */
    private void buildPath(Path path, Point[] mPoints) {
        //Important!
        path.reset();

        path.moveTo(mPoints[0].x, mPoints[0].y);
        int pointSize = mPoints.length;

        for (int i = 0; i < mPoints.length - 1; i++) {
            float pointX = (mPoints[i].x + mPoints[i + 1].x) / 2;
            float pointY = (mPoints[i].y + mPoints[i + 1].y) / 2;

            float controlX = mPoints[i].x;
            float controlY = mPoints[i].y;

            path.quadTo(controlX, controlY, pointX, pointY);
        }
        path.quadTo(mPoints[pointSize - 1].x, mPoints[pointSize - 1].y, mPoints[pointSize - 1].x,
                mPoints[pointSize - 1].y);
    }


    /**
     * 三阶贝塞尔曲线 Path
     *
     * @param path
     * @param mPoints
     */
    private void buildPath2(Path path, Point[] mPoints) {
        //Important!
        path.reset();

        int pointSize = mPoints.length;
        Point startPoint;
        Point endPoint;
        for (int i = 0; i < pointSize - 1; i++) {
            startPoint = mPoints[i];
            endPoint = mPoints[i + 1];
            float centerX = (startPoint.x + endPoint.x) / 2;
            float centerY = (startPoint.y + endPoint.y) / 2;
            Point controlPoint1 = new Point();
            Point controlPoint2 = new Point();

            controlPoint1.y = centerY;
            controlPoint1.x = centerX;

            path.moveTo(startPoint.x, startPoint.y);
            path.quadTo(controlPoint1.x, controlPoint1.y,  endPoint.x, endPoint.y);
        }
        path.quadTo(mPoints[pointSize - 1].x, mPoints[pointSize - 1].y, mPoints[pointSize - 1].x,
                mPoints[pointSize - 1].y);
    }


    /**
     * 三阶贝塞尔曲线 Path
     *
     * @param path
     * @param mPoints
     */
    private void buildPath3(Path path, Point[] mPoints) {
        //Important!
        path.reset();

        int pointSize = mPoints.length;
        Point startPoint;
        Point endPoint;
        path.moveTo(mPoints[0].x, mPoints[0].y);
        for (int i = 0; i < pointSize - 1; i++) {
            startPoint = mPoints[i];
            endPoint = mPoints[i + 1];
            float centerX = (startPoint.x + endPoint.x) / 2;
            Point controlPoint1 = new Point();
            Point controlPoint2 = new Point();

            controlPoint1.y = startPoint.y;
            controlPoint1.x = centerX;

            controlPoint2.y = endPoint.y;
            controlPoint2.x = centerX;


            path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, endPoint.x, endPoint.y);
        }
        path.quadTo(mPoints[pointSize - 1].x, mPoints[pointSize - 1].y, mPoints[pointSize - 1].x,
                mPoints[pointSize - 1].y);
    }

    /**
     *
     */
    private List<String> getXShowText() {
        List<String> xText = new ArrayList<>();
        Calendar aCalendar = Calendar.getInstance();
        int month = aCalendar.get(Calendar.MONTH);
        monthDays = aCalendar.getActualMaximum(Calendar.DATE);
        Log.e("TAG_MONTH", month + "====" + monthDays);
        for (int i = 1; i < monthDays; i += 4) {
            if (i == 1) {
                xText.add(formatData(month, i));
            } else if (i + 4 > monthDays) {
                xText.add(formatData(month, i));
            } else {
                xText.add(String.valueOf(i));
            }
        }
        return xText;
    }


    private String formatData(int month, int day) {
        Calendar aCalendar = new GregorianCalendar();
        aCalendar.set(Calendar.MONTH, month);
        aCalendar.set(Calendar.DAY_OF_MONTH, day);

        SimpleDateFormat sdf = new SimpleDateFormat("M.d", Locale.getDefault());

        return sdf.format(aCalendar.getTimeInMillis());
    }

    public void setLitData(List<Long> litData) {
        this.listData = litData;
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        calculateData();
        invalidate();
    }

}
