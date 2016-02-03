package com.emilsjolander.components.StickyScrollViewItems;

import android.view.MotionEvent;
import android.view.VelocityTracker;

public abstract interface f {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void a(VelocityTracker paramVelocityTracker, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, int paramInt);

    public abstract boolean a(MotionEvent paramMotionEvent);

    public abstract void b();

    public abstract VelocityTracker c();

    public abstract void d();

    public abstract int getActivePointerId();

    public abstract void getLocationOnScreen(int[] paramArrayOfInt);

    public abstract void setStickyMainContentScrollListener(g paramg);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/emilsjolander/components/StickyScrollViewItems/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */