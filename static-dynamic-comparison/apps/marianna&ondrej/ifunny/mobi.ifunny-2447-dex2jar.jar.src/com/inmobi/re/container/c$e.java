package com.inmobi.re.container;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.VideoView;
import com.inmobi.commons.internal.Log;

class c$e
        implements View.OnKeyListener {
    c$e(c paramc) {
    }

    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
        if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0)) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Back Button pressed when html5 video is playing");
            IMWebView.k(this.a.a).stopPlayback();
            IMWebView.m(this.a.a);
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/c$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */