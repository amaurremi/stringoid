package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.logging.MoPubLog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class BaseForwardingNativeAd
        implements NativeAdInterface {
    private static final int IMPRESSION_MIN_PERCENTAGE_VIEWED = 50;
    static final double MAX_STAR_RATING = 5.0D;
    static final double MIN_STAR_RATING = 0.0D;
    private String mCallToAction;
    private String mClickDestinationUrl;
    private final Map<String, Object> mExtras = new HashMap();
    private String mIconImageUrl;
    private int mImpressionMinTimeViewed = 1000;
    private final Set<String> mImpressionTrackers = new HashSet();
    private String mMainImageUrl;
    private Double mStarRating;
    private String mText;
    private String mTitle;

    final void addExtra(String paramString, Object paramObject) {
        this.mExtras.put(paramString, paramObject);
    }

    final void addImpressionTracker(String paramString) {
        this.mImpressionTrackers.add(paramString);
    }

    public void destroy() {
    }

    public final String getCallToAction() {
        return this.mCallToAction;
    }

    public final String getClickDestinationUrl() {
        return this.mClickDestinationUrl;
    }

    public final Object getExtra(String paramString) {
        return this.mExtras.get(paramString);
    }

    public final Map<String, Object> getExtras() {
        return new HashMap(this.mExtras);
    }

    public final String getIconImageUrl() {
        return this.mIconImageUrl;
    }

    public final int getImpressionMinPercentageViewed() {
        return 50;
    }

    public final int getImpressionMinTimeViewed() {
        return this.mImpressionMinTimeViewed;
    }

    public final Set<String> getImpressionTrackers() {
        return new HashSet(this.mImpressionTrackers);
    }

    public final String getMainImageUrl() {
        return this.mMainImageUrl;
    }

    public final Double getStarRating() {
        return this.mStarRating;
    }

    public final String getText() {
        return this.mText;
    }

    public final String getTitle() {
        return this.mTitle;
    }

    public void handleClick(View paramView) {
    }

    public void prepareImpression(View paramView) {
    }

    public void recordImpression() {
    }

    final void setCallToAction(String paramString) {
        this.mCallToAction = paramString;
    }

    final void setClickDestinationUrl(String paramString) {
        this.mClickDestinationUrl = paramString;
    }

    final void setIconImageUrl(String paramString) {
        this.mIconImageUrl = paramString;
    }

    final void setImpressionMinTimeViewed(int paramInt) {
        if (paramInt >= 0) {
            this.mImpressionMinTimeViewed = paramInt;
        }
    }

    final void setMainImageUrl(String paramString) {
        this.mMainImageUrl = paramString;
    }

    final void setStarRating(Double paramDouble) {
        if (paramDouble == null) {
            this.mStarRating = null;
            return;
        }
        if ((paramDouble.doubleValue() >= 0.0D) && (paramDouble.doubleValue() <= 5.0D)) {
            this.mStarRating = paramDouble;
            return;
        }
        MoPubLog.d("Ignoring attempt to set invalid star rating (" + paramDouble + "). Must be " + "between " + 0.0D + " and " + 5.0D + ".");
    }

    final void setText(String paramString) {
        this.mText = paramString;
    }

    final void setTitle(String paramString) {
        this.mTitle = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/BaseForwardingNativeAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */