package com.inmobi.commons.data;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;

public class DeviceInfo {
    private static String a;
    private static String b;
    private static String c;
    private static String d = null;
    private static String e = null;
    private static String f;
    private static String g;
    private static DeviceInfo.a h = DeviceInfo.a.a;

    private static String a() {
        return c;
    }

    private static void a(Context paramContext) {
        try {
            if (f == null) {
                f = FileOperations.getPreferences(paramContext, "impref", "AID");
            }
            if (f == null) {
                f = UUID.randomUUID().toString();
                FileOperations.setPreferences(paramContext, "impref", "AID", f);
            }
            return;
        } catch (Exception paramContext) {
        }
    }

    private static void a(DeviceInfo.a parama) {
        h = parama;
    }

    private static void a(String paramString) {
        a = paramString;
    }

    private static void b(String paramString) {
        b = paramString;
    }

    private static void c(String paramString) {
        c = paramString;
    }

    public static String getAid() {
        return f;
    }

    public static int getDisplayRotation(Display paramDisplay) {
        Object localObject = null;
        try {
            Method localMethod1 = Display.class.getMethod("getRotation", (Class[]) null);
            localObject = localMethod1;
        } catch (NoSuchMethodException localNoSuchMethodException1) {
            for (; ; ) {
                try {
                    int i = ((Integer) ((Method) localObject).invoke(paramDisplay, (Object[]) null)).intValue();
                    return i;
                } catch (Exception paramDisplay) {
                    Log.internal("[InMobi]-4.5.1", "Unable to access display rotation");
                }
                localNoSuchMethodException1 = localNoSuchMethodException1;
                try {
                    Method localMethod2 = Display.class.getMethod("getOrientation", (Class[]) null);
                    localObject = localMethod2;
                } catch (NoSuchMethodException localNoSuchMethodException2) {
                    Log.internal("[InMobi]-4.5.1", "Unable to access getOrientation method via reflection");
                }
            }
        }
        if (localObject != null) {
        }
        return 64537;
    }

    public static String getLocalization() {
        return b;
    }

    public static String getNetworkType() {
        return a;
    }

    public static int getOrientation() {
        return DeviceInfo.a.a(h);
    }

    public static String getPhoneDefaultUserAgent() {
        if (g == null) {
            return "";
        }
        return g;
    }

    public static String getScreenDensity() {
        return e;
    }

    public static String getScreenSize() {
        return d;
    }

    public static boolean isDefOrientationLandscape(int paramInt1, int paramInt2, int paramInt3) {
        if ((paramInt2 > paramInt3) && ((paramInt1 == 0) || (paramInt1 == 2))) {
        }
        while ((paramInt2 < paramInt3) && ((paramInt1 == 1) || (paramInt1 == 3))) {
            return true;
        }
        return false;
    }

    public static boolean isTablet(Context paramContext) {
        paramContext = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        paramContext.getMetrics(localDisplayMetrics);
        double d1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
        double d2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
        return Math.sqrt(d2 * d2 + d1 * d1) > 7.0D;
    }

    public static void setPhoneDefaultUserAgent(String paramString) {
        g = paramString;
    }

    public static void setScreenDensity(String paramString) {
        e = paramString;
    }

    public static void setScreenSize(String paramString) {
        d = paramString;
    }

    public static void updateDeviceInfo() {
        try {
            Object localObject1 = new DisplayMetrics();
            Object localObject2 = ((WindowManager) InternalSDKUtil.getContext().getSystemService("window")).getDefaultDisplay();
            ((Display) localObject2).getMetrics((DisplayMetrics) localObject1);
            float f1 = ((DisplayMetrics) localObject1).density;
            int i = (int) (WrapperFunctions.getDisplayWidth((Display) localObject2) / f1);
            int j = (int) (WrapperFunctions.getDisplayHeight((Display) localObject2) / f1);
            setScreenDensity(String.valueOf(f1));
            setScreenSize("" + i + "X" + j);
            setPhoneDefaultUserAgent(InternalSDKUtil.getUserAgent());
            if (a() == null) {
                c(Build.BRAND);
                localObject1 = Locale.getDefault();
                localObject2 = ((Locale) localObject1).getLanguage();
                if (localObject2 != null) {
                    localObject2 = ((String) localObject2).toLowerCase(Locale.ENGLISH);
                    str = ((Locale) localObject1).getCountry();
                    localObject1 = localObject2;
                    if (str != null) {
                        localObject1 = (String) localObject2 + "_" + str.toLowerCase(Locale.ENGLISH);
                    }
                    b((String) localObject1);
                }
            } else {
                if (InternalSDKUtil.getContext() != null) {
                    a(InternalSDKUtil.getContext());
                }
                updateDeviceOrientation();
                updateNetworkConnectedInfo();
                return;
            }
            localObject1 = (String) System.getProperties().get("user.language");
            String str = (String) System.getProperties().get("user.region");
            if ((localObject1 != null) && (str != null)) {
                localObject2 = (String) localObject1 + "_" + str;
            }
            for (; ; ) {
                localObject1 = localObject2;
                if (localObject2 != null) {
                    break;
                }
                localObject1 = "en";
                break;
            }
        } catch (Exception localException) {
            Log.internal("[InMobi]-4.5.1", "Exception setting device info", localException);
            return;
        }
    }

    public static void updateDeviceOrientation() {
        int i;
        try {
            i = WrapperFunctions.getCurrentOrientationInFixedValues(InternalSDKUtil.getContext());
            if (i == 9) {
                a(DeviceInfo.a.b);
                return;
            }
            if (i == 8) {
                a(DeviceInfo.a.d);
                return;
            }
        } catch (Exception localException) {
            Log.debug("[InMobi]-4.5.1", "Error getting the orientation info ", localException);
            return;
        }
        if (i == 0) {
            a(DeviceInfo.a.c);
            return;
        }
        a(DeviceInfo.a.a);
    }

    public static void updateNetworkConnectedInfo() {
        a(InternalSDKUtil.getConnectivityType(InternalSDKUtil.getContext()));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/data/DeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */