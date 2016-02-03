package com.millennialmedia.android;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.VideoView;

class VideoPlayerActivity$3
        implements View.OnClickListener {
    VideoPlayerActivity$3(VideoPlayerActivity paramVideoPlayerActivity) {
    }

    public void onClick(View paramView) {
        if (this.a.g != null) {
            if (this.a.g.isPlaying()) {
                this.a.n();
                this.a.l.setBackgroundResource(17301540);
            }
        } else {
            return;
        }
        if (this.a.f) {
            this.a.a(0);
        }
        for (; ; ) {
            this.a.l.setBackgroundResource(17301539);
            return;
            if ((this.a.p) && (!this.a.f)) {
                this.a.g();
            } else {
                this.a.a(this.a.e);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoPlayerActivity$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */