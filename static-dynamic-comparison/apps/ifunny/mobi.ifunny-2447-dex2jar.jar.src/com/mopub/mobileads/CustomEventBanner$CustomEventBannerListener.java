package com.mopub.mobileads;

import android.view.View;

public abstract interface CustomEventBanner$CustomEventBannerListener {
    public abstract void onBannerClicked();

    public abstract void onBannerCollapsed();

    public abstract void onBannerExpanded();

    public abstract void onBannerFailed(MoPubErrorCode paramMoPubErrorCode);

    public abstract void onBannerLoaded(View paramView);

    public abstract void onLeaveApplication();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/CustomEventBanner$CustomEventBannerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */