package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

import java.lang.ref.WeakReference;

class InlineVideoView$VideoPreparedListener
        implements MediaPlayer.OnPreparedListener {
    private WeakReference<InlineVideoView> a;

    public InlineVideoView$VideoPreparedListener(InlineVideoView paramInlineVideoView) {
        this.a = new WeakReference(paramInlineVideoView);
    }

    public void onPrepared(MediaPlayer paramMediaPlayer) {
        InlineVideoView localInlineVideoView = (InlineVideoView) this.a.get();
        if (localInlineVideoView != null) {
            localInlineVideoView.b(paramMediaPlayer);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InlineVideoView$VideoPreparedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */