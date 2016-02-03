package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

import java.lang.ref.WeakReference;

class InlineVideoView$VideoErrorListener
        implements MediaPlayer.OnErrorListener {
    private WeakReference<InlineVideoView> a;

    public InlineVideoView$VideoErrorListener(InlineVideoView paramInlineVideoView) {
        this.a = new WeakReference(paramInlineVideoView);
    }

    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        InlineVideoView localInlineVideoView = (InlineVideoView) this.a.get();
        if (localInlineVideoView != null) {
            localInlineVideoView.a(paramMediaPlayer, paramInt1, paramInt2);
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InlineVideoView$VideoErrorListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */