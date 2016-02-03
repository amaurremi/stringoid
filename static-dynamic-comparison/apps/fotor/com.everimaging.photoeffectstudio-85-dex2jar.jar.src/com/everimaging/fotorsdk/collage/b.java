package com.everimaging.fotorsdk.collage;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;

public class b {
    public static int a = 0;
    public static int b = 0;

    public static void a(Context paramContext) {
        paramContext = paramContext.getTheme().obtainStyledAttributes(R.styleable.Theme);
        a = paramContext.getColor(57, 7501182);
        b = paramContext.getColor(58, 49407);
        paramContext.recycle();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */