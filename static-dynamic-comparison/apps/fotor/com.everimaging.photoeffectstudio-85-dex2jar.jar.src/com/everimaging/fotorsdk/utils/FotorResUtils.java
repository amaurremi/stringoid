package com.everimaging.fotorsdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

public class FotorResUtils {
    public static int getAnimId(Context paramContext, String paramString) {
        return getResourceId(paramContext, paramString, "anim");
    }

    public static int getArrayId(Context paramContext, String paramString) {
        return getResourceId(paramContext, paramString, "array");
    }

    public static int getAttrId(Context paramContext, String paramString) {
        return getResourceId(paramContext, paramString, "attr");
    }

    public static int getColorId(Context paramContext, String paramString) {
        return getResourceId(paramContext, paramString, "color");
    }

    public static int getDimensionId(Context paramContext, String paramString) {
        return getResourceId(paramContext, paramString, "dimen");
    }

    public static Drawable getDrawable(Context paramContext, String paramString) {
        int i = getDrawableId(paramContext, paramString);
        if (i != 0) {
            return paramContext.getResources().getDrawable(i);
        }
        return null;
    }

    public static int getDrawableId(Context paramContext, String paramString) {
        return getResourceId(paramContext, paramString, "drawable");
    }

    public static int getId(Context paramContext, String paramString) {
        return getResourceId(paramContext, paramString, "id");
    }

    public static int getLayoutId(Context paramContext, String paramString) {
        return getResourceId(paramContext, paramString, "layout");
    }

    public static int getMenuId(Context paramContext, String paramString) {
        return getResourceId(paramContext, paramString, "menu");
    }

    public static <T> T getResource(Context paramContext, String paramString1, String paramString2, Class<T> paramClass) {
        paramString2 = null;
        try {
            paramClass = Class.forName(paramContext.getPackageName() + ".R$" + paramString1).getFields();
            int j = paramClass.length;
            int i = 0;
            for (; ; ) {
                paramContext = paramString2;
                if (i < j) {
                    paramContext = paramClass[i];
                    if (paramContext.getName().equals(paramString1)) {
                        paramContext = paramContext.get(null);
                    }
                } else {
                    return paramContext;
                }
                i += 1;
            }
            return null;
        } catch (Throwable paramContext) {
        }
    }

    private static int getResourceId(Context paramContext, String paramString1, String paramString2) {
        return paramContext.getResources().getIdentifier(paramString1, paramString2, paramContext.getPackageName());
    }

    public static int getStringId(Context paramContext, String paramString) {
        return getResourceId(paramContext, paramString, "string");
    }

    public static int[] getStyleable(Context paramContext, String paramString) {
        return (int[]) getResource(paramContext, paramString, "styleable", int[].class);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/FotorResUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */