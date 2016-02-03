package com.inmobi.re.container;

import android.view.ViewGroup;

import java.util.concurrent.atomic.AtomicBoolean;

class IMWebView$m
        implements Runnable {
    IMWebView$m(IMWebView paramIMWebView) {
    }

    public void run() {
        if (this.a.getParent() != null) {
            ((ViewGroup) this.a.getParent()).removeView(this.a);
        }
        this.a.b.set(true);
        IMWebView.p(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/IMWebView$m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */