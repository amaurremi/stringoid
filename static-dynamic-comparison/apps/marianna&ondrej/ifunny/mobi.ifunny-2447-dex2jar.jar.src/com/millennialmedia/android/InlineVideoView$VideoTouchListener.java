package com.millennialmedia.android;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import java.lang.ref.WeakReference;

class InlineVideoView$VideoTouchListener
        implements View.OnTouchListener {
    private WeakReference<InlineVideoView> a;

    public InlineVideoView$VideoTouchListener(InlineVideoView paramInlineVideoView) {
        this.a = new WeakReference(paramInlineVideoView);
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        InlineVideoView localInlineVideoView = (InlineVideoView) this.a.get();
        if (localInlineVideoView != null) {
            return localInlineVideoView.a(paramView, paramMotionEvent);
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InlineVideoView$VideoTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */