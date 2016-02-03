package com.mopub.mobileads;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.ImageButton;

class MraidVideoViewController$1
        implements MediaPlayer.OnCompletionListener {
    MraidVideoViewController$1(MraidVideoViewController paramMraidVideoViewController) {
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        MraidVideoViewController.access$000(this.this$0).setVisibility(0);
        this.this$0.videoCompleted(true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/MraidVideoViewController$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */