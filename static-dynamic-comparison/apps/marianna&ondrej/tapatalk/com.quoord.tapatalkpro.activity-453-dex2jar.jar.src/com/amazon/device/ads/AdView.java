package com.amazon.device.ads;

abstract interface AdView {
    public abstract int getHeight();

    public abstract AdWebViewClient.UrlExecutor getSpecialUrlExecutor();

    public abstract boolean isAdViewRenderable();

    public abstract boolean launchExternalBrowserForLink(String paramString);

    public abstract void onPageFinished();

    public abstract boolean shouldDisableWebViewHardwareAcceleration();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */