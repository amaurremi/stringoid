package com.millennialmedia.android;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import java.lang.ref.WeakReference;

class MMWebView$WebTouchListener
        implements View.OnTouchListener {
    WeakReference<MMWebView> a;

    MMWebView$WebTouchListener(MMWebView paramMMWebView) {
        this.a = new WeakReference(paramMMWebView);
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        paramView = (MMWebView) this.a.get();
        boolean bool;
        if (paramMotionEvent.getAction() == 2) {
            bool = true;
        }
        while (paramView != null) {
            if ((bool) && (paramView.f())) {
                return true;
                bool = false;
            } else {
                return false;
            }
        }
        return bool;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMWebView$WebTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */