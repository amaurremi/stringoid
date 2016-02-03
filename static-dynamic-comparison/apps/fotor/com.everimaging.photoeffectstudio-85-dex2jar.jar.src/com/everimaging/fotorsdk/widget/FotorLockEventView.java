package com.everimaging.fotorsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class FotorLockEventView
        extends FrameLayout {
    private int a;

    public FotorLockEventView(Context paramContext) {
        super(paramContext);
    }

    public FotorLockEventView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public int getCounter() {
        try {
            int i = this.a;
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (getCounter() > 0) {
            return true;
        }
        return super.onTouchEvent(paramMotionEvent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorLockEventView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */