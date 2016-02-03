package com.amazon.device.ads;

import java.util.HashMap;

abstract interface IAdController {
    public abstract void adClosedExpansion();

    public abstract void adExpanded();

    public abstract void adLoaded(AdProperties paramAdProperties);

    public abstract void destroy();

    public abstract AdLayout getAdLayout();

    public abstract AdSize getAdSize();

    public abstract String getMaxSize();

    public abstract AdWebViewClient.UrlExecutor getSpecialUrlExecutor();

    public abstract int getTimeout();

    public abstract int getWindowHeight();

    public abstract int getWindowWidth();

    public abstract boolean isAdExpanded();

    public abstract boolean isAdLoading();

    public abstract void prepareAd(long paramLong);

    public abstract void prepareToGoAway();

    public abstract boolean sendCommand(String paramString, HashMap<String, String> paramHashMap);

    public abstract void setListener(AdListener paramAdListener);

    public abstract void setTimeout(int paramInt);

    public abstract void setWindowDimensions(int paramInt1, int paramInt2);

    public abstract boolean shouldDisableWebViewHardwareAcceleration();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/IAdController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */