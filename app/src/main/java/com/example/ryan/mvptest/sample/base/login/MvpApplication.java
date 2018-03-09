package com.example.ryan.mvptest.sample.base.login;

import android.app.Application;
import android.content.Context;

/**
 * Created by ryan on 17-9-27.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class MvpApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }
}
