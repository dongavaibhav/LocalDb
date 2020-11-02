package com.example.localdb;

import android.app.Application;

public class MyApplication extends Application {

    private static MyApplication app;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public static MyApplication app(){
        return app;
    }

    public AppComponent appComponent(){
        return appComponent;
    }
}
