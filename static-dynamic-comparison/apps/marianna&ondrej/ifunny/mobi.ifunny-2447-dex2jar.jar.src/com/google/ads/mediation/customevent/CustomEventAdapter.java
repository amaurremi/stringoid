package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.b.b.b;
import com.google.android.gms.internal.mx;

public final class CustomEventAdapter
        implements MediationBannerAdapter<b, CustomEventServerParameters>, MediationInterstitialAdapter<b, CustomEventServerParameters> {
    private View n;
    private CustomEventBanner o;
    private CustomEventInterstitial p;

    private static <T> T a(String paramString) {
        try {
            Object localObject = Class.forName(paramString).newInstance();
            return (T) localObject;
        } catch (Throwable localThrowable) {
            mx.e("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
        }
        return null;
    }

    private void a(View paramView) {
        this.n = paramView;
    }

    public void destroy() {
        if (this.o != null) {
            this.o.destroy();
        }
        if (this.p != null) {
            this.p.destroy();
        }
    }

    public Class<b> getAdditionalParametersType() {
        return b.class;
    }

    public View getBannerView() {
        return this.n;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener paramMediationBannerListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, b paramb) {
        this.o = ((CustomEventBanner) a(paramCustomEventServerParameters.className));
        if (this.o == null) {
            paramMediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (paramb == null) {
        }
        for (paramb = null; ; paramb = paramb.a(paramCustomEventServerParameters.label)) {
            this.o.requestBannerAd(new CustomEventAdapter.a(this, paramMediationBannerListener), paramActivity, paramCustomEventServerParameters.label, paramCustomEventServerParameters.parameter, paramAdSize, paramMediationAdRequest, paramb);
            return;
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, CustomEventServerParameters paramCustomEventServerParameters, MediationAdRequest paramMediationAdRequest, b paramb) {
        this.p = ((CustomEventInterstitial) a(paramCustomEventServerParameters.className));
        if (this.p == null) {
            paramMediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (paramb == null) {
        }
        for (paramb = null; ; paramb = paramb.a(paramCustomEventServerParameters.label)) {
            this.p.requestInterstitialAd(new CustomEventAdapter.b(this, this, paramMediationInterstitialListener), paramActivity, paramCustomEventServerParameters.label, paramCustomEventServerParameters.parameter, paramMediationAdRequest, paramb);
            return;
        }
    }

    public void showInterstitial() {
        this.p.showInterstitial();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */