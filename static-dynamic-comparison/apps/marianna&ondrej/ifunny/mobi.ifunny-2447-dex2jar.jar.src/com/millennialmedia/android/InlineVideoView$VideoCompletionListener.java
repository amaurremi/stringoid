package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import java.lang.ref.WeakReference;

class InlineVideoView$VideoCompletionListener
        implements MediaPlayer.OnCompletionListener {
    private WeakReference<InlineVideoView> a;

    public InlineVideoView$VideoCompletionListener(InlineVideoView paramInlineVideoView) {
        this.a = new WeakReference(paramInlineVideoView);
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        InlineVideoView localInlineVideoView = (InlineVideoView) this.a.get();
        if (localInlineVideoView != null) {
            localInlineVideoView.a(paramMediaPlayer);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InlineVideoView$VideoCompletionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */