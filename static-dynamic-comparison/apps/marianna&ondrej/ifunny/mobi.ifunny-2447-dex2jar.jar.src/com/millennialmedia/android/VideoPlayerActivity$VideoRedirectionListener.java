package com.millennialmedia.android;

import android.net.Uri;

import java.lang.ref.WeakReference;

class VideoPlayerActivity$VideoRedirectionListener
        extends HttpRedirection.RedirectionListenerImpl {
    WeakReference<VideoPlayerActivity> f;

    public VideoPlayerActivity$VideoRedirectionListener(VideoPlayerActivity paramVideoPlayerActivity) {
        if (paramVideoPlayerActivity != null) {
            this.f = new WeakReference(paramVideoPlayerActivity);
            if (paramVideoPlayerActivity.c != null) {
                this.e = paramVideoPlayerActivity.c.a;
            }
        }
    }

    public OverlaySettings getOverlaySettings() {
        VideoPlayerActivity localVideoPlayerActivity = (VideoPlayerActivity) this.f.get();
        if ((localVideoPlayerActivity != null) && (localVideoPlayerActivity.i != null)) {
            OverlaySettings localOverlaySettings = new OverlaySettings();
            localOverlaySettings.c = localVideoPlayerActivity.i;
            return localOverlaySettings;
        }
        return null;
    }

    public boolean isHandlingMMVideo(Uri paramUri) {
        VideoPlayerActivity localVideoPlayerActivity = (VideoPlayerActivity) this.f.get();
        if (localVideoPlayerActivity != null) {
            localVideoPlayerActivity.runOnUiThread(new VideoPlayerActivity.VideoRedirectionListener .1
            (this, localVideoPlayerActivity));
            if ((paramUri != null) && (VideoPlayerActivity.a(localVideoPlayerActivity, paramUri))) {
                localVideoPlayerActivity.d(paramUri.getHost());
                return true;
            }
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoPlayerActivity$VideoRedirectionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */