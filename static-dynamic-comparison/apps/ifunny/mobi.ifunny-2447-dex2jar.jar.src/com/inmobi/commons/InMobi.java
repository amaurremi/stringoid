package com.inmobi.commons;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import com.inmobi.commons.analytics.androidsdk.IMAdTracker;
import com.inmobi.commons.analytics.androidsdk.IMAdTrackerReceiver;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.cache.LocalCache;
import com.inmobi.commons.data.AppInfo;
import com.inmobi.commons.data.DemogInfo;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.internal.ActivityRecognitionManager;
import com.inmobi.commons.internal.ApplicationFocusManager;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.uid.UID;

import java.util.Calendar;

public final class InMobi {
    public static final int EXCLUDE_FB_ID = 4;
    public static final int EXCLUDE_ODIN1 = 2;
    public static final int EXCLUDE_UM5_ID = 8;
    public static final int ID_DEVICE_NONE = 0;
    public static final int INCLUDE_DEFAULT = 1;
    private static String a = null;

    private static void a(Context paramContext, String paramString) {
        if (paramContext == null) {
        }
        try {
            Log.debug("[InMobi]-4.5.1", "Application Context NULL");
            Log.debug("[InMobi]-4.5.1", "context cannot be null");
            return;
        } catch (Exception paramContext) {
            Log.internal("[InMobi]-4.5.1", "Exception in initialize", paramContext);
            return;
        }
        Context localContext = paramContext.getApplicationContext();
        InternalSDKUtil.setContext(localContext);
        if ((paramString == null) || ("".equals(paramString.trim()))) {
            Log.debug("[InMobi]-4.5.1", "appId cannot be blank");
            return;
        }
        if (InternalSDKUtil.isInitializedSuccessfully()) {
            ThinICE.start(paramContext);
            return;
        }
        a = paramString.trim();
        InternalSDKUtil.getUserAgent();
        LocationInfo.collectLocationInfo();
        AppInfo.updateAppInfo();
        DeviceInfo.updateDeviceInfo();
        UID.getInstance().init();
        String str = FileOperations.getPreferences(paramContext.getApplicationContext(), "impref", "version");
        if ((str == null) || (!str.equals(getVersion()))) {
            FileOperations.setPreferences(paramContext.getApplicationContext(), "impref", "version", getVersion());
            LocalCache.reset();
        }
        ThinICE.start(paramContext);
        Log.debug("[InMobi]-4.5.1", "InMobi init successful");
        IMAdTracker.getInstance().init(localContext, paramString);
        IMAdTracker.getInstance().reportAppDownloadGoal();
        ApplicationFocusManager.init(paramContext);
        ApplicationFocusManager.addFocusChangedListener(new InMobi.a());
        AnalyticsEventsWrapper.getInstance().startSession(a, null);
        ActivityRecognitionManager.init(paramContext.getApplicationContext());
        paramString = new IntentFilter();
        paramString.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        paramString.addAction("com.android.vending.INSTALL_REFERRER");
        paramString.addAction("com.inmobi.share.id");
        paramContext.getApplicationContext().registerReceiver(new IMAdTrackerReceiver(), paramString);
    }

    public static void addIDType(IMIDType paramIMIDType, String paramString) {
        DemogInfo.addIDType(paramIMIDType, paramString);
    }

    public static String getAppId() {
        return a;
    }

    public static String getVersion() {
        return "4.5.1";
    }

    public static void initialize(Activity paramActivity, String paramString) {
        a(paramActivity, paramString);
    }

    public static void initialize(Context paramContext, String paramString) {
        a(paramContext, paramString);
    }

    public static void removeIDType(IMIDType paramIMIDType) {
        DemogInfo.removeIDType(paramIMIDType);
    }

    public static void setAge(int paramInt) {
        DemogInfo.setAge(Integer.valueOf(paramInt));
    }

