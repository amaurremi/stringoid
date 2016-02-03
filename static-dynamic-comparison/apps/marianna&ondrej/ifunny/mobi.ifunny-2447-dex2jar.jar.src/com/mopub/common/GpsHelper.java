package com.mopub.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;

public class GpsHelper {
    public static final String ADVERTISING_ID_KEY = "advertisingId";
    public static final int GOOGLE_PLAY_SUCCESS_CODE = 0;
    public static final String IS_LIMIT_AD_TRACKING_ENABLED_KEY = "isLimitAdTrackingEnabled";
    private static String a = "com.google.android.gms.common.GooglePlayServicesUtil";
    private static String b = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    static String a(Object paramObject, String paramString) {
        try {
            paramObject = (String) MethodBuilderFactory.create(paramObject, "getId").execute();
            return (String) paramObject;
        } catch (Exception paramObject) {
        }
        return paramString;
    }

    static void a(Context paramContext, Object paramObject) {
        String str = a(paramObject, null);
        boolean bool = a(paramObject, false);
        SharedPreferencesHelper.getSharedPreferences(paramContext).edit().putString("advertisingId", str).putBoolean("isLimitAdTrackingEnabled", bool).commit();
    }

    static boolean a(Context paramContext) {
        try {
            paramContext = MethodBuilderFactory.create(null, "isGooglePlayServicesAvailable").setStatic(Class.forName(a)).addParam(Context.class, paramContext).execute();
            if (paramContext != null) {
                int i = ((Integer) paramContext).intValue();
                if (i == 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception paramContext) {
        }
        return false;
    }

    static boolean a(Object paramObject, boolean paramBoolean) {
        try {
            paramObject = (Boolean) MethodBuilderFactory.create(paramObject, "isLimitAdTrackingEnabled").execute();
            boolean bool = paramBoolean;
            if (paramObject != null) {
                bool = ((Boolean) paramObject).booleanValue();
            }
            return bool;
        } catch (Exception paramObject) {
        }
        return paramBoolean;
    }

    public static void asyncFetchAdvertisingInfo(Context paramContext) {
        asyncFetchAdvertisingInfo(paramContext, null);
    }

    public static void asyncFetchAdvertisingInfo(Context paramContext, GpsHelper.GpsHelperListener paramGpsHelperListener) {
        if (!Reflection.classFound(b)) {
            if (paramGpsHelperListener != null) {
                paramGpsHelperListener.onFetchAdInfoCompleted();
            }
        }
        do {
            return;
            try {
                AsyncTasks.safeExecuteOnExecutor(new j(paramContext, paramGpsHelperListener), new Void[0]);
                return;
            } catch (Exception paramContext) {
                MoPubLog.d("Error executing FetchAdvertisingInfoTask", paramContext);
            }
        } while (paramGpsHelperListener == null);
        paramGpsHelperListener.onFetchAdInfoCompleted();
    }

    public static void asyncFetchAdvertisingInfoIfNotCached(Context paramContext, GpsHelper.GpsHelperListener paramGpsHelperListener) {
        if ((a(paramContext)) && (!c(paramContext))) {
            asyncFetchAdvertisingInfo(paramContext, paramGpsHelperListener);
            return;
        }
        paramGpsHelperListener.onFetchAdInfoCompleted();
    }

    static String b(Context paramContext) {
        String str = null;
        if (a(paramContext)) {
            str = SharedPreferencesHelper.getSharedPreferences(paramContext).getString("advertisingId", null);
        }
        return str;
    }

    static boolean c(Context paramContext) {
        paramContext = SharedPreferencesHelper.getSharedPreferences(paramContext);
        return (paramContext.contains("advertisingId")) && (paramContext.contains("isLimitAdTrackingEnabled"));
    }

    public static boolean isLimitAdTrackingEnabled(Context paramContext) {
        boolean bool = false;
        if (a(paramContext)) {
            bool = SharedPreferencesHelper.getSharedPreferences(paramContext).getBoolean("isLimitAdTrackingEnabled", false);
        }
        return bool;
    }

    @Deprecated
    public static void setClassNamesForTesting() {
        a = "java.lang.Class";
        b = "java.lang.Class";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/GpsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */