package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

class InlineVideoView$VideoHandler
        extends Handler {
    private WeakReference<InlineVideoView> a;

    public InlineVideoView$VideoHandler(InlineVideoView paramInlineVideoView) {
        this.a = new WeakReference(paramInlineVideoView);
    }

    public void handleMessage(Message paramMessage) {
        switch (paramMessage.what) {
        }
        do {
            return;
            paramMessage = (InlineVideoView) this.a.get();
        } while (paramMessage == null);
        if (paramMessage.isPlaying()) {
            paramMessage.d();
        }
        paramMessage.a.sendMessageDelayed(Message.obtain(paramMessage.a, 2), 500L);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InlineVideoView$VideoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */