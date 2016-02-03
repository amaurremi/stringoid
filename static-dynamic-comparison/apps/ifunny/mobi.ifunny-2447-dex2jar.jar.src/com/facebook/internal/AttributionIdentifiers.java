package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookException;

import java.lang.reflect.Method;

public class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000L;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    private static AttributionIdentifiers getAndroidId(Context paramContext) {
        AttributionIdentifiers localAttributionIdentifiers = new AttributionIdentifiers();
        for (; ; ) {
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    throw new FacebookException("getAndroidId cannot be called on the main thread.");
                }
            } catch (Exception paramContext) {
                Utility.logd("android_id", paramContext);
                return localAttributionIdentifiers;
            }
            Object localObject = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[]{Context.class});
            if (localObject == null) {
                return localAttributionIdentifiers;
            }
            localObject = Utility.invokeMethodQuietly(null, (Method) localObject, new Object[]{paramContext});
            if ((!(localObject instanceof Integer)) || (((Integer) localObject).intValue() != 0)) {
                break;
            }
            localObject = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class});
            if (localObject == null) {
                return localAttributionIdentifiers;
            }
            paramContext = Utility.invokeMethodQuietly(null, (Method) localObject, new Object[]{paramContext});
            if (paramContext == null) {
                return localAttributionIdentifiers;
            }
            localObject = Utility.getMethodQuietly(paramContext.getClass(), "getId", new Class[0]);
            Method localMethod = Utility.getMethodQuietly(paramContext.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if ((localObject == null) || (localMethod == null)) {
                return localAttributionIdentifiers;
            }
            localAttributionIdentifiers.androidAdvertiserId = ((String) Utility.invokeMethodQuietly(paramContext, (Method) localObject, new Object[0]));
            localAttributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(paramContext, localMethod, new Object[0])).booleanValue();
        }
        return localAttributionIdentifiers;
        return localAttributionIdentifiers;
    }

    public static AttributionIdentifiers getAttributionIdentifiers(Context paramContext) {
        if ((recentlyFetchedIdentifiers != null) && (System.currentTimeMillis() - recentlyFetchedIdentifiers.fetchTime < 3600000L)) {
            return recentlyFetchedIdentifiers;
        }
        AttributionIdentifiers localAttributionIdentifiers = getAndroidId(paramContext);
        try {
            paramContext = paramContext.getContentResolver().query(ATTRIBUTION_ID_CONTENT_URI, new String[]{"aid", "androidid", "limit_tracking"}, null, null, null);
            if ((paramContext != null) && (paramContext.moveToFirst())) {
                int i = paramContext.getColumnIndex("aid");
                int j = paramContext.getColumnIndex("androidid");
                int k = paramContext.getColumnIndex("limit_tracking");
                localAttributionIdentifiers.attributionId = paramContext.getString(i);
                if ((j > 0) && (k > 0) && (localAttributionIdentifiers.getAndroidAdvertiserId() == null)) {
                    localAttributionIdentifiers.androidAdvertiserId = paramContext.getString(j);
                    localAttributionIdentifiers.limitTracking = Boolean.parseBoolean(paramContext.getString(k));
                }
                paramContext.close();
                localAttributionIdentifiers.fetchTime = System.currentTimeMillis();
                recentlyFetchedIdentifiers = localAttributionIdentifiers;
                return localAttributionIdentifiers;
            }
        } catch (Exception paramContext) {
            Log.d(TAG, "Caught unexpected exception in getAttributionId(): " + paramContext.toString());
            return null;
        }
        return null;
    }

    public String getAndroidAdvertiserId() {
        return this.androidAdvertiserId;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/AttributionIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */