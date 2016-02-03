package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.mx;

final class CustomEventAdapter$a
        implements CustomEventBannerListener {
    private final CustomEventAdapter q;
    private final MediationBannerListener r;

    public CustomEventAdapter$a(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener) {
        this.q = paramCustomEventAdapter;
        this.r = paramMediationBannerListener;
    }

    public void onClick() {
        mx.a("Custom event adapter called onFailedToReceiveAd.");
        this.r.onClick(this.q);
    }

    public void onDismissScreen() {
        mx.a("Custom event adapter called onFailedToReceiveAd.");
        this.r.onDismissScreen(this.q);
    }

    public void onFailedToReceiveAd() {
        mx.a("Custom event adapter called onFailedToReceiveAd.");
        this.r.onFailedToReceiveAd(this.q, AdRequest.ErrorCode.NO_FILL);
    }

    public void onLeaveApplication() {
        mx.a("Custom event adapter called onFailedToReceiveAd.");
        this.r.onLeaveApplication(this.q);
    }

    public void onPresentScreen() {
        mx.a("Custom event adapter called onFailedToReceiveAd.");
        this.r.onPresentScreen(this.q);
    }

    public void onReceivedAd(View paramView) {
        mx.a("Custom event adapter called onReceivedAd.");
        CustomEventAdapter.a(this.q, paramView);
        this.r.onReceivedAd(this.q);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventAdapter$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */