package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

class VisibilityTracker {
    @VisibleForTesting
    static final int NUM_ACCESSES_BEFORE_TRIMMING = 50;
    private static final int VISIBILITY_THROTTLE_MILLIS = 100;
    private long mAccessCounter = 0L;
    private boolean mIsVisibilityScheduled;
    @VisibleForTesting
    ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    @VisibleForTesting
    final WeakReference<View> mRootView;
    private final Map<View, VisibilityTracker.TrackingInfo> mTrackedViews;
    private final ArrayList<View> mTrimmedViews;
    private final VisibilityTracker.VisibilityChecker mVisibilityChecker;
    private final Handler mVisibilityHandler;
    private final VisibilityTracker.VisibilityRunnable mVisibilityRunnable;
    private VisibilityTracker.VisibilityTrackerListener mVisibilityTrackerListener;

    public VisibilityTracker(Context paramContext) {
        this(paramContext, new WeakHashMap(10), new VisibilityTracker.VisibilityChecker(), new Handler());
    }

    @VisibleForTesting
    VisibilityTracker(Context paramContext, Map<View, VisibilityTracker.TrackingInfo> paramMap, VisibilityTracker.VisibilityChecker paramVisibilityChecker, Handler paramHandler) {
        this.mTrackedViews = paramMap;
        this.mVisibilityChecker = paramVisibilityChecker;
        this.mVisibilityHandler = paramHandler;
        this.mVisibilityRunnable = new VisibilityTracker.VisibilityRunnable(this);
        this.mTrimmedViews = new ArrayList(50);
        paramContext = ((Activity) paramContext).getWindow().getDecorView();
        this.mRootView = new WeakReference(paramContext);
        paramContext = paramContext.getViewTreeObserver();
        if (!paramContext.isAlive()) {
            MoPubLog.w("Visibility Tracker was unable to track views because the root view tree observer was not alive");
            return;
        }
        this.mOnPreDrawListener = new VisibilityTracker .1 (this);
        paramContext.addOnPreDrawListener(this.mOnPreDrawListener);
    }

    private void trimTrackedViews(long paramLong) {
        Iterator localIterator = this.mTrackedViews.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            if (((VisibilityTracker.TrackingInfo) localEntry.getValue()).mAccessOrder < paramLong) {
                this.mTrimmedViews.add(localEntry.getKey());
            }
        }
        localIterator = this.mTrimmedViews.iterator();
        while (localIterator.hasNext()) {
            removeView((View) localIterator.next());
        }
        this.mTrimmedViews.clear();
    }

    void addView(View paramView, int paramInt) {
        VisibilityTracker.TrackingInfo localTrackingInfo2 = (VisibilityTracker.TrackingInfo) this.mTrackedViews.get(paramView);
        VisibilityTracker.TrackingInfo localTrackingInfo1 = localTrackingInfo2;
        if (localTrackingInfo2 == null) {
            localTrackingInfo1 = new VisibilityTracker.TrackingInfo();
            this.mTrackedViews.put(paramView, localTrackingInfo1);
            scheduleVisibilityCheck();
        }
        localTrackingInfo1.mMinViewablePercent = paramInt;
        localTrackingInfo1.mAccessOrder = this.mAccessCounter;
        this.mAccessCounter += 1L;
        if (this.mAccessCounter % 50L == 0L) {
            trimTrackedViews(this.mAccessCounter - 50L);
        }
    }

    void clear() {
        this.mTrackedViews.clear();
        this.mVisibilityHandler.removeMessages(0);
        this.mIsVisibilityScheduled = false;
    }

    void destroy() {
        clear();
        Object localObject = (View) this.mRootView.get();
        if ((localObject != null) && (this.mOnPreDrawListener != null)) {
            localObject = ((View) localObject).getViewTreeObserver();
            if (((ViewTreeObserver) localObject).isAlive()) {
                ((ViewTreeObserver) localObject).removeOnPreDrawListener(this.mOnPreDrawListener);
            }
            this.mOnPreDrawListener = null;
        }
        this.mVisibilityTrackerListener = null;
    }

    void removeView(View paramView) {
        this.mTrackedViews.remove(paramView);
    }

    void scheduleVisibilityCheck() {
        if (this.mIsVisibilityScheduled) {
            return;
        }
        this.mIsVisibilityScheduled = true;
        this.mVisibilityHandler.postDelayed(this.mVisibilityRunnable, 100L);
    }

    void setVisibilityTrackerListener(VisibilityTracker.VisibilityTrackerListener paramVisibilityTrackerListener) {
        this.mVisibilityTrackerListener = paramVisibilityTrackerListener;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/VisibilityTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */