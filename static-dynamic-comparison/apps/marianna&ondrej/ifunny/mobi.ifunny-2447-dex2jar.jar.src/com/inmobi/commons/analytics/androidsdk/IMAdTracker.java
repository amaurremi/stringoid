package com.inmobi.commons.analytics.androidsdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public final class IMAdTracker {
    private static IMAdTracker a;

    private boolean a(String paramString) {
        String str;
        try {
            str = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "mk-siteid");
            if ((InternalSDKUtil.getContext() == null) || (str == null) || (str.trim().equals(""))) {
                Log.debug("[InMobi]-[AdTracker]-4.5.1", "Please call init() with valid context and app id");
                return false;
            }
            if ((paramString == null) || ("".equals(paramString.trim()))) {
                Log.debug("[InMobi]-[AdTracker]-4.5.1", "Please pass a valid GoalName");
                return false;
            }
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Cannot report goal", paramString);
            return false;
        }
        boolean bool = AdTrackerUtils.checkDownloadGoalUploaded();
        if (("download".equals(paramString)) && (true == bool)) {
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "Download goal already uploaded");
            return false;
        }
        AdTrackerNetworkInterface.init();
        if ("download".equals(paramString)) {
            if (!AdTrackerUtils.checkDownloadGoalAdded()) {
                FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "insertStatus", true);
                Log.debug("[InMobi]-[AdTracker]-4.5.1", "Goal Queued " + paramString);
                AdTrackerNetworkInterface.getGoalList().addGoal(paramString, 1, 0L, 0, false);
            }
        }
        for (; ; ) {
            AdTrackerNetworkInterface.reportToServer(str);
            return true;
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "Goal Queued " + paramString);
            AdTrackerNetworkInterface.getGoalList().addGoal(paramString, 1, 0L, 0, false);
        }
    }

    public static IMAdTracker getInstance() {
        try {
            if (a == null) {
                a = new IMAdTracker();
            }
            IMAdTracker localIMAdTracker = a;
            return localIMAdTracker;
        } finally {
        }
    }

    public void init(Context paramContext, String paramString) {
        if (paramContext == null) {
        }
        try {
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "Application Context NULL");
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "context cannot be null");
            return;
        } catch (Exception paramContext) {
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Failed to init", paramContext);
            return;
        }
        if (paramString == null) {
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "APP ID Cannot be NULL");
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "appId cannot be null");
            return;
        }
        if (paramString.trim().equals("")) {
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "appId cannot be blank");
            return;
        }
        Log.debug("[InMobi]-[AdTracker]-4.5.1", "IMAdtracker init successfull");
        FileOperations.setPreferences(paramContext, "IMAdTrackerStatusUpload", "mk-siteid", paramString);
        if ((!AdTrackerUtils.isPermissionGranted("android.permission.INTERNET")) || (!AdTrackerUtils.isPermissionGranted("android.permission.ACCESS_NETWORK_STATE"))) {
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "Add android.permission.INTERNET and android.permission.ACCESS_NETWORK_STATE permission in Android manifest");
            return;
        }
        if ((Build.VERSION.SDK_INT < 17) && (!AdTrackerUtils.isPermissionGranted("android.permission.READ_LOGS"))) {
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "Add android.permission.READ_LOGS permission in Android Manifest");
        }
        if (0L == FileOperations.getLongPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "t1")) {
            FileOperations.setPreferences(paramContext.getApplicationContext(), "IMAdTrackerStatusUpload", "t1", System.currentTimeMillis());
        }
    }

    public void reportAppDownloadGoal() {
        a("download");
    }

    public void reportCustomGoal(String paramString) {
        if ("download".equals(paramString)) {
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "Download Goal should be reported using reportAppDownloadGoal()..");
            return;
        }
        a(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/androidsdk/IMAdTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */