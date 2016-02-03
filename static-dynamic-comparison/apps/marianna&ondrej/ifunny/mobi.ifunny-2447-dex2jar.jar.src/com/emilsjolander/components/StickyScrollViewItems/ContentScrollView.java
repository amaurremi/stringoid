package com.emilsjolander.components.StickyScrollViewItems;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;

public class ContentScrollView
        extends ScrollViewEx
        implements f {
    private g c;

    public ContentScrollView(Context paramContext) {
        super(paramContext);
    }

    public ContentScrollView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public ContentScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public void a() {
        scrollTo(0, 0);
    }

    public void a(int paramInt) {
        f(-paramInt);
    }

    public void a(VelocityTracker paramVelocityTracker, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, int paramInt) {
        b(paramVelocityTracker, paramMotionEvent1, paramMotionEvent2, paramInt);
    }

    protected void a(boolean paramBoolean) {
    }

    public boolean a(MotionEvent paramMotionEvent) {
        return onTouchEvent(paramMotionEvent);
    }

    public void b() {
        f();
    }

    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if (this.c != null) {
            if (this.a) {
                this.c.a(this, paramInt2, paramInt4, -1, -1);
            }
        } else {
            return;
        }
        this.c.a(this, paramInt2, paramInt4, -1, -1, getCurrentFlingVelocity());
    }

    public void setStickyMainContentScrollListener(g paramg) {
        this.c = paramg;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/emilsjolander/components/StickyScrollViewItems/ContentScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */