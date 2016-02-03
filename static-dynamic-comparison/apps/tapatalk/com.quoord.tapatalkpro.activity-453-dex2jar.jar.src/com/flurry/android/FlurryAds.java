package com.flurry.android;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.dz;
import com.flurry.sdk.eo;
import com.flurry.sdk.u;

import java.util.Map;

public class FlurryAds {
    private static final String a = FlurryAds.class.getSimpleName();

    public static void clearLocation() {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        dz.a().e();
    }

    public static void clearTargetingKeywords() {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().A();
    }

    public static void clearUserCookies() {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().y();
    }

    public static void displayAd(Context paramContext, String paramString, ViewGroup paramViewGroup) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        if (paramContext == null) {
            eo.b(a, "Context passed to displayAd was null.");
            return;
        }
        if (paramString == null) {
            eo.b(a, "Ad space name passed to displayAd was null.");
            return;
        }
        if (paramString.length() == 0) {
            eo.b(a, "Ad space name passed to displayAd was empty.");
            return;
        }
        if (paramViewGroup == null) {
            eo.b(a, "ViewGroup passed to displayAd was null.");
            return;
        }
        try {
            FlurryAdModule.getInstance().d().a(paramContext, paramString, paramViewGroup);
            return;
        } catch (Throwable paramContext) {
            eo.a(a, "Exception while displaying Ad: ", paramContext);
        }
    }

    public static void enableTestAds(boolean paramBoolean) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().a(paramBoolean);
    }

    public static void fetchAd(Context paramContext, String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        if (paramContext == null) {
            eo.b(a, "Context passed to fetchAd was null.");
            return;
        }
        if (paramString == null) {
            eo.b(a, "Ad space name passed to fetchAd was null.");
            return;
        }
        if (paramString.length() == 0) {
            eo.b(a, "Ad space name passed to fetchAd was empty.");
            return;
        }
        if (paramViewGroup == null) {
            eo.b(a, "ViewGroup passed to fetchAd was null.");
            return;
        }
        if (paramFlurryAdSize == null) {
            eo.b(a, "FlurryAdSize passed to fetchAd was null.");
            return;
        }
        try {
            FlurryAdModule.getInstance().d().a(paramContext, paramString, paramViewGroup, paramFlurryAdSize, false);
            return;
        } catch (Throwable paramContext) {
            eo.a(a, "Exception while fetching Ad: ", paramContext);
        }
    }

    @Deprecated
    public static boolean getAd(Context paramContext, String paramString, ViewGroup paramViewGroup, FlurryAdSize paramFlurryAdSize, long paramLong) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return false;
        }
        if (paramContext == null) {
            eo.b(a, "Context passed to getAd was null.");
            return false;
        }
        if (paramString == null) {
            eo.b(a, "Ad space name passed to getAd was null.");
            return false;
        }
        if (paramString.length() == 0) {
            eo.b(a, "Ad space name passed to getAd was empty.");
            return false;
        }
        if (paramViewGroup == null) {
            eo.b(a, "ViewGroup passed to getAd was null.");
            return false;
        }
        if (paramFlurryAdSize == null) {
            eo.b(a, "FlurryAdSize passed to getAd was null.");
            return false;
        }
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            eo.b(a, "getAd must be called from UI thread.");
            return false;
        }
        try {
            boolean bool = FlurryAdModule.getInstance().d().a(paramContext, paramString, paramViewGroup, paramFlurryAdSize);
            return bool;
        } catch (Throwable paramContext) {
            eo.a(a, "Exception while getting Ad : ", paramContext);
        }
        return false;
    }

    @Deprecated
    public static void initializeAds(Context paramContext) {
    }

    @Deprecated
    public static boolean isAdAvailable(Context paramContext, String paramString, FlurryAdSize paramFlurryAdSize, long paramLong) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return false;
        }
        if (paramContext == null) {
            eo.b(a, "Context passed to isAdAvailable was null.");
            return false;
        }
        if (paramString == null) {
            eo.b(a, "Ad space name passed to isAdAvailable was null.");
            return false;
        }
        if (paramString.length() == 0) {
            eo.b(a, "Ad space name passed to isAdAvailable was empty.");
            return false;
        }
        if (paramFlurryAdSize == null) {
            eo.b(a, "FlurryAdSize passed to isAdAvailable was null.");
            return false;
        }
        try {
            boolean bool = FlurryAdModule.getInstance().d().a(paramContext, paramString, paramFlurryAdSize);
            return bool;
        } catch (Throwable paramContext) {
            eo.a(a, "Exception while checking Ads if available: ", paramContext);
        }
        return false;
    }

    public static boolean isAdReady(String paramString) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return false;
        }
        if (paramString == null) {
            eo.b(a, "Ad space name passed to isAdReady was null.");
            return false;
        }
        if (paramString.length() == 0) {
            eo.b(a, "Ad space name passed to isAdReady was empty.");
            return false;
        }
        return FlurryAdModule.getInstance().d().a(paramString);
    }

    public static void removeAd(Context paramContext, String paramString, ViewGroup paramViewGroup) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        if (paramContext == null) {
            eo.b(a, "Context passed to removeAd was null.");
            return;
        }
        if (paramString == null) {
            eo.b(a, "Ad space name passed to removeAd was null.");
            return;
        }
        if (paramString.length() == 0) {
            eo.b(a, "Ad space name passed to removeAd was empty.");
            return;
        }
        if (paramViewGroup == null) {
            eo.b(a, "ViewGroup passed to removeAd was null.");
            return;
        }
        try {
            FlurryAdModule.getInstance().d().a(paramContext, paramString);
            return;
        } catch (Throwable paramContext) {
            eo.a(a, "Exception while removing Ad: ", paramContext);
        }
    }

    public static void setAdListener(FlurryAdListener paramFlurryAdListener) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().a(paramFlurryAdListener);
    }

    public static void setAdLogUrl(String paramString) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().f(paramString);
    }

    public static void setAdServerUrl(String paramString) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        FlurryAdModule.getInstance().e(paramString);
    }

    public static void setCustomAdNetworkHandler(ICustomAdNetworkHandler paramICustomAdNetworkHandler) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        if (paramICustomAdNetworkHandler == null) {
            eo.b(a, "ICustomAdNetworkHandler passed to setCustomAdNetworkHandler was null.");
            return;
        }
        FlurryAdModule.getInstance().a(paramICustomAdNetworkHandler);
    }

    public static void setLocation(float paramFloat1, float paramFloat2) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        dz.a().a(paramFloat1, paramFloat2);
    }

    public static void setTargetingKeywords(Map<String, String> paramMap) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
        }
        do {
            return;
            if (paramMap == null) {
                eo.b(a, "targetingKeywords Map passed to setTargetingKeywords was null.");
                return;
            }
        } while (paramMap == null);
        FlurryAdModule.getInstance().b(paramMap);
    }

    public static void setUserCookies(Map<String, String> paramMap) {
        if (Build.VERSION.SDK_INT < 10) {
            eo.b(a, "Device SDK Version older than 10");
            return;
        }
        if (paramMap == null) {
            eo.b(a, "userCookies Map passed to setUserCookies was null.");
            return;
        }
        FlurryAdModule.getInstance().a(paramMap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/android/FlurryAds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */