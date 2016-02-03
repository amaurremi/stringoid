package com.inmobi.re.container.mraidimpl;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.controller.util.AVPlayer;

class MRAIDAudioVideoController$f
        implements View.OnKeyListener {
    MRAIDAudioVideoController$f(MRAIDAudioVideoController paramMRAIDAudioVideoController) {
    }

    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
        if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0)) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Back button pressed while fullscreen audio was playing");
            this.a.audioplayer.releasePlayer(true);
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDAudioVideoController$f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */