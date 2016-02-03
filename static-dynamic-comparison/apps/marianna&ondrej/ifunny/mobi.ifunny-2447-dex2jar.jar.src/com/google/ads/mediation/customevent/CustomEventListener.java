package com.google.ads.mediation.customevent;

@Deprecated
public abstract interface CustomEventListener {
    public abstract void onDismissScreen();

    public abstract void onFailedToReceiveAd();

    public abstract void onLeaveApplication();

    public abstract void onPresentScreen();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/ads/mediation/customevent/CustomEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */