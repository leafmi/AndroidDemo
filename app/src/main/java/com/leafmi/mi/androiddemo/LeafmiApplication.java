package com.leafmi.mi.androiddemo;

import android.app.Application;

/**
 * Created by Admin on 2016/9/28.
 */
public class LeafmiApplication extends Application {

    public static LeafmiApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }


    public static LeafmiApplication getInstance() {
        return mInstance;
    }
}
