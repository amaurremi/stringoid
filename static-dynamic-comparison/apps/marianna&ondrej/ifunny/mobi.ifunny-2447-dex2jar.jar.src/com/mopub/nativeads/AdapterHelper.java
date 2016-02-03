package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;

import java.lang.ref.WeakReference;

@Deprecated
public final class AdapterHelper {
    private final WeakReference<Activity> mActivity;
    private final Context mApplicationContext;
    private final int mInterval;
    private final int mStart;

    @Deprecated
    public AdapterHelper(Context paramContext, int paramInt1, int paramInt2) {
        if (paramContext == null) {
            throw new IllegalArgumentException("Illegal argument: Context was null.");
        }
        if (!(paramContext instanceof Activity)) {
            throw new IllegalArgumentException("Illegal argument: Context must be instance of Activity.");
        }
        if (paramInt1 < 0) {
            throw new IllegalArgumentException("Illegal argument: negative starting position.");
        }
        if (paramInt2 < 2) {
            throw new IllegalArgumentException("Illegal argument: interval must be at least 2.");
        }
        this.mActivity = new WeakReference((Activity) paramContext);
        this.mApplicationContext = paramContext.getApplicationContext();
        this.mStart = paramInt1;
        this.mInterval = paramInt2;
    }

    private int numberOfAdsSeenUpToPosition(int paramInt) {
        if (paramInt <= this.mStart) {
            return 0;
        }
        return (int) Math.floor((paramInt - this.mStart) / this.mInterval) + 1;
    }

    private int numberOfAdsThatCouldFitWithContent(int paramInt) {
        if (paramInt <= this.mStart) {
            return 0;
        }
        int i = this.mInterval - 1;
        if ((paramInt - this.mStart) % i == 0) {
            return (paramInt - this.mStart) / i;
        }
        return (int) Math.floor((paramInt - this.mStart) / i) + 1;
    }

    @Deprecated
    @VisibleForTesting
    void clearActivityContext() {
        this.mActivity.clear();
    }

    @Deprecated
    public View getAdView(View paramView, ViewGroup paramViewGroup, NativeResponse paramNativeResponse, ViewBinder paramViewBinder, MoPubNative.MoPubNativeListener paramMoPubNativeListener) {
        Activity localActivity = (Activity) this.mActivity.get();
        if (localActivity == null) {
            MoPubLog.d("Weak reference to Activity Context in AdapterHelper became null. Returning empty view.");
            return new View(this.mApplicationContext);
        }
        return NativeAdViewHelper.getAdView(paramView, paramViewGroup, localActivity, paramNativeResponse, paramViewBinder, paramMoPubNativeListener);
    }

    @Deprecated
    public boolean isAdPosition(int paramInt) {
        if (paramInt < this.mStart) {
        }
        while ((paramInt - this.mStart) % this.mInterval != 0) {
            return false;
        }
        return true;
    }

    @Deprecated
    public int shiftedCount(int paramInt) {
        return numberOfAdsThatCouldFitWithContent(paramInt) + paramInt;
    }

    @Deprecated
    public int shiftedPosition(int paramInt) {
        return paramInt - numberOfAdsSeenUpToPosition(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/AdapterHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */