package com.millennialmedia.android;

class VideoPlayerActivity$1
        implements Runnable {
    VideoPlayerActivity$1(VideoPlayerActivity paramVideoPlayerActivity, String paramString) {
    }

    public void run() {
        if (this.a.equalsIgnoreCase("restartVideo")) {
            this.b.h();
        }
        while (!this.a.equalsIgnoreCase("endVideo")) {
            return;
        }
        this.b.l();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoPlayerActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */