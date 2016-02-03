package com.facebook.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.util.Log;
import com.facebook.ads.internal.StringUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class AdSettings {
    private static final String DEVICE_ID_HASH_PREFS_KEY = "deviceIdHash";
    private static final String PREFS_NAME = "FBAdPrefs";
    public static final String TAG = AdSettings.class.getSimpleName();
    private static boolean childDirected;
    private static String deviceIdHash;
    private static final Collection<String> emulatorProducts;
    static volatile boolean testDeviceNoticeDisplayed = false;
    private static final Collection<String> testDevices;
    private static String urlPrefix = null;

    static {
        childDirected = false;
        deviceIdHash = null;
        testDevices = new HashSet();
        emulatorProducts = new HashSet();
        emulatorProducts.add("sdk");
        emulatorProducts.add("google_sdk");
        emulatorProducts.add("vbox86p");
        emulatorProducts.add("vbox86tp");
    }

    public static void addTestDevice(String paramString) {
        testDevices.add(paramString);
    }

    public static void addTestDevices(Collection<String> paramCollection) {
        testDevices.addAll(paramCollection);
    }

    public static void clearTestDevices() {
        testDevices.clear();
    }

    public static String getUrlPrefix() {
        return urlPrefix;
    }

    public static boolean isChildDirected() {
        return childDirected;
    }

    public static boolean isTestMode(Context paramContext) {
        if (emulatorProducts.contains(Build.PRODUCT)) {
        }
        do {
            return true;
            if (deviceIdHash == null) {
                paramContext = paramContext.getSharedPreferences("FBAdPrefs", 0);
                deviceIdHash = paramContext.getString("deviceIdHash", null);
                if (StringUtils.isNullOrEmpty(deviceIdHash)) {
                    deviceIdHash = StringUtils.md5(UUID.randomUUID().toString());
                    paramContext.edit().putString("deviceIdHash", deviceIdHash).commit();
                }
            }
        } while (testDevices.contains(deviceIdHash));
        printTestDeviceNotice(deviceIdHash);
        return false;
    }

    private static void printTestDeviceNotice(String paramString) {
        if (testDeviceNoticeDisplayed) {
            return;
        }
        testDeviceNoticeDisplayed = true;
        Log.d(TAG, "Test mode device hash: " + paramString);
        Log.d(TAG, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + paramString + "\");");
    }

    public static void setIsChildDirected(boolean paramBoolean) {
        childDirected = paramBoolean;
    }

    public static void setUrlPrefix(String paramString) {
        urlPrefix = paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/AdSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */