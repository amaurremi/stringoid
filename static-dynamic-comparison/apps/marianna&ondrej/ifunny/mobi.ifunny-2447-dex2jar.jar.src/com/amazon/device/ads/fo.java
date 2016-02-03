package com.amazon.device.ads;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class fo
        implements View.OnKeyListener {
    fo(fl paramfl) {
    }

    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
        if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0)) {
            this.a.j();
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */