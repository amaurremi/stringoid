package com.millennialmedia.android;

import java.lang.ref.WeakReference;

class InlineVideoView$DownloadRunnable
        implements Runnable {
    private WeakReference<InlineVideoView> a;

    public InlineVideoView$DownloadRunnable(InlineVideoView paramInlineVideoView) {
        this.a = new WeakReference(paramInlineVideoView);
    }

    public void run() {
        InlineVideoView localInlineVideoView = (InlineVideoView) this.a.get();
        if (localInlineVideoView != null) {
            localInlineVideoView.c();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InlineVideoView$DownloadRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */