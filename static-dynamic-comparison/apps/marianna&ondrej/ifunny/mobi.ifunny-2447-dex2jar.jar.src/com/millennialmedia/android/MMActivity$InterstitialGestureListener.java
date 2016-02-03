package com.millennialmedia.android;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

import java.lang.ref.WeakReference;

class MMActivity$InterstitialGestureListener
        extends GestureDetector.SimpleOnGestureListener {
    WeakReference<MMActivity> a;

    public MMActivity$InterstitialGestureListener(MMActivity paramMMActivity) {
        this.a = new WeakReference(paramMMActivity);
    }

    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
        paramMotionEvent = (MMActivity) this.a.get();
        if (paramMotionEvent != null) {
            MMSDK.Event.a(MMAdImplController.a(paramMotionEvent.a));
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMActivity$InterstitialGestureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */