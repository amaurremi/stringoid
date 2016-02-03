package com.quoord.tools;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class QuoordViewPager
        extends ViewPager {
    public QuoordViewPager(Context paramContext) {
        super(paramContext);
    }

    public QuoordViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        try {
            boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
            return bool;
        } catch (Exception paramMotionEvent) {
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/QuoordViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */