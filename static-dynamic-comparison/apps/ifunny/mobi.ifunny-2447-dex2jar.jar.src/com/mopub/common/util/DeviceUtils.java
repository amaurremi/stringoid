package com.mopub.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StatFs;
import android.provider.Settings.Secure;
import com.mopub.common.logging.MoPubLog;

import java.io.File;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DeviceUtils {
    public static long diskCacheSizeBytes(File paramFile) {
        try {
            paramFile = new StatFs(paramFile.getAbsolutePath());
            l = paramFile.getBlockCount();
            l = paramFile.getBlockSize() * l / 50L;
            return Math.max(Math.min(l, 104857600L), 31457280L);
        } catch (IllegalArgumentException paramFile) {
            for (; ; ) {
                MoPubLog.d("Unable to calculate 2% of available disk space, defaulting to minimum");
                long l = 31457280L;
            }
        }
    }

    public static String getHashedUdid(Context paramContext) {
        if (paramContext == null) {
            return null;
        }
        return Utils.sha1(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
    }

    public static String getIpAddress(DeviceUtils.IP paramIP) {
        Object localObject;
        do {
            do {
                Iterator localIterator1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                Iterator localIterator2;
                while (!localIterator2.hasNext()) {
                    if (!localIterator1.hasNext()) {
                        break;
                    }
                    localIterator2 = Collections.list(((NetworkInterface) localIterator1.next()).getInetAddresses()).iterator();
                }
                localObject = (InetAddress) localIterator2.next();
            } while (((InetAddress) localObject).isLoopbackAddress());
            localObject = ((InetAddress) localObject).getHostAddress().toUpperCase();
        } while (!DeviceUtils.IP.a(paramIP, (String) localObject));
        return DeviceUtils.IP.b(paramIP, (String) localObject);
        return null;
    }

    public static String getUserAgent() {
        return System.getProperty("http.agent");
    }

    public static boolean isNetworkAvailable(Context paramContext) {
        if (paramContext == null) {
            return false;
        }
        if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            return false;
        }
        if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
            return true;
        }
        try {
            boolean bool = ((ConnectivityManager) paramContext.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
            return bool;
        } catch (NullPointerException paramContext) {
        }
        return false;
    }

    public static int memoryCacheSizeBytes(Context paramContext) {
        ActivityManager localActivityManager = (ActivityManager) paramContext.getSystemService("activity");
        l1 = localActivityManager.getMemoryClass();
        l2 = l1;
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB)) {
        }
        try {
            int i = ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null);
            if (!Utils.bitMaskContainsFlag(paramContext.getApplicationInfo().flags, i)) {
                break label120;
            }
            i = ((Integer) new Reflection.MethodBuilder(localActivityManager, "getLargeMemoryClass").execute()).intValue();
            l1 = i;
        } catch (Exception paramContext) {
            for (; ; ) {
                MoPubLog.d("Unable to reflectively determine large heap size on Honeycomb and above.");
                l2 = l1;
            }
        }
        l2 = l1;
        return (int) Math.min(31457280L, l2 / 8L * 1024L * 1024L);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/DeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */