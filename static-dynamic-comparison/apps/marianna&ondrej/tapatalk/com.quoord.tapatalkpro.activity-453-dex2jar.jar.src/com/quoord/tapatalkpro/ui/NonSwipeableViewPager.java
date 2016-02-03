package com.quoord.tapatalkpro.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NonSwipeableViewPager
        extends ViewPager {
    private boolean swipe = true;

    public NonSwipeableViewPager(Context paramContext) {
        super(paramContext);
    }

    public NonSwipeableViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public boolean isSwipe() {
        return this.swipe;
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        try {
            if (this.swipe) {
                boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
                return bool;
            }
        } catch (Exception paramMotionEvent) {
        }
        return false;
    }

    public void setSwipe(boolean paramBoolean) {
        this.swipe = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/ui/NonSwipeableViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */