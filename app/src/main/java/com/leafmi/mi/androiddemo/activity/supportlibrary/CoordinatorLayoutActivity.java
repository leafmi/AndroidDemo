package com.leafmi.mi.androiddemo.activity.supportlibrary;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.leafmi.mi.androiddemo.R;
import com.leafmi.mi.androiddemo.behavior.DependentBehavior;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    private View viewDependency;
    private View viewChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        initView();
    }


    private int mLastX;
    private int mLastY;
    private void initView(){
        viewDependency = findViewById(R.id.view_dependency);

        viewDependency.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        mLastX = x;
                        mLastY = y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 计算偏移量
                        int offsetX = x - mLastX;
                        int offsetY = y - mLastY;
                        viewDependency.offsetLeftAndRight(offsetX);
                        viewDependency.offsetTopAndBottom(offsetY);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }

                return true;
            }
        });

        viewChild = findViewById(R.id.view_child);
        viewChild.postDelayed(new Runnable() {
            @Override
            public void run() {
                CoordinatorLayout.LayoutParams layoutParams= (CoordinatorLayout.LayoutParams) viewChild.getLayoutParams();
                DependentBehavior  behavior =(DependentBehavior) layoutParams.getBehavior();
                behavior.setInitDisX(viewDependency.getLeft() - viewChild.getLeft());
            }
        },100);
    }
}

