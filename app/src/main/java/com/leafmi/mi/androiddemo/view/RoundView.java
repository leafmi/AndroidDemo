package com.leafmi.mi.androiddemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.leafmi.mi.androiddemo.R;

/**
 * Created by JLang on 2016/12/8.
 */

public class RoundView extends View {

    private int mWidth;
    private int mHeight;

    private Paint mPaint;
    private Path mPath;
    private int mBgColor;
    private float mRound;
    private float mTopLeftRound, mTopRightRound, mBottomLeftRound, mBottomRightRound;
    private RectF retcF, topLeftRetcF, bottomLeftRetcF, topRightRetcF, bottomRightRetcF;


    public RoundView(Context context) {
        super(context);
        initView();
    }

    public RoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray styled = context.obtainStyledAttributes(attrs, R.styleable.RoundView);
        mTopLeftRound = styled.getDimension(R.styleable.RoundView_topLeftRound, 0);
        mTopRightRound = styled.getDimension(R.styleable.RoundView_topRightRound, 0);
        mBottomLeftRound = styled.getDimension(R.styleable.RoundView_bottomLeftRound, 0);
        mBottomRightRound = styled.getDimension(R.styleable.RoundView_bottomRightRound, 0);
        mRound = styled.getDimension(R.styleable.RoundView_round, 0);
        mBgColor = styled.getColor(R.styleable.RoundView_backgroundColor, Color.WHITE);
        styled.recycle();

        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mBgColor);

        mPath = new Path();
    }


    public void setmBgColor(int mBgColor) {
        this.mBgColor = mBgColor;
    }

    public void setRound(float mRound) {
        this.mRound = mRound;
        roundRetcF();
        invalidate();
    }

    public void setTopLeftRound(float mTopLeftRound) {
        this.mTopLeftRound = mTopLeftRound;
        topLeftRetcF();
        invalidate();
    }

    public void setTopRightRound(float mTopRightRound) {
        this.mTopRightRound = mTopRightRound;
        topRightRetcF();
        invalidate();
    }

    public void setBottomLeftRound(float mBottomLeftRound) {
        this.mBottomLeftRound = mBottomLeftRound;
        bottomLeftRetcF();
        invalidate();
    }

    public void setBottomRightRound(float mBottomRightRound) {
        this.mBottomRightRound = mBottomRightRound;
        bottomRightRetcF();
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

        if (mRound != 0) {
            roundRetcF();
        } else {
            topLeftRetcF();
            topRightRetcF();
            bottomRightRetcF();
            bottomLeftRetcF();
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        if (mRound != 0) {
            canvas.drawRoundRect(retcF, mRound, mRound, mPaint);
        } else {
            mPath.reset();
            //左上
            if (topLeftRetcF != null) {
                canvas.drawArc(topLeftRetcF, 180, 90, true, mPaint);
                mPath.moveTo(0, mTopLeftRound);
                mPath.lineTo(mTopLeftRound, 0);
            } else {
                mPath.moveTo(0, 0);
            }

            //右上
            if (topRightRetcF != null) {
                canvas.drawArc(topRightRetcF, 270, 90, true, mPaint);

                mPath.lineTo(mWidth - mTopRightRound, 0);
                mPath.lineTo(mWidth, mTopRightRound);
            } else {
                mPath.lineTo(mWidth, 0);
            }

            //右下
            if (bottomRightRetcF != null) {
                canvas.drawArc(bottomRightRetcF, 0, 90, true, mPaint);

                mPath.lineTo(mWidth, mHeight - mBottomRightRound);
                mPath.lineTo(mWidth - mBottomRightRound, mHeight);
            } else {
                mPath.lineTo(mWidth, mHeight);
            }

            //左下
            if (bottomLeftRetcF != null) {
                canvas.drawArc(bottomLeftRetcF, 90, 90, true, mPaint);

                mPath.lineTo(mBottomLeftRound, mHeight);
                mPath.lineTo(0, mHeight - mBottomLeftRound);
            } else {
                mPath.lineTo(0, mHeight);
            }

            mPath.close();
            canvas.drawPath(mPath, mPaint);
        }
    }

    private void roundRetcF() {
        if (retcF == null) {
            retcF = new RectF(0, 0, mWidth, mHeight);
        } else {
            retcF.set(0, 0, mWidth, mHeight);
        }
    }

    private void topLeftRetcF() {
        if (mTopLeftRound != 0) {
            if (mTopLeftRound > mHeight / 2) {
                mTopLeftRound = mHeight / 2;
            }
            if (topLeftRetcF == null) {
                topLeftRetcF = new RectF(0, 0, mTopLeftRound * 2, mTopLeftRound * 2);
            } else {
                topLeftRetcF.set(0, 0, mTopLeftRound * 2, mTopLeftRound * 2);
            }
        }
    }

    private void topRightRetcF() {
        if (mTopRightRound != 0) {
            if (mTopRightRound > mHeight / 2) {
                mTopRightRound = mHeight / 2;
            }
            if (topRightRetcF == null) {
                topRightRetcF = new RectF(mWidth - mTopRightRound * 2, 0, mWidth, mTopRightRound * 2);
            } else {
                topRightRetcF.set(mWidth - mTopRightRound * 2, 0, mWidth, mTopRightRound * 2);
            }
        }
    }

    private void bottomLeftRetcF() {
        if (mBottomLeftRound != 0) {
            if (mBottomLeftRound > mHeight / 2) {
                mBottomLeftRound = mHeight / 2;
            }
            if (bottomLeftRetcF == null) {
                bottomLeftRetcF = new RectF(0, mHeight - mBottomLeftRound * 2, mBottomLeftRound * 2, mHeight);
            } else {
                bottomLeftRetcF.set(0, mHeight - mBottomLeftRound * 2, mBottomLeftRound * 2, mHeight);
            }
        }
    }

    private void bottomRightRetcF() {
        if (mBottomRightRound != 0) {
            if (mBottomRightRound > mHeight / 2) {
                mBottomRightRound = mHeight / 2;
            }
            if (bottomRightRetcF == null) {
                bottomRightRetcF = new RectF(mWidth - mBottomRightRound * 2, mHeight - mBottomRightRound * 2, mWidth, mHeight);
            } else {
                bottomRightRetcF.set(mWidth - mBottomRightRound * 2, mHeight - mBottomRightRound * 2, mWidth, mHeight);
            }
        }
    }
}
