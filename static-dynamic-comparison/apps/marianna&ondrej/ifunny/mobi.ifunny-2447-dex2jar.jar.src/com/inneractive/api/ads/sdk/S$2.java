package com.inneractive.api.ads.sdk;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

final class S$2
        implements MediaPlayer.OnErrorListener {
    S$2(S paramS, k.a parama) {
    }

    public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
        if (this.a != null) {
            this.a.onVideoError(false);
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/S$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */