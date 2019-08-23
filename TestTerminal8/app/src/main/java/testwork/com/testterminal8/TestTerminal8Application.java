package testwork.com.testterminal8;

import android.app.Application;

import testwork.com.testterminal8.manager.Contextor;

public class TestTerminal8Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
