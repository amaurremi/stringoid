package com.mopub.nativeads;

import android.view.View;

import java.util.Map;
import java.util.Set;

abstract interface NativeAdInterface {
    public abstract void destroy();

    public abstract String getCallToAction();

    public abstract String getClickDestinationUrl();

    public abstract Object getExtra(String paramString);

    public abstract Map<String, Object> getExtras();

    public abstract String getIconImageUrl();

    public abstract int getImpressionMinPercentageViewed();

    public abstract int getImpressionMinTimeViewed();

    public abstract Set<String> getImpressionTrackers();

    public abstract String getMainImageUrl();

    public abstract Double getStarRating();

    public abstract String getText();

    public abstract String getTitle();

    public abstract void handleClick(View paramView);

    public abstract void prepareImpression(View paramView);

    public abstract void recordImpression();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/NativeAdInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */