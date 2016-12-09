package com.leafmi.mi.androiddemo.activity;

import android.content.Context;
import android.content.Intent;

import com.leafmi.mi.androiddemo.activity.animation.AnimationActivity;
import com.leafmi.mi.androiddemo.activity.animation.DownLoadViewActivity;
import com.leafmi.mi.androiddemo.activity.view.RoundViewActivity;
import com.leafmi.mi.androiddemo.activity.view.ViewActivity;
import com.leafmi.mi.androiddemo.activity.network.NetWorkActivity;
import com.leafmi.mi.androiddemo.activity.network.OkHttpActivity;
import com.leafmi.mi.androiddemo.activity.network.RetorfitActivity;
import com.leafmi.mi.androiddemo.activity.other.CurveChartActivity;
import com.leafmi.mi.androiddemo.activity.other.OtherActivity;
import com.leafmi.mi.androiddemo.activity.other.RxJavaActivity;
import com.leafmi.mi.androiddemo.activity.supportlibrary.CoordinatorLayoutActivity;
import com.leafmi.mi.androiddemo.activity.supportlibrary.SupportLibraryActivity;

/**
 * Created by Admin on 2016/8/29.
 */
public class ActivityBuilder {


    /**
     * other Activity
     *
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
     *
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
     * View页面
     *
     * @param context
     */
    public static void toViewActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, ViewActivity.class);
        context.startActivity(intent);
    }

    /**
     * NetWork页面
     *
     * @param context
     */
    public static void toNetWorkActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, NetWorkActivity.class);
        context.startActivity(intent);
    }

    /**
     * OkHttp页面
     *
     * @param context
     */
    public static void toOkHttpActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, OkHttpActivity.class);
        context.startActivity(intent);
    }

    /**
     * Retorfit页面
     *
     * @param context
     */
    public static void toRetorfitActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, RetorfitActivity.class);
        context.startActivity(intent);
    }

    /**
     * RxJava页面
     *
     * @param context
     */
    public static void toRxJavaActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, RxJavaActivity.class);
        context.startActivity(intent);
    }

    /**
     * Animation页面
     *
     * @param context
     */
    public static void toAnimationActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, AnimationActivity.class);
        context.startActivity(intent);
    }

    /**
     * DownloadView页面
     *
     * @param context
     */
    public static void toDownloadViewActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, DownLoadViewActivity.class);
        context.startActivity(intent);
    }


    /**
     * SupportLibrary页面
     *
     * @param context
     */
    public static void toSupportLibraryActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, SupportLibraryActivity.class);
        context.startActivity(intent);
    }


    /**
     * SupportLibrary页面
     *
     * @param context
     */
    public static void toCoordinatorLayoutActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, CoordinatorLayoutActivity.class);
        context.startActivity(intent);
    }

    /**
     * RoundView页面
     *
     * @param context
     */
    public static void toRoundViewActivity(Context context) {
        if (context == null) {
            return;
        }

        Intent intent = new Intent(context, RoundViewActivity.class);
        context.startActivity(intent);
    }
}
