package com.inmobi.re.container;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.FrameLayout;
import com.inmobi.commons.internal.Log;

class a
        implements MediaPlayer.OnCompletionListener {
    a(IMWebView paramIMWebView) {
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        try {
            paramMediaPlayer.stop();
            IMWebView.j(this.a).setVisibility(8);
            IMWebView.m(this.a);
            IMWebView.i(this.a).setContentView(IMWebView.o(this.a));
            return;
        } catch (Exception paramMediaPlayer) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Media Player onCompletion", paramMediaPlayer);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */