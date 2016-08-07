package com.lrhehe.common.util;


import timber.log.Timber;
import timber.log.Timber.DebugTree;

/**
 * @author lirui
 * @date 15/4/29.
 */
public class L {

    private L() {}

    public static void init(boolean debug) {
        if (debug) {
            Timber.plant(new DebugTree());
        }
    }

    public static void v(String msg, Object... args) {
        Timber.v(msg, args);
    }

    public static void w(String msg, Object... args) {
        Timber.w(msg, args);
    }

    public static void d(String msg, Object... args) {
        Timber.d(msg, args);
    }

    public static void i(String msg, Object... args) {
        Timber.i(msg, args);
    }

    public static void e(String msg, Object... args) {
        Timber.e(msg, args);
    }

    public static void e(Throwable e, String msg, Object... args) {
        Timber.e(e, msg, args);
    }
}