    public static void setAreaCode(String paramString) {
        if ((paramString != null) && (!"".equals(paramString.trim()))) {
            DemogInfo.setAreaCode(paramString);
            return;
        }
        Log.debug("[InMobi]-4.5.1", "Area code cannot be null");
    }

    public static void setCurrentLocation(Location paramLocation) {
        if (paramLocation != null) {
            DemogInfo.setCurrentLocation(paramLocation);
            return;
        }
        Log.debug("[InMobi]-4.5.1", "Location cannot be null");
    }

    public static void setDateOfBirth(Calendar paramCalendar) {
        if (paramCalendar != null) {
            DemogInfo.setDateOfBirth(paramCalendar);
            return;
        }
        Log.debug("[InMobi]-4.5.1", "Date Of Birth cannot be null");
    }

    public static void setDeviceIDMask(int paramInt) {
        DemogInfo.setDeviceIDMask(paramInt);
        UID.getInstance().setPublisherDeviceIdMaskMap(paramInt);
    }

    public static void setEducation(EducationType paramEducationType) {
        if (paramEducationType != null) {
            DemogInfo.setEducation(paramEducationType);
        }
    }

    public static void setEthnicity(EthnicityType paramEthnicityType) {
        if (paramEthnicityType != null) {
            DemogInfo.setEthnicity(paramEthnicityType);
        }
    }

    public static void setGender(GenderType paramGenderType) {
        if (paramGenderType != null) {
            DemogInfo.setGender(paramGenderType);
        }
    }

    public static void setHasChildren(HasChildren paramHasChildren) {
        if (paramHasChildren != null) {
            DemogInfo.setHasChildren(paramHasChildren);
        }
    }

    public static void setIncome(int paramInt) {
        DemogInfo.setIncome(Integer.valueOf(paramInt));
    }

    public static void setInterests(String paramString) {
        if ((paramString != null) && (!"".equals(paramString.trim()))) {
            DemogInfo.setInterests(paramString);
            return;
        }
        Log.debug("[InMobi]-4.5.1", "Interests cannot be null");
    }

    public static void setLanguage(String paramString) {
        if ((paramString != null) && (!"".equals(paramString.trim()))) {
            DemogInfo.setLanguage(paramString);
            return;
        }
        Log.debug("[InMobi]-4.5.1", "Language cannot be null");
    }

    public static void setLocationWithCityStateCountry(String paramString1, String paramString2, String paramString3) {
        DemogInfo.setLocationWithCityStateCountry(paramString1, paramString2, paramString3);
    }

    public static void setLogLevel(InMobi.LOG_LEVEL paramLOG_LEVEL) {
        if (paramLOG_LEVEL == InMobi.LOG_LEVEL.NONE) {
            Log.setInternalLogLevel(Log.INTERNAL_LOG_LEVEL.NONE);
            return;
        }
        if (paramLOG_LEVEL == InMobi.LOG_LEVEL.DEBUG) {
            Log.setInternalLogLevel(Log.INTERNAL_LOG_LEVEL.DEBUG);
            return;
        }
        if (paramLOG_LEVEL == InMobi.LOG_LEVEL.VERBOSE) {
            Log.setInternalLogLevel(Log.INTERNAL_LOG_LEVEL.VERBOSE);
            return;
        }
        Log.setInternalLogLevel(Log.INTERNAL_LOG_LEVEL.INTERNAL);
    }

    public static void setMaritalStatus(MaritalStatus paramMaritalStatus) {
        if (paramMaritalStatus != null) {
            DemogInfo.setMaritalStatus(paramMaritalStatus);
        }
    }

    public static void setPostalCode(String paramString) {
        if ((paramString != null) && (!"".equals(paramString.trim()))) {
            DemogInfo.setPostalCode(paramString);
            return;
        }
        Log.debug("[InMobi]-4.5.1", "Postal Code cannot be null");
    }

    public static void setSexualOrientation(SexualOrientation paramSexualOrientation) {
        if (paramSexualOrientation != null) {
            DemogInfo.setSexualOrientation(paramSexualOrientation);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/InMobi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */