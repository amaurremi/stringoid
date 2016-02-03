package com.quoord.newonboarding;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class FixedSpeedScroller
        extends Scroller {
    private int mDuration = 0;

    public FixedSpeedScroller(Context paramContext) {
        super(paramContext);
    }

    public FixedSpeedScroller(Context paramContext, Interpolator paramInterpolator) {
        super(paramContext, paramInterpolator);
    }

    public int getmDuration() {
        return this.mDuration;
    }

    public void setmDuration(int paramInt) {
        this.mDuration = paramInt;
    }

    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mDuration);
    }

    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mDuration);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/newonboarding/FixedSpeedScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */