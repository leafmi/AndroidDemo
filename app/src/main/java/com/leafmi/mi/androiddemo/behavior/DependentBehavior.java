package com.leafmi.mi.androiddemo.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by JLang on 2016/12/8.
 */

public class DependentBehavior extends CoordinatorLayout.Behavior<View> {

    private int initDisX = 0;


    public DependentBehavior() {
    }

    public DependentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setInitDisX(int initDisX) {
        this.initDisX = initDisX;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        //如果dependency的类型是View，则就可以被child依赖
        return dependency instanceof View;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
//        return super.onDependentViewChanged(parent, child, dependency);

        //当dependency发生移动时，计算出child应该偏移的距离，然后让child进行偏移
        int offsetX = (dependency.getLeft() - child.getLeft()) - initDisX;
        int offsetY = dependency.getTop() - child.getTop();
        child.offsetLeftAndRight(offsetX);
        child.offsetTopAndBottom(offsetY);
        return true;
    }
}
