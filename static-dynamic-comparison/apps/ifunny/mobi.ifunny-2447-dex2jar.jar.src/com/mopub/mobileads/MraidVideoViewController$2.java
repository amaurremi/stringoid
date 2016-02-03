package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.widget.ImageButton;

class MraidVideoViewController$2
        implements MediaPlayer.OnErrorListener {
    MraidVideoViewController$2(MraidVideoViewController paramMraidVideoViewController) {
    }

    public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        MraidVideoViewController.access$000(this.this$0).setVisibility(0);
        this.this$0.videoError(false);
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidVideoViewController$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */