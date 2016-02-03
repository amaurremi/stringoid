package com.millennialmedia.android;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

import java.lang.ref.WeakReference;

class MMLayout$LayoutGestureListener
        extends GestureDetector.SimpleOnGestureListener {
    WeakReference<MMLayout> a;

    public MMLayout$LayoutGestureListener(MMLayout paramMMLayout) {
        this.a = new WeakReference(paramMMLayout);
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
        }
        while ((Math.abs((int) (paramMotionEvent2.getX() - paramMotionEvent1.getX())) <= 200) || (Math.abs(paramFloat1) <= Math.abs(paramFloat2))) {
            return false;
        }
        if (paramFloat1 > 0.0F) {
            if (MMSDK.a == 0) {
                MMLog.c("MMLayout", "Enabling debug and verbose logging.");
                MMSDK.a = 3;
            }
        }
        for (; ; ) {
            return true;
            MMLog.c("MMLayout", "Disabling debug and verbose logging.");
            MMSDK.a = 0;
            continue;
            paramMotionEvent1 = (MMLayout) this.a.get();
            if (paramMotionEvent1 != null) {
                MMSDK.a(paramMotionEvent1.h);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMLayout$LayoutGestureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */