package com.google.android.gms.ads.mediation;

public abstract interface MediationInterstitialListener {
    public abstract void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter);

    public abstract void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt);

    public abstract void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter);

    public abstract void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter);

    public abstract void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/ads/mediation/MediationInterstitialListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */