/*
 * *
 *  * Copyright 2012 fenbi.com. All rights reserved.
 *  * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.lrhehe.common.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanghb
 */
public class ToastUtil {

    private static final int length = 16;

    private static final int error = 0;

    private static final int info = 1;

    public static void toast(Context context, String text) {
        innerToast(context, text, info);
    }

    public static void toast(Context context, int resId) {
        toast(context, ResUtil.getString(resId));
    }

    public static void toast(Fragment fragment, String text) {
        if (fragment != null && fragment.getActivity() != null) {
            toast(fragment.getActivity(), text);
        }
    }

    public static void toast(Fragment fragment, int resId) {
        toast(fragment, ResUtil.getString(resId));
    }

    public static void error(Fragment fragment, String text) {
        innerToast(fragment, text, error);
    }

    public static void error(Fragment fragment, int resId) {
        error(fragment, ResUtil.getString(resId));
    }

    public static void error(Context context, String text) {
        innerToast(context, text, error);
    }

    public static void error(Context context, int resId) {
        error(context, ResUtil.getString(resId));
    }

    private static void innerToast(Fragment fragment, String text, int type) {
        if (fragment != null) {
            innerToast(fragment.getActivity(), text, type);
        }
    }

    private static void innerToast(Context context, String text, int type) {
        if (TextUtils.isEmpty(text) || context == null || isStringInShow(text)) {
            return;
        }
        try {
            // why npe ?
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            // switch (type) {
            // case info:
            // toast.getView().setBackgroundColor(
            // ResUtil.getColor(R.color.main_color));
            // break;
            // case error:
            // toast.getView().setBackgroundColor(
            // ResUtil.getColor(R.color.danger));
            // break;
            // }
            toast.show();
            toastHistory.put(text, System.currentTimeMillis());
        } catch (Exception e) {

        }
    }

    private static Map<String, Long> toastHistory = new HashMap<>();

    private static boolean isStringInShow(String text) {
        List<String> list = new ArrayList<>(toastHistory.keySet());
        for (String str : list) {
            long time = toastHistory.get(str);
            if (System.currentTimeMillis() - time > 4000) {
                toastHistory.remove(str);
            }
        }
        return toastHistory.containsKey(text);
    }
}
