package com.leafmi.mi.androiddemo.utils;

import android.content.res.Resources;

/**
 * Created by Admin on 2016/8/29.
 */
public class Utils {
    private static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;

    public static int dp2Px(int dp) {
        return Math.round(dp * DENSITY);
    }

    public static int px2Dp(int px) {
        return Math.round(px / DENSITY);
    }
}
