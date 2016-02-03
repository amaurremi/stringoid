package com.everimaging.fotorsdk.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.util.ArrayList;
import java.util.List;

public class PackageManagerUtils {
    private static final String TAG = PackageManagerUtils.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private static String mApiKey;
    private static ApplicationInfo mApplicationInfo;
    private static PackageInfo mPackageInfo;

    public static List<ApplicationInfo> fetchInstalledApplications(Context paramContext) {
        try {
            paramContext = paramContext.getPackageManager().getInstalledApplications(0);
            return paramContext;
        } catch (Exception paramContext) {
            for (; ; ) {
                logger.e(new Object[]{"fetchInstalledApplications errors:" + paramContext.getMessage()});
                paramContext = new ArrayList();
            }
        } finally {
        }
    }

    public static String getApikey(Context paramContext) {
        if (mApiKey == null) {
            paramContext = getApplicationInfo(paramContext, 128);
            if (paramContext != null) {
                paramContext = paramContext.metaData;
                if (paramContext != null) {
                    mApiKey = paramContext.getString("FOTOR_API_KEY");
                }
            }
        }
        logger.b(new Object[]{"getApiKey:" + mApiKey});
        if (TextUtils.isEmpty(mApiKey)) {
            Log.e(TAG, "your lose the fotorsdk api key ,please check your manifest");
            mApiKey = "b1bcf06f5f65b1923bb7474db14d39ff8f1c7548";
        }
        return mApiKey;
    }

    public static ApplicationInfo getApplicationInfo(Context paramContext) {
        PackageManager localPackageManager;
        if (mApplicationInfo == null) {
            localPackageManager = paramContext.getPackageManager();
        }
        try {
            mApplicationInfo = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
            return mApplicationInfo;
        } catch (Exception paramContext) {
            for (; ; ) {
                paramContext.printStackTrace();
            }
        }
    }

    public static ApplicationInfo getApplicationInfo(Context paramContext, int paramInt) {
        return getApplicationInfo(paramContext, paramContext.getPackageName(), paramInt);
    }

    public static ApplicationInfo getApplicationInfo(Context paramContext, String paramString, int paramInt) {
        try {
            paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, paramInt);
            return paramContext;
        } catch (PackageManager.NameNotFoundException paramContext) {
            paramContext.printStackTrace();
        }
        return null;
    }

    public static Resources getApplicationResource(Context paramContext, String paramString) {
        try {
            paramContext = paramContext.getPackageManager().getResourcesForApplication(paramString);
            return paramContext;
        } catch (Exception paramContext) {
        }
        return null;
    }

    public static PackageInfo getPackageInfo(Context paramContext) {
        if (mPackageInfo == null) {
            mPackageInfo = getPackageInfo(paramContext, 0);
        }
        return mPackageInfo;
    }

    public static PackageInfo getPackageInfo(Context paramContext, int paramInt) {
        return getPackageInfo(paramContext, paramContext.getPackageName(), paramInt);
    }

    public static PackageInfo getPackageInfo(Context paramContext, String paramString, int paramInt) {
        try {
            paramContext = paramContext.getPackageManager().getPackageInfo(paramString, paramInt);
            return paramContext;
        } catch (PackageManager.NameNotFoundException paramContext) {
            logger.d(new Object[]{"NameNotFoundException:->" + paramString});
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/PackageManagerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */