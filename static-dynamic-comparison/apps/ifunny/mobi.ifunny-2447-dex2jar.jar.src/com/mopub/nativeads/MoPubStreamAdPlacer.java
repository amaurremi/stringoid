package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;

import java.util.ArrayList;
import java.util.Iterator;

public class MoPubStreamAdPlacer {
    private static final int MAX_VISIBLE_RANGE = 100;
    private static final int RANGE_BUFFER = 10;
    private MoPubNativeAdLoadedListener mAdLoadedListener;
    private MoPubAdRenderer mAdRenderer;
    private final NativeAdSource mAdSource;
    private String mAdUnitId;
    private final Context mContext;
    private boolean mHasPlacedAds;
    private boolean mHasReceivedAds;
    private boolean mHasReceivedPositions;
    private final ImpressionTracker mImpressionTracker;
    private int mItemCount;
    private boolean mNeedsPlacement;
    private PlacementData mPendingPlacementData;
    private PlacementData mPlacementData;
    private final Handler mPlacementHandler;
    private final Runnable mPlacementRunnable;
    private final PositioningSource mPositioningSource;
    private int mVisibleRangeEnd;
    private int mVisibleRangeStart;

    public MoPubStreamAdPlacer(Context paramContext) {
        this(paramContext, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubStreamAdPlacer(Context paramContext, MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning) {
        this(paramContext, new NativeAdSource(), new ImpressionTracker(paramContext), new ClientPositioningSource(paramMoPubClientPositioning));
    }

    public MoPubStreamAdPlacer(Context paramContext, MoPubNativeAdPositioning.MoPubServerPositioning paramMoPubServerPositioning) {
        this(paramContext, new NativeAdSource(), new ImpressionTracker(paramContext), new ServerPositioningSource(paramContext));
    }

    @VisibleForTesting
    MoPubStreamAdPlacer(Context paramContext, NativeAdSource paramNativeAdSource, ImpressionTracker paramImpressionTracker, PositioningSource paramPositioningSource) {
        this.mContext = paramContext;
        this.mImpressionTracker = paramImpressionTracker;
        this.mPositioningSource = paramPositioningSource;
        this.mAdSource = paramNativeAdSource;
        this.mPlacementData = PlacementData.empty();
        this.mPlacementHandler = new Handler();
        this.mPlacementRunnable = new MoPubStreamAdPlacer .1 (this);
        this.mVisibleRangeStart = 0;
        this.mVisibleRangeEnd = 0;
    }

    private NativeAdData createAdData(int paramInt, NativeResponse paramNativeResponse) {
        return new NativeAdData(this.mAdUnitId, this.mAdRenderer, paramNativeResponse);
    }

    private void notifyNeedsPlacement() {
        if (this.mNeedsPlacement) {
            return;
        }
        this.mNeedsPlacement = true;
        this.mPlacementHandler.post(this.mPlacementRunnable);
    }

    private void placeAds() {
        if (!tryPlaceAdsInRange(this.mVisibleRangeStart, this.mVisibleRangeEnd)) {
            return;
        }
        tryPlaceAdsInRange(this.mVisibleRangeEnd, this.mVisibleRangeEnd + 10);
    }

    private void placeInitialAds(PlacementData paramPlacementData) {
        removeAdsInRange(0, this.mItemCount);
        this.mPlacementData = paramPlacementData;
        placeAds();
        this.mHasPlacedAds = true;
    }

    private boolean tryPlaceAd(int paramInt) {
        Object localObject = this.mAdSource.dequeueAd();
        if (localObject == null) {
            return false;
        }
        localObject = createAdData(paramInt, (NativeResponse) localObject);
        this.mPlacementData.placeAd(paramInt, (NativeAdData) localObject);
        this.mItemCount += 1;
        if (this.mAdLoadedListener != null) {
            this.mAdLoadedListener.onAdLoaded(paramInt);
        }
        return true;
    }

    private boolean tryPlaceAdsInRange(int paramInt1, int paramInt2) {
        paramInt2 -= 1;
        for (; ; ) {
            if ((paramInt1 > paramInt2) || (paramInt1 == -1) || (paramInt1 >= this.mItemCount)) {
                return true;
            }
            int i = paramInt2;
            if (this.mPlacementData.shouldPlaceAd(paramInt1)) {
                if (!tryPlaceAd(paramInt1)) {
                    return false;
                }
                i = paramInt2 + 1;
            }
            paramInt1 = this.mPlacementData.nextInsertionPosition(paramInt1);
            paramInt2 = i;
        }
    }

    public void clearAds() {
        removeAdsInRange(0, this.mItemCount);
        this.mAdSource.clear();
    }

    public void destroy() {
        this.mPlacementHandler.removeMessages(0);
        this.mAdSource.clear();
        this.mImpressionTracker.destroy();
        this.mPlacementData.clearAds();
    }

    public Object getAdData(int paramInt) {
        return this.mPlacementData.getPlacedAd(paramInt);
    }

    public View getAdView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        if (!isAd(paramInt)) {
            return null;
        }
        NativeAdData localNativeAdData = this.mPlacementData.getPlacedAd(paramInt);
        MoPubAdRenderer localMoPubAdRenderer = localNativeAdData.getAdRenderer();
        if (paramView != null) {
        }
        for (; ; ) {
            paramViewGroup = localNativeAdData.getAd();
            localMoPubAdRenderer.renderAdView(paramView, paramViewGroup);
            this.mImpressionTracker.addView(paramView, paramViewGroup);
            return paramView;
            paramView = localMoPubAdRenderer.createAdView(this.mContext, paramViewGroup);
        }
    }

    public int getAdViewType(int paramInt) {
        if (isAd(paramInt)) {
            return 0;
        }
        return 1;
    }

    public int getAdViewTypeCount() {
        return 1;
    }

    public int getAdjustedCount(int paramInt) {
        return this.mPlacementData.getAdjustedCount(paramInt);
    }

    public int getAdjustedPosition(int paramInt) {
        return this.mPlacementData.getAdjustedPosition(paramInt);
    }

    public int getOriginalCount(int paramInt) {
        return this.mPlacementData.getOriginalCount(paramInt);
    }

    public int getOriginalPosition(int paramInt) {
        return this.mPlacementData.getOriginalPosition(paramInt);
    }

    @VisibleForTesting
    void handleAdsAvailable() {
        if (this.mHasPlacedAds) {
            notifyNeedsPlacement();
            return;
        }
        if (this.mHasReceivedPositions) {
            placeInitialAds(this.mPendingPlacementData);
        }
        this.mHasReceivedAds = true;
    }

    @VisibleForTesting
    void handlePositioningLoad(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning) {
        paramMoPubClientPositioning = PlacementData.fromAdPositioning(paramMoPubClientPositioning);
        if (this.mHasReceivedAds) {
            placeInitialAds(paramMoPubClientPositioning);
        }
        for (; ; ) {
            this.mHasReceivedPositions = true;
            return;
            this.mPendingPlacementData = paramMoPubClientPositioning;
        }
    }

    public void insertItem(int paramInt) {
        this.mPlacementData.insertItem(paramInt);
    }

    public boolean isAd(int paramInt) {
        return this.mPlacementData.isPlacedAd(paramInt);
    }

    public void loadAds(String paramString) {
        loadAds(paramString, null);
    }

    public void loadAds(String paramString, RequestParameters paramRequestParameters) {
        this.mAdUnitId = paramString;
        this.mHasPlacedAds = false;
        this.mHasReceivedPositions = false;
        this.mHasReceivedAds = false;
        this.mPositioningSource.loadPositions(paramString, new MoPubStreamAdPlacer .2 (this));
        this.mAdSource.setAdSourceListener(new MoPubStreamAdPlacer .3 (this));
        this.mAdSource.loadAds(this.mContext, paramString, paramRequestParameters);
    }

    public void moveItem(int paramInt1, int paramInt2) {
        this.mPlacementData.moveItem(paramInt1, paramInt2);
    }

    public void placeAdsInRange(int paramInt1, int paramInt2) {
        this.mVisibleRangeStart = paramInt1;
        this.mVisibleRangeEnd = Math.min(paramInt2, paramInt1 + 100);
        notifyNeedsPlacement();
    }

    public void registerAdRenderer(MoPubAdRenderer paramMoPubAdRenderer) {
        this.mAdRenderer = paramMoPubAdRenderer;
    }

    public int removeAdsInRange(int paramInt1, int paramInt2) {
        Object localObject = this.mPlacementData.getPlacedAdPositions();
        int i = this.mPlacementData.getAdjustedPosition(paramInt1);
        paramInt2 = this.mPlacementData.getAdjustedPosition(paramInt2);
        ArrayList localArrayList = new ArrayList();
        paramInt1 = localObject.length - 1;
        if (paramInt1 >= 0) {
            int j = localObject[paramInt1];
            if ((j < i) || (j >= paramInt2)) {
            }
            for (; ; ) {
                paramInt1 -= 1;
                break;
                localArrayList.add(Integer.valueOf(j));
                if (j < this.mVisibleRangeStart) {
                    this.mVisibleRangeStart -= 1;
                }
                this.mItemCount -= 1;
            }
        }
        paramInt1 = this.mPlacementData.clearAdsInRange(i, paramInt2);
        localObject = localArrayList.iterator();
        while (((Iterator) localObject).hasNext()) {
            paramInt2 = ((Integer) ((Iterator) localObject).next()).intValue();
            this.mAdLoadedListener.onAdRemoved(paramInt2);
        }
        return paramInt1;
    }

    public void removeItem(int paramInt) {
        this.mPlacementData.removeItem(paramInt);
    }

    public void setAdLoadedListener(MoPubNativeAdLoadedListener paramMoPubNativeAdLoadedListener) {
        this.mAdLoadedListener = paramMoPubNativeAdLoadedListener;
    }

    public void setItemCount(int paramInt) {
        this.mItemCount = this.mPlacementData.getAdjustedCount(paramInt);
        notifyNeedsPlacement();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubStreamAdPlacer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */