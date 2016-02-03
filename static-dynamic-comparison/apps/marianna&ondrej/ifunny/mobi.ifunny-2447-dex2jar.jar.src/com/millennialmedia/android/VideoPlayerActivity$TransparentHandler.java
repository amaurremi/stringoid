package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

class VideoPlayerActivity$TransparentHandler
        extends Handler {
    private WeakReference<VideoPlayerActivity> a;

    public VideoPlayerActivity$TransparentHandler(VideoPlayerActivity paramVideoPlayerActivity) {
        this.a = new WeakReference(paramVideoPlayerActivity);
    }

    public void handleMessage(Message paramMessage) {
        VideoPlayerActivity localVideoPlayerActivity = (VideoPlayerActivity) this.a.get();
        if (localVideoPlayerActivity != null) {
            localVideoPlayerActivity.a(paramMessage);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoPlayerActivity$TransparentHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */