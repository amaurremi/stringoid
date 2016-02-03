package com.inmobi.re.container.mraidimpl;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.inmobi.commons.internal.Log;

class MRAIDInterstitialController$b
        implements View.OnKeyListener {
    MRAIDInterstitialController$b(MRAIDInterstitialController paramMRAIDInterstitialController) {
    }

    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (4 == paramKeyEvent.getKeyCode()) {
            bool1 = bool2;
            if (paramKeyEvent.getAction() == 0) {
                Log.debug("[InMobi]-[RE]-4.5.1", "Back Button pressed while Interstitial ad is in active state ");
                this.a.handleInterstitialClose();
                bool1 = bool2;
                if (MRAIDInterstitialController.b(this.a) > 0L) {
                    bool1 = true;
                }
            }
        }
        return bool1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/re/container/mraidimpl/MRAIDInterstitialController$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */