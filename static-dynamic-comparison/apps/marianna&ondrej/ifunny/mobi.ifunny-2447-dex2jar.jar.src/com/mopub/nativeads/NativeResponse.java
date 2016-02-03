package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.mopub.common.DownloadResponse;
import com.mopub.common.HttpClient;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.ResponseHeader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NativeResponse {
    private final String mAdUnitId;
    private final Context mContext;
    private boolean mIsClicked;
    private boolean mIsDestroyed;
    private final String mMoPubClickTracker;
    private final Set<String> mMoPubImpressionTrackers;
    private MoPubNative.MoPubNativeEventListener mMoPubNativeEventListener;
    private final NativeAdInterface mNativeAd;
    private boolean mRecordedImpression;

    public NativeResponse(Context paramContext, DownloadResponse paramDownloadResponse, String paramString, NativeAdInterface paramNativeAdInterface, MoPubNative.MoPubNativeEventListener paramMoPubNativeEventListener) {
        this.mContext = paramContext.getApplicationContext();
        this.mAdUnitId = paramString;
        this.mMoPubNativeEventListener = paramMoPubNativeEventListener;
        this.mNativeAd = paramNativeAdInterface;
        this.mMoPubImpressionTrackers = new HashSet();
        this.mMoPubImpressionTrackers.add(paramDownloadResponse.getFirstHeader(ResponseHeader.IMPRESSION_URL));
        this.mMoPubClickTracker = paramDownloadResponse.getFirstHeader(ResponseHeader.CLICKTHROUGH_URL);
    }

    private void loadImageView(String paramString, ImageView paramImageView) {
        ImageViewService.loadImageView(paramString, paramImageView);
    }

    private void openClickDestinationUrl(View paramView) {
        if (getClickDestinationUrl() == null) {
            return;
        }
        Object localObject = null;
        if (paramView != null) {
            localObject = new SpinningProgressView(this.mContext);
            ((SpinningProgressView) localObject).addToRoot(paramView);
        }
        paramView = Arrays.asList(new String[]{getClickDestinationUrl()}).iterator();
        localObject = new NativeResponse.ClickDestinationUrlResolutionListener(this.mContext, paramView, (SpinningProgressView) localObject);
        UrlResolutionTask.getResolvedUrl((String) paramView.next(), (UrlResolutionTask.UrlResolutionListener) localObject);
    }

    public void destroy() {
        if (isDestroyed()) {
            return;
        }
        this.mMoPubNativeEventListener = MoPubNative.EMPTY_EVENT_LISTENER;
        this.mNativeAd.destroy();
        this.mIsDestroyed = true;
    }

    public String getAdUnitId() {
        return this.mAdUnitId;
    }

    public String getCallToAction() {
        return this.mNativeAd.getCallToAction();
    }

    public String getClickDestinationUrl() {
        return this.mNativeAd.getClickDestinationUrl();
    }

    public String getClickTracker() {
        return this.mMoPubClickTracker;
    }

    public Object getExtra(String paramString) {
        return this.mNativeAd.getExtra(paramString);
    }

    public Map<String, Object> getExtras() {
        return this.mNativeAd.getExtras();
    }

    public String getIconImageUrl() {
        return this.mNativeAd.getIconImageUrl();
    }

    public int getImpressionMinPercentageViewed() {
        return this.mNativeAd.getImpressionMinPercentageViewed();
    }

    public int getImpressionMinTimeViewed() {
        return this.mNativeAd.getImpressionMinTimeViewed();
    }

    public List<String> getImpressionTrackers() {
        HashSet localHashSet = new HashSet();
        localHashSet.addAll(this.mMoPubImpressionTrackers);
        localHashSet.addAll(this.mNativeAd.getImpressionTrackers());
        return new ArrayList(localHashSet);
    }

    public String getMainImageUrl() {
        return this.mNativeAd.getMainImageUrl();
    }

    @Deprecated
    @VisibleForTesting
    MoPubNative.MoPubNativeEventListener getMoPubNativeEventListener() {
        return this.mMoPubNativeEventListener;
    }

    public boolean getRecordedImpression() {
        return this.mRecordedImpression;
    }

    public Double getStarRating() {
        return this.mNativeAd.getStarRating();
    }

    @Deprecated
    public String getSubtitle() {
        return this.mNativeAd.getText();
    }

    public String getText() {
        return this.mNativeAd.getText();
    }

    public String getTitle() {
        return this.mNativeAd.getTitle();
    }

    public void handleClick(View paramView) {
        if (isDestroyed()) {
            return;
        }
        if (!isClicked()) {
            HttpClient.makeTrackingHttpRequest(this.mMoPubClickTracker, this.mContext);
        }
        openClickDestinationUrl(paramView);
        this.mNativeAd.handleClick(paramView);
        this.mIsClicked = true;
        this.mMoPubNativeEventListener.onNativeClick(paramView);
    }

    public boolean isClicked() {
        return this.mIsClicked;
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    public void loadExtrasImage(String paramString, ImageView paramImageView) {
        paramString = getExtra(paramString);
        if ((paramString != null) && ((paramString instanceof String))) {
            loadImageView((String) paramString, paramImageView);
        }
    }

    public void loadIconImage(ImageView paramImageView) {
        loadImageView(getIconImageUrl(), paramImageView);
    }

    public void loadMainImage(ImageView paramImageView) {
        loadImageView(getMainImageUrl(), paramImageView);
    }

    public void prepareImpression(View paramView) {
        if ((getRecordedImpression()) || (isDestroyed())) {
            return;
        }
        this.mNativeAd.prepareImpression(paramView);
    }

    public void recordImpression(View paramView) {
        if ((getRecordedImpression()) || (isDestroyed())) {
            return;
        }
        Iterator localIterator = getImpressionTrackers().iterator();
        while (localIterator.hasNext()) {
            HttpClient.makeTrackingHttpRequest((String) localIterator.next(), this.mContext);
        }
        this.mNativeAd.recordImpression();
        this.mRecordedImpression = true;
        this.mMoPubNativeEventListener.onNativeImpression(paramView);
    }

    @Deprecated
    @VisibleForTesting
    void setRecordedImpression(boolean paramBoolean) {
        this.mRecordedImpression = paramBoolean;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("\n");
        localStringBuilder.append(NativeResponse.Parameter.TITLE.name).append(":").append(getTitle()).append("\n");
        localStringBuilder.append(NativeResponse.Parameter.TEXT.name).append(":").append(getText()).append("\n");
        localStringBuilder.append(NativeResponse.Parameter.ICON_IMAGE.name).append(":").append(getIconImageUrl()).append("\n");
        localStringBuilder.append(NativeResponse.Parameter.MAIN_IMAGE.name).append(":").append(getMainImageUrl()).append("\n");
        localStringBuilder.append(NativeResponse.Parameter.STAR_RATING.name).append(":").append(getStarRating()).append("\n");
        localStringBuilder.append(NativeResponse.Parameter.IMPRESSION_TRACKER.name).append(":").append(getImpressionTrackers()).append("\n");
        localStringBuilder.append(NativeResponse.Parameter.CLICK_TRACKER.name).append(":").append(this.mMoPubClickTracker).append("\n");
        localStringBuilder.append(NativeResponse.Parameter.CLICK_DESTINATION.name).append(":").append(getClickDestinationUrl()).append("\n");
        localStringBuilder.append(NativeResponse.Parameter.CALL_TO_ACTION.name).append(":").append(getCallToAction()).append("\n");
        localStringBuilder.append("recordedImpression").append(":").append(this.mRecordedImpression).append("\n");
        localStringBuilder.append("extras").append(":").append(getExtras());
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/NativeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */