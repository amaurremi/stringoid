package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ViewSwitcher;

@ii
final class ti
        extends ViewSwitcher {
    private final md a;

    public ti(Context paramContext) {
        super(paramContext);
        this.a = new md(paramContext);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        this.a.a(paramMotionEvent);
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */