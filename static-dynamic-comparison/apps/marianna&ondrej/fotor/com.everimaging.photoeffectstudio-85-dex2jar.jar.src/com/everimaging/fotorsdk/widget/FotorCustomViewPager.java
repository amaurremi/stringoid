package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class FotorCustomViewPager
        extends ViewPager {
    private boolean a;

    public FotorCustomViewPager(Context paramContext) {
        super(paramContext);
    }

    public FotorCustomViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        if (this.a) {
            return super.onInterceptTouchEvent(paramMotionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.a) {
            return super.onTouchEvent(paramMotionEvent);
        }
        return false;
    }

    public void setPagingEnable(boolean paramBoolean) {
        this.a = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorCustomViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */