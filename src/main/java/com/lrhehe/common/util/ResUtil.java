/*
 * *
 *  * Copyright 2012 fenbi.com. All rights reserved.
 *  * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.lrhehe.common.util;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

import com.lrhehe.common.BaseApplication;

/**
 * @author wanghb
 */
public class ResUtil {

    public static String getString(int id) {
        return BaseApplication.getInstance().getResources().getString(id);
    }

    public static String getString(int id, Object... formatArgs) {
        return BaseApplication.getInstance().getString(id, formatArgs);
    }

    public static int getColor(int id) {
        return BaseApplication.getInstance().getResources().getColor(id);
    }

    public static Drawable getDrawable(int id) {
        return BaseApplication.getInstance().getResources().getDrawable(id);
    }

    public static int getDimenDp(int id) {
        return DimenUtils.px2dip(BaseApplication.getInstance().getResources().getDimension(id));
    }

    public static ColorStateList getColorStateList(int id) {
        return BaseApplication.getInstance().getResources().getColorStateList(id);
    }
}
