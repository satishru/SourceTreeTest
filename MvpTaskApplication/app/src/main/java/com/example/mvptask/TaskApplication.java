package com.example.mvptask;

import android.app.Application;
import android.content.Context;

public class TaskApplication extends Application {

    private static Context context;

    public static Context getGlobalContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
