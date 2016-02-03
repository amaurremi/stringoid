package com.inneractive.api.ads.sdk;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View;

final class IAadReportGestureListener
        extends GestureDetector.SimpleOnGestureListener {
    private IAadReportGestureListener.GestureState a = IAadReportGestureListener.GestureState.a;
    private View b;
    private IAadConfig c;
    private c d;

    IAadReportGestureListener(View paramView, IAadConfig paramIAadConfig) {
        this.b = paramView;
        this.c = paramIAadConfig;
    }

    final void a() {
        b();
    }

    final void b() {
        InneractiveAdView.Log.v("Inneractive_verbose", "alert gesture reset");
        this.a = IAadReportGestureListener.GestureState.a;
    }

    final void c() {
        InneractiveAdView.Log.v("Inneractive_verbose", "alert gesture long press");
        this.a = IAadReportGestureListener.GestureState.b;
        this.a = IAadReportGestureListener.GestureState.c;
        if (this.a == IAadReportGestureListener.GestureState.c) {
            InneractiveAdView.Log.v("Inneractive_verbose", "sending ad report");
            this.d = new c(this.b.getContext(), this.b, this.c);
            this.d.a();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAadReportGestureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */