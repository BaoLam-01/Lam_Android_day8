package com.lampro.lam_android_day8;

import android.app.Application;

public class MyApplication extends Application {
    private  static MyApplication instancees;

    public static MyApplication getInstance() {
        return instancees;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instancees = this;
    }
}
