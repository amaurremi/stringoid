package com.google.ads.mediation.customevent;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.mx;

class CustomEventAdapter$b
        implements CustomEventInterstitialListener {
    private final CustomEventAdapter q;
    private final MediationInterstitialListener s;

    public CustomEventAdapter$b(CustomEventAdapter paramCustomEventAdapter1, CustomEventAdapter paramCustomEventAdapter2, MediationInterstitialListener paramMediationInterstitialListener) {
        this.q = paramCustomEventAdapter2;
        this.s = paramMediationInterstitialListener;
    }

    public void onDismissScreen() {
        mx.a("Custom event adapter called onDismissScreen.");
        this.s.onDismissScreen(this.q);
    }

    public void onFailedToReceiveAd() {
        mx.a("Custom event adapter called onFailedToReceiveAd.");
        this.s.onFailedToReceiveAd(this.q, AdRequest.ErrorCode.NO_FILL);
    }

    public void onLeaveApplication() {
        mx.a("Custom event adapter called onLeaveApplication.");
        this.s.onLeaveApplication(this.q);
    }

    public void onPresentScreen() {
        mx.a("Custom event adapter called onPresentScreen.");
        this.s.onPresentScreen(this.q);
    }

    public void onReceivedAd() {
        mx.a("Custom event adapter called onReceivedAd.");
        this.s.onReceivedAd(this.t);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventAdapter$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */