package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.logging.MoPubLog;

import java.util.WeakHashMap;

@Deprecated
class NativeAdViewHelper {
    private static final WeakHashMap<Context, ImpressionTracker> sImpressionTrackerMap = new WeakHashMap();

    private static void cleanUpImpressionTracking(Context paramContext, View paramView) {
        getImpressionTracker(paramContext).removeView(paramView);
    }

    @Deprecated
    static View getAdView(View paramView, ViewGroup paramViewGroup, Context paramContext, NativeResponse paramNativeResponse, ViewBinder paramViewBinder, MoPubNative.MoPubNativeListener paramMoPubNativeListener) {
        if (paramViewBinder == null) {
            MoPubLog.d("ViewBinder is null, returning empty view.");
            return new View(paramContext);
        }
        paramMoPubNativeListener = new MoPubNativeAdRenderer(paramViewBinder);
        paramViewBinder = paramView;
        if (paramView == null) {
            paramViewBinder = paramMoPubNativeListener.createAdView(paramContext, paramViewGroup);
        }
        cleanUpImpressionTracking(paramContext, paramViewBinder);
        if (paramNativeResponse == null) {
            MoPubLog.d("NativeResponse is null, returning hidden view.");
            paramViewBinder.setVisibility(8);
            return paramViewBinder;
        }
        if (paramNativeResponse.isDestroyed()) {
            MoPubLog.d("NativeResponse is destroyed, returning hidden view.");
            paramViewBinder.setVisibility(8);
            return paramViewBinder;
        }
        paramMoPubNativeListener.renderAdView(paramViewBinder, paramNativeResponse);
        prepareImpressionTracking(paramContext, paramViewBinder, paramNativeResponse);
        return paramViewBinder;
    }

    private static ImpressionTracker getImpressionTracker(Context paramContext) {
        ImpressionTracker localImpressionTracker2 = (ImpressionTracker) sImpressionTrackerMap.get(paramContext);
        ImpressionTracker localImpressionTracker1 = localImpressionTracker2;
        if (localImpressionTracker2 == null) {
            localImpressionTracker1 = new ImpressionTracker(paramContext);
            sImpressionTrackerMap.put(paramContext, localImpressionTracker1);
        }
        return localImpressionTracker1;
    }

    private static void prepareImpressionTracking(Context paramContext, View paramView, NativeResponse paramNativeResponse) {
        getImpressionTracker(paramContext).addView(paramView, paramNativeResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/NativeAdViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */