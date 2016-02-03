package com.inmobi.analytics;

import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.androidsdk.IMAdTracker;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

import java.util.Map;

public class InMobiAnalytics {
    public static void beginSection(String paramString) {
        beginSection(paramString, null);
    }

    public static void beginSection(String paramString, Map<String, String> paramMap) {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            return;
        }
        try {
            int i = paramString.hashCode();
            AnalyticsEventsWrapper.getInstance().beginSection(i, paramString, paramMap);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        } catch (Exception paramString) {
            Log.debug("[InMobi]-[Analytics]-4.5.1", "Please pass a valid Section Name");
        }
    }

    public static void endSection(String paramString) {
        endSection(paramString, null);
    }

    public static void endSection(String paramString, Map<String, String> paramMap) {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            return;
        }
        try {
            int i = paramString.hashCode();
            AnalyticsEventsWrapper.getInstance().endSection(i, paramString, paramMap);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        } catch (Exception paramString) {
            Log.debug("[InMobi]-[Analytics]-4.5.1", "Please pass a valid Section Name");
        }
    }

    public static void endSessionManually() {
        endSessionManually(null);
    }

    public static void endSessionManually(Map<String, String> paramMap) {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            return;
        }
        AnalyticsEventsWrapper.getInstance().endSession(paramMap);
        AnalyticsEventsWrapper.setIsEventsUser();
    }

    public static void reportCustomGoal(String paramString) {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            return;
        }
        try {
            IMAdTracker.getInstance().reportCustomGoal(paramString);
            return;
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Unable to report custom goal due to unexpected exception.", paramString);
        }
    }

    public static void setUserAttribute(String paramString1, String paramString2) {
        try {
            if (!InternalSDKUtil.isInitializedSuccessfully()) {
                return;
            }
            AnalyticsEventsWrapper.getInstance().setUserAttribute(paramString1, paramString2);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        } catch (Exception paramString1) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Unable to set user attribute unexpected exception.", paramString1);
        }
    }

    public static void startSessionManually() {
        startSessionManually(null);
    }

    public static void startSessionManually(Map<String, String> paramMap) {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            return;
        }
        AnalyticsEventsWrapper.getInstance().startSession(InMobi.getAppId(), paramMap);
        AnalyticsEventsWrapper.setIsEventsUser();
    }

    public static void tagEvent(String paramString) {
        tagEvent(paramString, null);
    }

    public static void tagEvent(String paramString, Map<String, String> paramMap) {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            return;
        }
        try {
            AnalyticsEventsWrapper.getInstance().tagEvent(paramString, paramMap);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Unable to tag event due to unexpected exception.", paramString);
        }
    }

    public static void tagTransactionManually(Intent paramIntent, Bundle paramBundle) {
        if (!InternalSDKUtil.isInitializedSuccessfully()) {
            return;
        }
        try {
            AnalyticsEventsWrapper.getInstance().tagTransactionManually(paramIntent, paramBundle);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        } catch (Exception paramIntent) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Unable to tag transaction due to unexpected exception.", paramIntent);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/analytics/InMobiAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */