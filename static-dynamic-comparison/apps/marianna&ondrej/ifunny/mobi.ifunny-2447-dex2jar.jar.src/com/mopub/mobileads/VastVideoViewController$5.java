package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.VideoView;

class VastVideoViewController$5
        implements MediaPlayer.OnPreparedListener {
    VastVideoViewController$5(VastVideoViewController paramVastVideoViewController) {
    }

    public void onPrepared(MediaPlayer paramMediaPlayer) {
        if (VastVideoViewController.access$400(this.this$0).getDuration() < 16000) {
            VastVideoViewController.access$1002(this.this$0, VastVideoViewController.access$400(this.this$0).getDuration());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoViewController$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */