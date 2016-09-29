package com.leafmi.mi.androiddemo.activity;

import android.content.Context;
import android.content.Intent;

import com.leafmi.mi.androiddemo.activity.flash.FlashActivity;
import com.leafmi.mi.androiddemo.activity.network.NetWorkActivity;
import com.leafmi.mi.androiddemo.activity.network.OkHttpActivity;
import com.leafmi.mi.androiddemo.activity.other.CurveChartActivity;
import com.leafmi.mi.androiddemo.activity.other.OtherActivity;

/**
 * Created by Admin on 2016/8/29.
 */
public class ActivityBuilder {


    /**
     * other Activity
     * @param context
     */
    public static void toOtherActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, OtherActivity.class);
        context.startActivity(intent);
    }

    /**
     * 曲线图页面
     * @param context
     */
    public static void toCurveChartActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, CurveChartActivity.class);
        context.startActivity(intent);
    }

    /**
     * Flash页面
     * @param context
     */
    public static void toFlashActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, FlashActivity.class);
        context.startActivity(intent);
    }

    /**
     * NetWork页面
     * @param context
     */
    public static void toNetWorkActivity(Context context){
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, NetWorkActivity.class);
        context.startActivity(intent);
    }

    /**
     * OkHttp页面
     * @param context
     */
    public static void toOkHttpActivity(Context context){
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, OkHttpActivity.class);
        context.startActivity(intent);
    }
}
