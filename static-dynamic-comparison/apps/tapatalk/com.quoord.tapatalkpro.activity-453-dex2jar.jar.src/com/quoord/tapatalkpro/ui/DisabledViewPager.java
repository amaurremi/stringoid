package com.quoord.tapatalkpro.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DisabledViewPager
        extends ViewPager {
    public DisabledViewPager(Context paramContext) {
        super(paramContext);
    }

    public DisabledViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/DisabledViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */