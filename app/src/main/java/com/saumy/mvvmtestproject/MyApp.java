package com.saumy.mvvmtestproject;

import android.app.Application;

import com.saumy.mvvmtestproject.dagger.DaggerApplicationComponent;

/**
 * Created by saumy on 12/15/2018.
 */

public class MyApp extends Application {

    private static MyApp instance;

    public static MyApp getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public DaggerApplicationComponent getComponent(){
        DaggerApplicationComponent daggerApplicationComponent =
                (DaggerApplicationComponent) DaggerApplicationComponent.builder().build();

        return daggerApplicationComponent;
    }
}
