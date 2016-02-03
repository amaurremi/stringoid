package com.millennialmedia.android;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

import java.lang.ref.WeakReference;

class MMWebView$BannerGestureListener
        extends GestureDetector.SimpleOnGestureListener {
    WeakReference<MMWebView> a;

    public MMWebView$BannerGestureListener(MMWebView paramMMWebView) {
        this.a = new WeakReference(paramMMWebView);
    }

    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
        paramMotionEvent = (MMWebView) this.a.get();
        if (paramMotionEvent != null) {
            paramMotionEvent = paramMotionEvent.g();
            if (paramMotionEvent != null) {
                MMSDK.Event.a(paramMotionEvent.h);
            }
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView$BannerGestureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */