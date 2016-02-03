package com.google.ads.mediation;

import android.app.Activity;

@Deprecated
public abstract interface MediationInterstitialAdapter<ADDITIONAL_PARAMETERS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
        extends MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    public abstract void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, SERVER_PARAMETERS paramSERVER_PARAMETERS, MediationAdRequest paramMediationAdRequest, ADDITIONAL_PARAMETERS paramADDITIONAL_PARAMETERS);

    public abstract void showInterstitial();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/ads/mediation/MediationInterstitialAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */