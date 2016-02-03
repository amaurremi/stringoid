package com.amazon.device.ads;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

import java.util.concurrent.atomic.AtomicBoolean;

final class ap
        implements View.OnLayoutChangeListener {
    ap(al paramal, az paramaz) {
    }

    public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
        if (al.c(this.a).getAndSet(false)) {
            this.a.b();
            this.a.c(this.b);
            al.d(this.a).removeOnLayoutChangeListener(this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */