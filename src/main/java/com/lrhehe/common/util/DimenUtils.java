/*
 * *
 *  * Copyright 2012 fenbi.com. All rights reserved.
 *  * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.lrhehe.common.util;

import com.lrhehe.common.BaseApplication;

/**
 * @author wanghb
 */
public class DimenUtils {

    public static int dip2px(float dip) {
        return (int) (dip * BaseApplication.getInstance().getResources().getDisplayMetrics().density);
    }

    public static int getScreenWidth() {
        return BaseApplication.getInstance().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return BaseApplication.getInstance().getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(float pxValue) {
        final float scale = BaseApplication.getInstance().getResources().getDisplayMetrics()
                .density;
        return (int) (pxValue / scale + 0.5f);
    }

}
