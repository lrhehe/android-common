package com.lrhehe.common;

import android.app.Application;

import com.lrhehe.common.util.L;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * @author lirui
 * @date 15/5/19.
 */
public class BaseApplication extends Application {

    private static BaseApplication application;

    public static void init(BaseApplication application, boolean debug) {
        BaseApplication.application = application;
        L.init(debug);
        JodaTimeAndroid.init(application);
    }

    public static BaseApplication getInstance() {
        if (application != null) {
            return application;
        } else {
            throw new RuntimeException("call BaseApplication.init() first");
        }
    }
}
