package com.mopub.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class Dips {
    private static float a(Context paramContext) {
        return paramContext.getResources().getDisplayMetrics().density;
    }

    public static float asFloatPixels(float paramFloat, Context paramContext) {
        return TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
    }

    public static int asIntPixels(float paramFloat, Context paramContext) {
        return (int) (asFloatPixels(paramFloat, paramContext) + 0.5F);
    }

    public static float dipsToFloatPixels(float paramFloat, Context paramContext) {
        return a(paramContext) * paramFloat;
    }

    public static int dipsToIntPixels(float paramFloat, Context paramContext) {
        return (int) (dipsToFloatPixels(paramFloat, paramContext) + 0.5F);
    }

    public static float pixelsToFloatDips(float paramFloat, Context paramContext) {
        return paramFloat / a(paramContext);
    }

    public static int pixelsToIntDips(float paramFloat, Context paramContext) {
        return (int) (pixelsToFloatDips(paramFloat, paramContext) + 0.5F);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/Dips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */