package com.inmobi.re.container;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.inmobi.commons.internal.Log;

class c$f
        implements View.OnKeyListener {
    c$f(c paramc) {
    }

    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
        if ((4 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0)) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Back Button pressed when html5 video is playing");
            IMWebView.m(this.a.a);
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/c$f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */