package com.inneractive.api.ads.sdk;

import android.os.Handler;
import android.os.Message;

final class h$1
        extends Handler {
    h$1(h paramh) {
    }

    public final void handleMessage(Message paramMessage) {
        switch (paramMessage.what) {
            default:
                return;
            case 1:
                InneractiveAdView.Log.v("Inneractive_verbose", "handleMessage: Starting fadeInAnimation");
                this.a.a(this.a.c);
                return;
        }
        InneractiveAdView.Log.v("Inneractive_verbose", "handleMessage: Starting fadeOutAnimation");
        this.a.a(this.a.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/h$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */