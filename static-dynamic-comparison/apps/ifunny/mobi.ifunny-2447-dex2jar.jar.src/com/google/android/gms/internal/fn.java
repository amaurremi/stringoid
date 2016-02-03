package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

@ii
final class fn
        extends RelativeLayout {
    private final md a;

    public fn(Context paramContext, String paramString) {
        super(paramContext);
        this.a = new md(paramContext, paramString);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        this.a.a(paramMotionEvent);
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */