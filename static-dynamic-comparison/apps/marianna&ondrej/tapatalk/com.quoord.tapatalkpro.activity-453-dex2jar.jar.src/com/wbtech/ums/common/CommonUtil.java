package com.wbtech.ums.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.quoord.tapatalkpro.util.Util;
import com.wbtech.ums.objects.LatitudeAndLongitude;
import com.wbtech.ums.objects.SCell;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommonUtil {
    public static boolean checkPermissions(Context paramContext, String paramString) {
        return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
    }

    public static boolean currentNoteworkTypeIsWIFI(Context paramContext) {
        return ((ConnectivityManager) paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType() == 1;
    }

    public static String getActivityName(Context paramContext) {
        ActivityManager localActivityManager = (ActivityManager) paramContext.getSystemService("activity");
        if (checkPermissions(paramContext, "android.permission.GET_TASKS")) {
            return ((ActivityManager.RunningTaskInfo) localActivityManager.getRunningTasks(1).get(0)).topActivity.getShortClassName();
        }
        boolean bool = UmsConstants.DebugMode;
        return null;
    }

    public static String getAppKey(Context paramContext) {
        try {
            paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
            if (paramContext != null) {
                paramContext = paramContext.metaData.getString("UMS_APPKEY");
                if (paramContext != null) {
                    return paramContext.toString();
                }
                if (UmsConstants.DebugMode) {
                    Log.e("UmsAgent", "Could not read UMS_APPKEY meta-data from AndroidManifest.xml.");
                }
            }
        } catch (Exception paramContext) {
            for (; ; ) {
                if (UmsConstants.DebugMode) {
                    Log.e("UmsAgent", "Could not read UMS_APPKEY meta-data from AndroidManifest.xml.");
                    paramContext.printStackTrace();
                }
            }
        }
        return null;
    }

    public static SCell getCellInfo(Context paramContext)
            throws Exception {
        SCell localSCell = new SCell();
        paramContext = ((TelephonyManager) paramContext.getSystemService("phone")).getNetworkOperator();
        int i = Integer.parseInt(paramContext.substring(0, 3));
        int j = Integer.parseInt(paramContext.substring(3));
        localSCell.MCC = i;
        localSCell.MCCMNC = Integer.parseInt(paramContext);
        localSCell.MNC = j;
        return localSCell;
    }

    public static String getCurVersion(Context paramContext) {
        Object localObject = "";
        try {
            paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
            if (paramContext != null) {
                localObject = paramContext;
                int i = paramContext.length();
                if (i > 0) {
                }
            } else {
                return "";
            }
        } catch (Exception localException) {
            paramContext = (Context) localObject;
            if (UmsConstants.DebugMode) {
                Log.e("VersionInfo", "Exception", localException);
                paramContext = (Context) localObject;
            }
        }
        return paramContext;
    }

    public static String getDeviceID(Context paramContext) {
        if (checkPermissions(paramContext, "android.permission.READ_PHONE_STATE")) {
            paramContext = Util.getMD5(Util.getMacAddress(paramContext));
            if (paramContext != null) {
                if (UmsConstants.DebugMode) {
                    printLog("commonUtil", "deviceId:" + paramContext);
                }
                return paramContext;
            }
            if (UmsConstants.DebugMode) {
                Log.e("commonUtil", "deviceId is null");
            }
            return null;
        }
        if (UmsConstants.DebugMode) {
            Log.e("lost permissioin", "lost----->android.permission.READ_PHONE_STATE");
        }
        return "";
    }

    public static LatitudeAndLongitude getLatitudeAndLongitude(Context paramContext, boolean paramBoolean) {
        LatitudeAndLongitude localLatitudeAndLongitude = new LatitudeAndLongitude();
        if (paramBoolean) {
            paramContext = (LocationManager) paramContext.getSystemService("location");
            Iterator localIterator = paramContext.getAllProviders().iterator();
            for (; ; ) {
                if (!localIterator.hasNext()) {
                    return localLatitudeAndLongitude;
                }
                Object localObject = (String) localIterator.next();
                System.out.println((String) localObject);
                localObject = paramContext.getLastKnownLocation((String) localObject);
                if (localObject != null) {
                    localLatitudeAndLongitude.latitude = ((Location) localObject).getLatitude();
                    localLatitudeAndLongitude.longitude = ((Location) localObject).getLongitude();
                } else {
                    localLatitudeAndLongitude.latitude = "";
                    localLatitudeAndLongitude.longitude = "";
                }
            }
        }
        localLatitudeAndLongitude.latitude = "";
        localLatitudeAndLongitude.longitude = "";
        return localLatitudeAndLongitude;
    }

    public static String getNetworkType(Context paramContext) {
        int i = ((TelephonyManager) paramContext.getSystemService("phone")).getNetworkType();
        paramContext = "UNKNOWN";
        if (i == 4) {
            paramContext = "CDMA";
        }
        if (i == 2) {
            paramContext = "EDGE";
        }
        if (i == 5) {
            paramContext = "EVDO_0";
        }
        if (i == 6) {
            paramContext = "EVDO_A";
        }
        if (i == 1) {
            paramContext = "GPRS";
        }
        if (i == 8) {
            paramContext = "HSDPA";
        }
        if (i == 10) {
            paramContext = "HSPA";
        }
        if (i == 9) {
            paramContext = "HSUPA";
        }
        if (i == 3) {
            paramContext = "UMTS";
        }
        if (i == 0) {
            paramContext = "UNKNOWN";
        }
        return paramContext;
    }

    public static String getOsVersion(Context paramContext) {
        paramContext = Build.VERSION.SDK;
        if (UmsConstants.DebugMode) {
            printLog("android_osVersion", "OsVerson" + paramContext);
        }
        return paramContext;
    }

    public static String getPackageName(Context paramContext) {
        ActivityManager localActivityManager = (ActivityManager) paramContext.getSystemService("activity");
        if (checkPermissions(paramContext, "android.permission.GET_TASKS")) {
            return ((ActivityManager.RunningTaskInfo) localActivityManager.getRunningTasks(1).get(0)).topActivity.getPackageName();
        }
        boolean bool = UmsConstants.DebugMode;
        return null;
    }

    public static int getReportPolicyMode(Context paramContext) {
        String str = paramContext.getPackageName();
        return paramContext.getSharedPreferences("ums_agent_online_setting_" + str, 0).getInt("ums_local_report_policy", 0);
    }

    public static String getTime() {
        Date localDate = new Date();
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(localDate);
    }

    public static String getVersion(Context paramContext) {
        Object localObject = "";
        try {
            paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
            if (paramContext != null) {
                localObject = paramContext;
                int i = paramContext.length();
                if (i > 0) {
                }
            } else {
                return "";
            }
        } catch (Exception localException) {
            paramContext = (Context) localObject;
            if (UmsConstants.DebugMode) {
                Log.e("UmsAgent", "Exception", localException);
                paramContext = (Context) localObject;
            }
        }
        return paramContext;
    }

    public static boolean isHaveGravity(Context paramContext) {
        return (SensorManager) paramContext.getSystemService("sensor") != null;
    }

    public static boolean isNetworkAvailable(Context paramContext) {
        boolean bool = false;
        if (checkPermissions(paramContext, "android.permission.INTERNET")) {
            paramContext = ((ConnectivityManager) paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if ((paramContext != null) && (paramContext.isAvailable())) {
                bool = true;
            }
        }
        while (!UmsConstants.DebugMode) {
            do {
                return bool;
            } while (!UmsConstants.DebugMode);
            Log.e("error", "Network error");
            return false;
        }
        Log.e(" lost  permission", "lost----> android.permission.INTERNET");
        return false;
    }

    public static boolean isNetworkTypeWifi(Context paramContext) {
        boolean bool = false;
        if (checkPermissions(paramContext, "android.permission.INTERNET")) {
            paramContext = ((ConnectivityManager) paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.getTypeName().equals("WIFI"))) {
                bool = true;
            }
        }
        while (!UmsConstants.DebugMode) {
            do {
                return bool;
            } while (!UmsConstants.DebugMode);
            Log.e("error", "Network not wifi");
            return false;
        }
        Log.e(" lost  permission", "lost----> android.permission.INTERNET");
        return false;
    }

    public static boolean isWiFiActive(Context paramContext) {
        if (checkPermissions(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
            paramContext = (ConnectivityManager) paramContext.getApplicationContext().getSystemService("connectivity");
            if (paramContext != null) {
                paramContext = paramContext.getAllNetworkInfo();
                if (paramContext != null) {
                    i = 0;
                    if (i < paramContext.length) {
                        break label46;
                    }
                }
            }
        }
        label46:
        while (!UmsConstants.DebugMode) {
            for (; ; ) {
                int i;
                return false;
                if ((paramContext[i].getTypeName().equals("WIFI")) && (paramContext[i].isConnected())) {
                    return true;
                }
                i += 1;
            }
        }
        Log.e("lost permission", "lost--->android.permission.ACCESS_WIFI_STATE");
        return false;
    }

    public static void printLog(String paramString1, String paramString2) {
        if (UmsConstants.DebugMode) {
            Log.d(paramString1, paramString2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/wbtech/ums/common/CommonUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */