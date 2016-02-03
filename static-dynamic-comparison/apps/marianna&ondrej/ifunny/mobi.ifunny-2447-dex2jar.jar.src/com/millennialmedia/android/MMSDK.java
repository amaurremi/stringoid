package com.millennialmedia.android;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.a;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.f;
import com.google.android.gms.common.g;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import org.apache.http.conn.util.InetAddressUtils;

public final class MMSDK {
    public static final String DEFAULT_APID = "28911";
    public static final String DEFAULT_BANNER_APID = "28913";
    public static final String DEFAULT_RECT_APID = "28914";
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_ERROR = 0;
    public static final int LOG_LEVEL_INFO = 2;
    @Deprecated
    public static final int LOG_LEVEL_INTERNAL = 4;
    @Deprecated
    public static final int LOG_LEVEL_PRIVATE_VERBOSE = 5;
    public static final int LOG_LEVEL_VERBOSE = 3;
    public static final String SDKLOG = "MMSDK";
    public static final String VERSION = "5.3.0-c3980670.a";
    static int a;
    @Deprecated
    static boolean b = false;
    static String c;
    static Handler d;
    static String e;
    private static boolean f;
    private static int g = 1897808289;
    private static String h;
    private static boolean i;

    static {
        c = ",";
        d = new Handler(Looper.getMainLooper());
        h = null;
        i = false;
        try {
            System.loadLibrary("nmsp_speex");
            i = true;
            return;
        } catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
        }
    }

    private static AlertDialog a(Context paramContext, String paramString) {
        paramContext = new AlertDialog.Builder(paramContext).create();
        paramContext.setTitle("Whoops!");
        paramContext.setMessage(String.format("The developer has forgot to declare the %s in the manifest file. Please reach out to the developer to remove this error.", new Object[]{paramString}));
        paramContext.setButton(-3, "OK", new MMSDK .1 ());
        paramContext.show();
        return paramContext;
    }

    static String a(a parama) {
        if (parama == null) {
            return null;
        }
        return parama.a();
    }

    static String a(byte[] paramArrayOfByte) {
        StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
        int j = 0;
        while (j < paramArrayOfByte.length) {
            localStringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(paramArrayOfByte[j])}));
            j += 1;
        }
        return localStringBuilder.toString();
    }

    static void a(Context paramContext, Map<String, String> paramMap) {
        String str1 = null;
        MMLog.b("MMSDK", "executing getIDThread");
        paramMap.put("density", x(paramContext));
        paramMap.put("hpx", p(paramContext));
        paramMap.put("wpx", o(paramContext));
        paramMap.put("sk", y(paramContext));
        paramMap.put("mic", Boolean.toString(q(paramContext)));
        String str2 = "true";
        String str3;
        Object localObject1;
        Object localObject3;
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0) {
            a locala = n(paramContext);
            if (locala != null) {
                str3 = a(locala);
                localObject1 = str2;
                localObject3 = str3;
                if (str3 != null) {
                    localObject1 = str2;
                    localObject3 = str3;
                    if (locala.b()) {
                        localObject1 = "false";
                        localObject3 = str3;
                    }
                }
            }
        }
        for (; ; ) {
            if (localObject3 != null) {
                paramMap.put("aaid", localObject3);
                paramMap.put("ate", localObject1);
            }
            for (; ; ) {
                if (h(paramContext)) {
                    paramMap.put("cachedvideo", "true");
                    if (Build.MODEL != null) {
                        paramMap.put("dm", Build.MODEL);
                    }
                    if (Build.VERSION.RELEASE != null) {
                        paramMap.put("dv", "Android" + Build.VERSION.RELEASE);
                    }
                    paramMap.put("sdkversion", "5.3.0-c3980670.a");
                    paramMap.put("mcc", i(paramContext));
                    paramMap.put("mnc", j(paramContext));
                    localObject1 = m(paramContext);
                    if (!TextUtils.isEmpty((CharSequence) localObject1)) {
                        paramMap.put("cn", localObject1);
                    }
                    localObject1 = Locale.getDefault();
                    if (localObject1 != null) {
                        paramMap.put("language", ((Locale) localObject1).getLanguage());
                        paramMap.put("country", ((Locale) localObject1).getCountry());
                    }
                }
                try {
                    localObject1 = paramContext.getPackageName();
                    paramMap.put("pkid", localObject1);
                    localObject3 = paramContext.getPackageManager();
                    paramMap.put("pknm", ((PackageManager) localObject3).getApplicationLabel(((PackageManager) localObject3).getApplicationInfo((String) localObject1, 0)).toString());
                    localObject1 = HandShake.a(paramContext).b(paramContext);
                    if (localObject1 != null) {
                        paramMap.put("appsids", localObject1);
                    }
                    localObject1 = AdCache.a(paramContext);
                    if (localObject1 != null) {
                        paramMap.put("vid", localObject1);
                    }
                    try {
                        str2 = c(paramContext);
                        if (!AdCache.i(paramContext)) {
                            break label715;
                        }
                        localObject1 = new StatFs(AdCache.f(paramContext).getAbsolutePath());
                        str3 = Long.toString(((StatFs) localObject1).getAvailableBlocks() * ((StatFs) localObject1).getBlockSize());
                        localObject3 = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                        if (localObject3 == null) {
                            break label752;
                        }
                        if (((Intent) localObject3).getIntExtra("plugged", 0) != 0) {
                            break label746;
                        }
                        localObject1 = "false";
                    } catch (Exception paramContext) {
                        for (; ; ) {
                            float f1;
                            MMLog.a("MMSDK", "Exception inserting common parameters: ", paramContext);
                            continue;
                            localObject2 = "true";
                            continue;
                            localObject2 = null;
                            localObject3 = str1;
                        }
                    }
                    f1 = 100.0F / ((Intent) localObject3).getIntExtra("scale", 100);
                    str1 = Integer.toString((int) (((Intent) localObject3).getIntExtra("level", 0) * f1));
                    localObject3 = localObject1;
                    localObject1 = str1;
                    if ((localObject1 != null) && (((String) localObject1).length() > 0)) {
                        paramMap.put("bl", localObject1);
                    }
                    if ((localObject3 != null) && (((String) localObject3).length() > 0)) {
                        paramMap.put("plugged", localObject3);
                    }
                    if (str3.length() > 0) {
                        paramMap.put("space", str3);
                    }
                    if (str2 != null) {
                        paramMap.put("conn", str2);
                    }
                    paramContext = URLEncoder.encode(b(paramContext), "UTF-8");
                    if (!TextUtils.isEmpty(paramContext)) {
                        paramMap.put("pip", paramContext);
                    }
                    MMRequest.b(paramMap);
                    return;
                    localObject1 = d(paramContext);
                    if (localObject1 != null) {
                        paramMap.put("mmdid", localObject1);
                        continue;
                        paramMap.put("cachedvideo", "false");
                    }
                } catch (Exception localException) {
                    for (; ; ) {
                        MMLog.a("MMSDK", "Can't insert package information", localException);
                        continue;
                        label715:
                        localObject2 = new StatFs(paramContext.getFilesDir().getPath());
                    }
                }
            }
            label746:
            label752:
            localObject3 = null;
            Object localObject2 = str2;
        }
    }

    static void a(MMAdImpl paramMMAdImpl) {
        if (paramMMAdImpl == null) {
        }
        Context localContext;
        do {
            return;
            localContext = paramMMAdImpl.j();
            MMLog.c("MMSDK", String.format("MMAd External ID: %d", new Object[]{Integer.valueOf(paramMMAdImpl.e())}));
            MMLog.c("MMSDK", String.format("MMAd Internal ID: %d", new Object[]{Long.valueOf(paramMMAdImpl.h)}));
            MMLog.c("MMSDK", String.format("APID: %s", new Object[]{paramMMAdImpl.e}));
            if (!AdCache.i(localContext)) {
                break;
            }
            paramMMAdImpl = "";
            MMLog.c("MMSDK", String.format("SD card is %savailable.", new Object[]{paramMMAdImpl}));
        } while (localContext == null);
        MMLog.c("MMSDK", String.format("Package: %s", new Object[]{localContext.getPackageName()}));
        MMLog.c("MMSDK", String.format("MMDID: %s", new Object[]{d(localContext)}));
        MMLog.c("MMSDK", "Permissions:");
        if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
            paramMMAdImpl = "not ";
            label183:
            MMLog.c("MMSDK", String.format("android.permission.ACCESS_NETWORK_STATE is %spresent", new Object[]{paramMMAdImpl}));
            if (localContext.checkCallingOrSelfPermission("android.permission.INTERNET") != -1) {
                break label408;
            }
            paramMMAdImpl = "not ";
            label217:
            MMLog.c("MMSDK", String.format("android.permission.INTERNET is %spresent", new Object[]{paramMMAdImpl}));
            if (localContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1) {
                break label415;
            }
            paramMMAdImpl = "not ";
            label251:
            MMLog.c("MMSDK", String.format("android.permission.WRITE_EXTERNAL_STORAGE is %spresent", new Object[]{paramMMAdImpl}));
            if (localContext.checkCallingOrSelfPermission("android.permission.VIBRATE") != -1) {
                break label422;
            }
            paramMMAdImpl = "not ";
            label285:
            MMLog.c("MMSDK", String.format("android.permission.VIBRATE is %spresent", new Object[]{paramMMAdImpl}));
            if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != -1) {
                break label429;
            }
            paramMMAdImpl = "not ";
            label319:
            MMLog.c("MMSDK", String.format("android.permission.ACCESS_COARSE_LOCATION is %spresent", new Object[]{paramMMAdImpl}));
            if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != -1) {
                break label436;
            }
        }
        label408:
        label415:
        label422:
        label429:
        label436:
        for (paramMMAdImpl = "not "; ; paramMMAdImpl = "") {
            MMLog.c("MMSDK", String.format("android.permission.ACCESS_FINE_LOCATION is %spresent", new Object[]{paramMMAdImpl}));
            MMLog.c("MMSDK", "Cached Ads:");
            AdCache.a(localContext, 2, new MMSDK .2 (localContext));
            return;
            paramMMAdImpl = "not ";
            break;
            paramMMAdImpl = "";
            break label183;
            paramMMAdImpl = "";
            break label217;
            paramMMAdImpl = "";
            break label251;
            paramMMAdImpl = "";
            break label285;
            paramMMAdImpl = "";
            break label319;
        }
    }

    static void a(Runnable paramRunnable) {
        if (a()) {
            paramRunnable.run();
            return;
        }
        d.post(paramRunnable);
    }

    static void a(Runnable paramRunnable, long paramLong) {
        d.postDelayed(paramRunnable, paramLong);
    }

    static void a(String paramString) {
        try {
            h = paramString;
            return;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    static boolean a() {
        return d.getLooper() == Looper.myLooper();
    }

    static boolean a(Context paramContext) {
        paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
        if (paramContext == null) {
            return false;
        }
        if ((paramContext.getActiveNetworkInfo() != null) && (paramContext.getActiveNetworkInfo().isConnected() == true)) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    static String b(Context paramContext) {
        StringBuilder localStringBuilder;
        try {
            localStringBuilder = new StringBuilder();
            Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
            for (; ; ) {
                if (!localEnumeration1.hasMoreElements()) {
                    break label145;
                }
                Enumeration localEnumeration2 = ((NetworkInterface) localEnumeration1.nextElement()).getInetAddresses();
                while (localEnumeration2.hasMoreElements()) {
                    paramContext = (InetAddress) localEnumeration2.nextElement();
                    if (!paramContext.isLoopbackAddress()) {
                        if (localStringBuilder.length() > 0) {
                            localStringBuilder.append(',');
                        }
                        paramContext = paramContext.getHostAddress().toUpperCase();
                        if (!InetAddressUtils.isIPv4Address(paramContext)) {
                            break label115;
                        }
                        localStringBuilder.append(paramContext);
                    }
                }
            }
            j = paramContext.indexOf('%');
        } catch (Exception paramContext) {
            MMLog.a("MMSDK", "Exception getting ip information: ", paramContext);
            return "";
        }
        label115:
        int j;
        if (j < 0) {
        }
        for (; ; ) {
            localStringBuilder.append(paramContext);
            break;
            paramContext = paramContext.substring(0, j);
        }
        label145:
        paramContext = localStringBuilder.toString();
        return paramContext;
    }

    static boolean b() {
        return Build.VERSION.SDK_INT >= 14;
    }

    static String c(Context paramContext) {
        paramContext = (ConnectivityManager) paramContext.getSystemService("connectivity");
        if (paramContext == null) {
            return "unknown";
        }
        if ((paramContext.getActiveNetworkInfo() != null) && (paramContext.getActiveNetworkInfo().isConnected() == true)) {
            int j = paramContext.getActiveNetworkInfo().getType();
            int k = paramContext.getActiveNetworkInfo().getSubtype();
            if (j == 1) {
                return "wifi";
            }
            if (j == 0) {
                switch (k) {
                    default:
                        return "unknown";
                    case 7:
                        return "1xrtt";
                    case 4:
                        return "cdma";
                    case 2:
                        return "edge";
                    case 14:
                        return "ehrpd";
                    case 5:
                        return "evdo_0";
                    case 6:
                        return "evdo_a";
                    case 12:
                        return "evdo_b";
                    case 1:
                        return "gprs";
                    case 8:
                        return "hsdpa";
                    case 10:
                        return "hspa";
                    case 15:
                        return "hspap";
                    case 9:
                        return "hsupa";
                    case 11:
                        return "iden";
                    case 13:
                        return "lte";
                }
                return "umts";
            }
            return "unknown";
        }
        return "offline";
    }

    static boolean c() {
        return Integer.parseInt(Build.VERSION.SDK) >= 11;
    }

    static String d(Context paramContext) {
        Object localObject = null;
        for (; ; ) {
            try {
                if (h != null) {
                    paramContext = h;
                    return paramContext;
                }
                str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
                paramContext = (Context) localObject;
                if (str != null) {
                    paramContext = new StringBuilder("mmh_");
                }
            } finally {
                try {
                    String str;
                    paramContext.append(a(MessageDigest.getInstance("MD5").digest(str.getBytes())));
                    paramContext.append("_");
                    paramContext.append(a(MessageDigest.getInstance("SHA1").digest(str.getBytes())));
                    paramContext = paramContext.toString();
                    h = paramContext;
                } catch (Exception paramContext) {
                    MMLog.a("MMSDK", "Exception calculating hash: ", paramContext);
                    paramContext = (Context) localObject;
                }
                paramContext =finally;
            }
        }
    }

    static float e(Context paramContext) {
        return paramContext.getResources().getDisplayMetrics().density;
    }

    static void f(Context paramContext) {
        if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            a(paramContext, "INTERNET permission").show();
        }
        if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
            a(paramContext, "ACCESS_NETWORK_STATE permission").show();
        }
    }

    static void g(Context paramContext) {
        PackageManager localPackageManager = paramContext.getPackageManager();
        try {
            localPackageManager.getActivityInfo(new ComponentName(paramContext, "com.millennialmedia.android.MMActivity"), 128);
            return;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            MMLog.a("MMSDK", "Activity MMActivity not declared in AndroidManifest.xml", localNameNotFoundException);
            localNameNotFoundException.printStackTrace();
            a(paramContext, "MMActivity class").show();
        }
    }

    public static boolean getBroadcastEvents() {
        return f;
    }

    public static int getDefaultAdId() {
        try {
            int j = g + 1;
            g = j;
            return j;
        } finally {
        }
    }

    @Deprecated
    public static int getLogLevel() {
        return MMLog.getLogLevel();
    }

    static boolean h(Context paramContext) {
        return (paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1) && ((!Build.VERSION.SDK.equalsIgnoreCase("8")) || ((Environment.getExternalStorageState().equals("mounted")) && (AdCache.a)));
    }

    static String i(Context paramContext) {
        Configuration localConfiguration = k(paramContext);
        if (localConfiguration.mcc == 0) {
            paramContext = l(paramContext);
            if ((paramContext != null) && (paramContext.length() >= 6)) {
                return paramContext.substring(0, 3);
            }
        }
        return String.valueOf(localConfiguration.mcc);
    }

    public static void initialize(Context paramContext) {
        paramContext = HandShake.a(paramContext);
        paramContext.b();
        paramContext.c();
    }

    static String j(Context paramContext) {
        Configuration localConfiguration = k(paramContext);
        if (localConfiguration.mnc == 0) {
            paramContext = l(paramContext);
            if ((paramContext != null) && (paramContext.length() >= 6)) {
                return paramContext.substring(3);
            }
        }
        return String.valueOf(localConfiguration.mnc);
    }

    static Configuration k(Context paramContext) {
        return paramContext.getResources().getConfiguration();
    }

    static String l(Context paramContext) {
        return ((TelephonyManager) paramContext.getSystemService("phone")).getNetworkOperator();
    }

    static String m(Context paramContext) {
        return ((TelephonyManager) paramContext.getSystemService("phone")).getNetworkOperatorName();
    }

    static a n(Context paramContext) {
        try {
            paramContext = AdvertisingIdClient.getAdvertisingIdInfo(paramContext);
            return paramContext;
        } catch (IOException paramContext) {
            MMLog.a("MMSDK", "Unrecoverable error connecting to Google Play services (e.g.,the old version of the service doesnt support getting AdvertisingId", paramContext);
            return null;
        } catch (f paramContext) {
            MMLog.a("MMSDK", "Google Play services is not available entirely.", paramContext);
            return null;
        } catch (IllegalStateException paramContext) {
            MMLog.a("MMSDK", "IllegalStateException: ", paramContext);
            return null;
        } catch (g paramContext) {
            MMLog.a("MMSDK", "Google Play Services is not installed, up-to-date, or enabled", paramContext);
        }
        return null;
    }

    static String o(Context paramContext) {
        return Integer.toString(paramContext.getResources().getDisplayMetrics().widthPixels);
    }

    static String p(Context paramContext) {
        return Integer.toString(paramContext.getResources().getDisplayMetrics().heightPixels);
    }

    static boolean q(Context paramContext) {
        return paramContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    static boolean r(Context paramContext) {
        return paramContext.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0;
    }

    public static void resetCache(Context paramContext) {
        AdCache.e(paramContext);
    }

    static int s(Context paramContext) {
        return ((AudioManager) paramContext.getApplicationContext().getSystemService("audio")).getStreamVolume(3);
    }

    public static void setBroadcastEvents(boolean paramBoolean) {
        f = paramBoolean;
    }

    @Deprecated
    public static void setLogLevel(int paramInt) {
        switch (paramInt) {
            default:
                MMLog.setLogLevel(4);
                return;
            case 1:
                MMLog.setLogLevel(3);
                return;
            case 2:
                MMLog.setLogLevel(4);
                return;
            case 3:
                MMLog.setLogLevel(2);
                return;
        }
        MMLog.setLogLevel(6);
    }

    static String t(Context paramContext) {
        return String.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    public static void trackConversion(Context paramContext, String paramString) {
        MMConversionTracker.a(paramContext, paramString, null);
    }

    public static void trackConversion(Context paramContext, String paramString, MMRequest paramMMRequest) {
        MMConversionTracker.a(paramContext, paramString, paramMMRequest);
    }

    public static void trackEvent(Context paramContext, String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            paramContext = d(paramContext);
            if (!TextUtils.isEmpty(paramContext)) {
                Utils.HttpUtils.a("http://ads.mp.mydas.mobi/pixel?id=" + paramString + "&mmdid=" + paramContext);
            }
        }
    }

    static String u(Context paramContext) {
        return String.valueOf(paramContext.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    static String v(Context paramContext) {
        switch (paramContext.getResources().getConfiguration().orientation) {
            default:
                return "default";
            case 1:
                return "portrait";
            case 2:
                return "landscape";
        }
        return "square";
    }

    static final String w(Context paramContext) {
        if (Settings.System.getString(paramContext.getContentResolver(), "accelerometer_rotation").equals("1")) {
            return "false";
        }
        return "true";
    }

    private static String x(Context paramContext) {
        return Float.toString(e(paramContext));
    }

    private static String y(Context paramContext) {
        if ((i) && (r(paramContext))) {
            return "true";
        }
        return "false";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/MMSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */