package com.everimaging.fotorsdk.utils;

import android.graphics.Point;
import android.view.View;

public class UIUtils {
    public static float dip2px(float paramFloat) {
        return DeviceUtils.getDensity() * paramFloat / 160.0F;
    }

    public static final Point getViewLocationOnScreen(View paramView) {
        int[] arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        return new Point(arrayOfInt[0], arrayOfInt[1]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/UIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */