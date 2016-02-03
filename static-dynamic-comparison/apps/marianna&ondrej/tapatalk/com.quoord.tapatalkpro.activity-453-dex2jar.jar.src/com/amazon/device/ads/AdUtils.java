package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.util.HashSet;

class AdUtils {
    public static final String LOG_TAG = AdUtils.class.getSimpleName();
    public static final String REQUIRED_ACTIVITY = "com.amazon.device.ads.AdActivity";
    private static final HashSet<String> requiredActivities = new HashSet();

    static {
        requiredActivities.add("com.amazon.device.ads.AdActivity");
    }

    public static boolean checkDefinedActivities(Context paramContext) {
        boolean bool = true;
        HashSet localHashSet = new HashSet();
        try {
            if (Utils.isAtLeastAndroidAPI(8)) {
                String str = AndroidTargetUtils.getPackageCodePath(paramContext);
                paramContext = paramContext.getPackageManager().getPackageArchiveInfo(str, 1).activities;
                int j = paramContext.length;
                int i = 0;
                while (i < j) {
                    localHashSet.add(paramContext[i].name);
                    i += 1;
                }
                bool = localHashSet.containsAll(requiredActivities);
            }
            return bool;
        } catch (Exception paramContext) {
        }
        return true;
    }

    public static String encloseHtml(String paramString, boolean paramBoolean) {
        Object localObject = paramString;
        if (paramString != null) {
            String str = paramString;
            if (paramString.indexOf("<html>") == -1) {
                str = "<html>" + paramString + "</html>";
            }
            localObject = str;
            if (paramBoolean) {
                localObject = str;
                if (str.indexOf("<!DOCTYPE html>") == -1) {
                    localObject = "<!DOCTYPE html>" + str;
                }
            }
        }
        return (String) localObject;
    }

    public static double getViewportInitialScale(double paramDouble) {
        if (Utils.isAtLeastAndroidAPI(19)) {
            paramDouble = 1.0D;
        }
        return paramDouble;
    }

    public static boolean launchActivityForIntentLink(String paramString, Context paramContext) {
        String str;
        if (paramString != null) {
            str = paramString;
            if (!paramString.equals("")) {
            }
        } else {
            str = "about:blank";
        }
        Log.d(LOG_TAG, "Launch Intent: %s", new Object[]{str});
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(str));
        paramString.setFlags(268435456);
        try {
            paramContext.startActivity(paramString);
            return true;
        } catch (ActivityNotFoundException paramContext) {
            paramContext = paramString.getAction();
            str = LOG_TAG;
            if (!paramContext.startsWith("market://")) {
            }
        }
        for (paramString = "market"; ; paramString = "intent") {
            Log.w(str, "Could not handle %s action: %s", new Object[]{paramString, paramContext});
            return false;
        }
    }

    public static void setConnectionMetrics(AdData paramAdData) {
        Object localObject = paramAdData.getConnectionType();
        if ("Wifi".equals(localObject)) {
            paramAdData.getMetricsCollector().incrementMetric(Metrics.MetricType.WIFI_PRESENT);
        }
        for (; ; ) {
            localObject = InternalAdRegistration.getInstance().getDeviceInfo();
            if (((DeviceInfo) localObject).getCarrier() != null) {
                paramAdData.getMetricsCollector().setMetricString(Metrics.MetricType.CARRIER_NAME, ((DeviceInfo) localObject).getCarrier());
            }
            return;
            paramAdData.getMetricsCollector().setMetricString(Metrics.MetricType.CONNECTION_TYPE, (String) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */