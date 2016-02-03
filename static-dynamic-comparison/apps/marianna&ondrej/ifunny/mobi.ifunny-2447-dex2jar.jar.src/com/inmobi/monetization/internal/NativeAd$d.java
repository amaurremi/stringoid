package com.inmobi.monetization.internal;

import android.util.Log;
import android.view.ViewGroup;

class NativeAd$d
        implements Runnable {
    NativeAd$d(NativeAd paramNativeAd, ViewGroup paramViewGroup, String paramString1, String paramString2) {
    }

    public void run() {
        try {
            this.d.a = new g(this.a.getContext(), this.b, this.c);
            this.a.addView(this.d.a);
            return;
        } catch (Exception localException) {
            Log.e("[InMobi]-[Monetization]", "Failed to attach the view");
            NativeAd.a(this.d, NativeAd.a.e);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/monetization/internal/NativeAd$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */