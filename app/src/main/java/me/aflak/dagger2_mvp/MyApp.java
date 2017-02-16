package me.aflak.dagger2_mvp;

import android.app.Application;

/**
 * Created by Omar on 16/02/2017.
 */

public class MyApp extends Application {
    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static MyApp app(){
        return app;
    }
}
