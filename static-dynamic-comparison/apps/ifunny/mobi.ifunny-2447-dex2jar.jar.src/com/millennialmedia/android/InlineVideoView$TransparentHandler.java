package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

class InlineVideoView$TransparentHandler
        extends Handler {
    private WeakReference<InlineVideoView> a;

    public InlineVideoView$TransparentHandler(InlineVideoView paramInlineVideoView) {
        this.a = new WeakReference(paramInlineVideoView);
    }

    public void handleMessage(Message paramMessage) {
        InlineVideoView localInlineVideoView = (InlineVideoView) this.a.get();
        if (localInlineVideoView != null) {
            localInlineVideoView.a(paramMessage);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InlineVideoView$TransparentHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */