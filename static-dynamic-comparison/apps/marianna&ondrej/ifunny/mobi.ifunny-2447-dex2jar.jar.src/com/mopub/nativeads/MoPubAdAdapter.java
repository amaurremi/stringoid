package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;

import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class MoPubAdAdapter
        extends BaseAdapter {
    private MoPubNativeAdLoadedListener mAdLoadedListener;
    private final Adapter mOriginalAdapter;
    private final MoPubStreamAdPlacer mStreamAdPlacer;
    private final WeakHashMap<View, Integer> mViewPositionMap;
    private final VisibilityTracker mVisibilityTracker;

    public MoPubAdAdapter(Context paramContext, Adapter paramAdapter) {
        this(paramContext, paramAdapter, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubAdAdapter(Context paramContext, Adapter paramAdapter, MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning) {
        this(new MoPubStreamAdPlacer(paramContext, paramMoPubClientPositioning), paramAdapter, new VisibilityTracker(paramContext));
    }

    public MoPubAdAdapter(Context paramContext, Adapter paramAdapter, MoPubNativeAdPositioning.MoPubServerPositioning paramMoPubServerPositioning) {
        this(new MoPubStreamAdPlacer(paramContext, paramMoPubServerPositioning), paramAdapter, new VisibilityTracker(paramContext));
    }

    @VisibleForTesting
    MoPubAdAdapter(MoPubStreamAdPlacer paramMoPubStreamAdPlacer, Adapter paramAdapter, VisibilityTracker paramVisibilityTracker) {
        this.mOriginalAdapter = paramAdapter;
        this.mStreamAdPlacer = paramMoPubStreamAdPlacer;
        this.mViewPositionMap = new WeakHashMap();
        this.mVisibilityTracker = paramVisibilityTracker;
        this.mVisibilityTracker.setVisibilityTrackerListener(new MoPubAdAdapter .1 (this));
        this.mOriginalAdapter.registerDataSetObserver(new MoPubAdAdapter .2 (this));
        this.mStreamAdPlacer.setAdLoadedListener(new MoPubAdAdapter .3 (this));
        this.mStreamAdPlacer.setItemCount(this.mOriginalAdapter.getCount());
    }

    private void handleVisibilityChange(List<View> paramList) {
        paramList = paramList.iterator();
        int j = Integer.MAX_VALUE;
        int i = 0;
        while (paramList.hasNext()) {
            Object localObject = (View) paramList.next();
            localObject = (Integer) this.mViewPositionMap.get(localObject);
            if (localObject != null) {
                j = Math.min(((Integer) localObject).intValue(), j);
                i = Math.max(((Integer) localObject).intValue(), i);
            }
        }
        this.mStreamAdPlacer.placeAdsInRange(j, i + 1);
    }

    public boolean areAllItemsEnabled() {
        return ((this.mOriginalAdapter instanceof ListAdapter)) && (((ListAdapter) this.mOriginalAdapter).areAllItemsEnabled());
    }

    public void clearAds() {
        this.mStreamAdPlacer.clearAds();
    }

    public void destroy() {
        this.mStreamAdPlacer.destroy();
        this.mVisibilityTracker.destroy();
    }

    public int getAdjustedPosition(int paramInt) {
        return this.mStreamAdPlacer.getAdjustedPosition(paramInt);
    }

    public int getCount() {
        return this.mStreamAdPlacer.getAdjustedCount(this.mOriginalAdapter.getCount());
    }

    public Object getItem(int paramInt) {
        Object localObject = this.mStreamAdPlacer.getAdData(paramInt);
        if (localObject != null) {
            return localObject;
        }
        return this.mOriginalAdapter.getItem(this.mStreamAdPlacer.getOriginalPosition(paramInt));
    }

    public long getItemId(int paramInt) {
        Object localObject = this.mStreamAdPlacer.getAdData(paramInt);
        if (localObject != null) {
            return (System.identityHashCode(localObject) ^ 0xFFFFFFFF) + 1;
        }
        return this.mOriginalAdapter.getItemId(this.mStreamAdPlacer.getOriginalPosition(paramInt));
    }

    public int getItemViewType(int paramInt) {
        int i = this.mStreamAdPlacer.getAdViewType(paramInt);
        if (i != 0) {
            return i + this.mOriginalAdapter.getViewTypeCount() - 1;
        }
        return this.mOriginalAdapter.getItemViewType(this.mStreamAdPlacer.getOriginalPosition(paramInt));
    }

    public int getOriginalPosition(int paramInt) {
        return this.mStreamAdPlacer.getOriginalPosition(paramInt);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
        View localView = this.mStreamAdPlacer.getAdView(paramInt, paramView, paramViewGroup);
        if (localView != null) {
        }
        for (paramView = localView; ; paramView = this.mOriginalAdapter.getView(this.mStreamAdPlacer.getOriginalPosition(paramInt), paramView, paramViewGroup)) {
            this.mViewPositionMap.put(paramView, Integer.valueOf(paramInt));
            this.mVisibilityTracker.addView(paramView, 0);
            return paramView;
        }
    }

    public int getViewTypeCount() {
        return this.mOriginalAdapter.getViewTypeCount() + this.mStreamAdPlacer.getAdViewTypeCount();
    }

    @VisibleForTesting
    void handleAdLoaded(int paramInt) {
        if (this.mAdLoadedListener != null) {
            this.mAdLoadedListener.onAdLoaded(paramInt);
        }
        notifyDataSetChanged();
    }

    @VisibleForTesting
    void handleAdRemoved(int paramInt) {
        if (this.mAdLoadedListener != null) {
            this.mAdLoadedListener.onAdRemoved(paramInt);
        }
        notifyDataSetChanged();
    }

    public boolean hasStableIds() {
        return this.mOriginalAdapter.hasStableIds();
    }

    public void insertItem(int paramInt) {
        this.mStreamAdPlacer.insertItem(paramInt);
    }

    public boolean isAd(int paramInt) {
        return this.mStreamAdPlacer.isAd(paramInt);
    }

    public boolean isEmpty() {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (this.mOriginalAdapter.isEmpty()) {
            bool1 = bool2;
            if (this.mStreamAdPlacer.getAdjustedCount(0) == 0) {
                bool1 = true;
            }
        }
        return bool1;
    }

    public boolean isEnabled(int paramInt) {
        return (isAd(paramInt)) || (((this.mOriginalAdapter instanceof ListAdapter)) && (((ListAdapter) this.mOriginalAdapter).isEnabled(this.mStreamAdPlacer.getOriginalPosition(paramInt))));
    }

    public void loadAds(String paramString) {
        this.mStreamAdPlacer.loadAds(paramString);
    }

    public void loadAds(String paramString, RequestParameters paramRequestParameters) {
        this.mStreamAdPlacer.loadAds(paramString, paramRequestParameters);
    }

    public void refreshAds(ListView paramListView, String paramString) {
        refreshAds(paramListView, paramString, null);
    }

    public void refreshAds(ListView paramListView, String paramString, RequestParameters paramRequestParameters) {
        if (paramListView.getAdapter() != this) {
            MoPubLog.w("You called refreshAds on a ListView whose adapter is not an ad placer");
            return;
        }
        View localView = paramListView.getChildAt(0);
        if (localView == null) {
        }
        int m;
        for (int i = 0; ; i = localView.getTop()) {
            m = paramListView.getFirstVisiblePosition();
            j = Math.max(m - 1, 0);
            while ((this.mStreamAdPlacer.isAd(j)) && (j > 0)) {
                j -= 1;
            }
        }
        int k = paramListView.getLastVisiblePosition();
        while ((this.mStreamAdPlacer.isAd(k)) && (k < getCount() - 1)) {
            k += 1;
        }
        int j = this.mStreamAdPlacer.getOriginalPosition(j);
        k = this.mStreamAdPlacer.getOriginalCount(k + 1);
        int n = this.mStreamAdPlacer.getOriginalCount(getCount());
        this.mStreamAdPlacer.removeAdsInRange(k, n);
        j = this.mStreamAdPlacer.removeAdsInRange(0, j);
        if (j > 0) {
            paramListView.setSelectionFromTop(m - j, i);
        }
        loadAds(paramString, paramRequestParameters);
    }

    public final void registerAdRenderer(MoPubAdRenderer paramMoPubAdRenderer) {
        if (paramMoPubAdRenderer == null) {
            MoPubLog.w("Tried to set a null ad renderer on the placer.");
            return;
        }
        this.mStreamAdPlacer.registerAdRenderer(paramMoPubAdRenderer);
    }

    public void removeItem(int paramInt) {
        this.mStreamAdPlacer.removeItem(paramInt);
    }

    public final void setAdLoadedListener(MoPubNativeAdLoadedListener paramMoPubNativeAdLoadedListener) {
        this.mAdLoadedListener = paramMoPubNativeAdLoadedListener;
    }

    public void setOnClickListener(ListView paramListView, AdapterView.OnItemClickListener paramOnItemClickListener) {
        paramListView.setOnItemClickListener(new MoPubAdAdapter .4 (this, paramOnItemClickListener));
    }

    public void setOnItemLongClickListener(ListView paramListView, AdapterView.OnItemLongClickListener paramOnItemLongClickListener) {
        paramListView.setOnItemLongClickListener(new MoPubAdAdapter .5 (this, paramOnItemLongClickListener));
    }

    public void setOnItemSelectedListener(ListView paramListView, AdapterView.OnItemSelectedListener paramOnItemSelectedListener) {
        paramListView.setOnItemSelectedListener(new MoPubAdAdapter .6 (this, paramOnItemSelectedListener));
    }

    public void setSelection(ListView paramListView, int paramInt) {
        paramListView.setSelection(this.mStreamAdPlacer.getAdjustedPosition(paramInt));
    }

    public void smoothScrollToPosition(ListView paramListView, int paramInt) {
        paramListView.smoothScrollToPosition(this.mStreamAdPlacer.getAdjustedPosition(paramInt));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/MoPubAdAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */