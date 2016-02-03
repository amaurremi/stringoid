package com.inmobi.re.container.mraidimpl;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

class MRAIDInterstitialController$a
        implements Runnable {
    MRAIDInterstitialController$a(MRAIDInterstitialController paramMRAIDInterstitialController, RelativeLayout paramRelativeLayout, FrameLayout paramFrameLayout) {
    }

    public void run() {
        this.a.removeView(MRAIDInterstitialController.a(this.c));
        this.b.removeView(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDInterstitialController$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */