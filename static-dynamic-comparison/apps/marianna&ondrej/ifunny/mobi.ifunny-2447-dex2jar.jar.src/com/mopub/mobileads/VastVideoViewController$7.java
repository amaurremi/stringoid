package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

class VastVideoViewController$7
        implements MediaPlayer.OnErrorListener {
    VastVideoViewController$7(VastVideoViewController paramVastVideoViewController) {
    }

    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        if (this.this$0.retryMediaPlayer(paramMediaPlayer, paramInt1, paramInt2)) {
            return true;
        }
        VastVideoViewController.access$1700(this.this$0);
        VastVideoViewController.access$1300(this.this$0);
        this.this$0.videoError(false);
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/VastVideoViewController$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */