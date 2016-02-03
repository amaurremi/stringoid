package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

class c {
    private final String a;
    private final View b;
    private final Context c;
    private final IAadConfig d;
    private Intent e;
    private ArrayList f;
    private String g;
    private String h;
    private String i = "";

    c(Context paramContext, View paramView, IAadConfig paramIAadConfig) {
        this.b = paramView;
        this.c = paramContext;
        this.d = paramIAadConfig;
        this.f = new ArrayList();
        this.a = new SimpleDateFormat("M/d/yyyy kk:mm:ss z").format(new Date());
        this.e = new Intent("android.intent.action.SEND_MULTIPLE", Uri.parse("mailto:"));
        this.e.setType("plain/text");
        this.e.putExtra("android.intent.extra.EMAIL", new String[]{"support@inner-active.com"});
        if ((this.b == null) || (this.b.getRootView() == null)) {
            paramContext = null;
            paramView = new StringBuilder();
            if (this.d != null) {
                a(paramView, "sdk_version", "5.0.1");
                a(paramView, "device_model", b());
                if (this.d.a != null) {
                    a(paramView, "app_id", this.d.a);
                }
                if (this.d.n() != null) {
                    a(paramView, "session_id", this.d.n());
                }
                if (this.d.b != null) {
                    a(paramView, "ad_type", this.d.b.toString());
                }
                a(paramView, "returned_ad_size", "{" + this.d.p() + ", " + this.d.q() + "}");
            }
            this.g = paramView.toString();
            if (this.d == null) {
                break label550;
            }
            paramView = this.d.b();
            label306:
            this.h = paramView;
        }
        for (; ; ) {
            try {
                if (this.h == null) {
                    continue;
                }
                paramView = this.h;
                this.i = URLDecoder.decode(paramView, "UTF-8");
            } catch (UnsupportedEncodingException paramView) {
                label550:
                InneractiveAdView.Log.d("Inneractive_debug", "Unable to decode html");
                continue;
            }
            this.e.putExtra("android.intent.extra.SUBJECT", "Inneractive Ad Report - " + this.a);
            this.e.putExtra("android.intent.extra.TEXT", "A problematic ad was detected! Attached are three files containing additional information.");
            a("inneractive_data.txt", this.g);
            a("inneractive_response.html", this.i);
            if (paramContext != null) {
                paramView = (View) localObject;
                paramIAadConfig = localFileOutputStream;
            }
            try {
                localFileOutputStream = this.c.openFileOutput("inneractive_screenshot.png", 1);
                paramView = localFileOutputStream;
                paramIAadConfig = localFileOutputStream;
                paramContext.compress(Bitmap.CompressFormat.PNG, 25, localFileOutputStream);
                paramView = localFileOutputStream;
                paramIAadConfig = localFileOutputStream;
                paramContext = Uri.fromFile(new File(this.c.getFilesDir() + File.separator + "inneractive_screenshot.png"));
                paramView = localFileOutputStream;
                paramIAadConfig = localFileOutputStream;
                this.f.add(paramContext);
                return;
            } catch (Exception paramContext) {
                boolean bool;
                paramIAadConfig = paramView;
                InneractiveAdView.Log.d("Inneractive_debug", "Unable to write image attachment to file: " + "inneractive_screenshot.png");
                return;
            } finally {
                a(paramIAadConfig);
            }
            paramView = this.b.getRootView();
            bool = paramView.isDrawingCacheEnabled();
            paramView.setDrawingCacheEnabled(true);
            paramContext = paramView.getDrawingCache();
            if (paramContext == null) {
                paramContext = null;
                break;
            }
            paramContext = Bitmap.createBitmap(paramContext);
            paramView.setDrawingCacheEnabled(bool);
            break;
            paramView = "";
            break label306;
            paramView = "";
        }
    }

    static int a(float paramFloat, Context paramContext) {
        return (int) (TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics()) + 0.5F);
    }

    static int a(Context paramContext, int paramInt) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        return (int) (paramInt / localDisplayMetrics.density + 0.5F);
    }

    static int a(String paramString) {
        return Math.min(3, paramString.length());
    }

    static Location a(Location paramLocation1, Location paramLocation2) {
        Location localLocation;
        if ((paramLocation1 == null) && (paramLocation2 == null)) {
            localLocation = null;
        }
        do {
            do {
                return localLocation;
                if ((paramLocation1 == null) || (paramLocation2 == null)) {
                    break;
                }
                localLocation = paramLocation1;
            } while (paramLocation1.getTime() > paramLocation2.getTime());
            return paramLocation2;
            localLocation = paramLocation1;
        } while (paramLocation1 != null);
        return paramLocation2;
    }

    static String a(Context paramContext) {
        if (c(paramContext)) {
        }
        for (; ; ) {
            try {
                str = (String) new IAreflectionHandler.a(new IAreflectionHandler.a(Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").newInstance(), "getAdvertisingIdInfo").a(Context.class, paramContext).a(), "getId").a();
                InneractiveAdView.Log.v("Inneractive_verbose", "Handled Exception:");
            } catch (Exception localException1) {
                try {
                    InneractiveAdView.Log.v("Inneractive_verbose", "advertising id: " + str);
                    a(paramContext, "AdvertisingIdFile", str);
                    return str;
                } catch (Exception localException2) {
                    for (; ; ) {
                    }
                }
                localException1 = localException1;
                str = null;
            }
            InneractiveAdView.Log.v("Inneractive_verbose", a(localException1));
            InneractiveAdView.Log.d("Inneractive_debug", "Advertising ID is not available. Please add Google Play Services library (v 4.0+) to improve your ad targeting. (relevant for devices running Android API 2.3 and above)");
            continue;
            String str = null;
        }
    }

    static String a(Context paramContext, String paramString) {
        try {
            paramContext = paramContext.openFileInput(paramString);
            byte[] arrayOfByte = new byte[paramContext.available()];
            if (paramContext.read(arrayOfByte) > 0) {
                paramContext = new String(arrayOfByte);
                return paramContext;
            }
        } catch (Exception paramContext) {
            InneractiveAdView.Log.d("Inneractive_debug", "failed to get the param from memory - " + paramString);
        }
        return null;
    }

    static String a(InputStream paramInputStream) {
        StringBuffer localStringBuffer = new StringBuffer();
        byte[] arrayOfByte = new byte['က'];
        for (int j = 0; j != -1; j = paramInputStream.read(arrayOfByte)) {
            localStringBuffer.append(new String(arrayOfByte, 0, j));
        }
        paramInputStream.close();
        return localStringBuffer.toString();
    }

    static String a(Exception paramException) {
        try {
            StringWriter localStringWriter = new StringWriter();
            paramException.printStackTrace(new PrintWriter(localStringWriter));
            paramException = "------\r\n" + localStringWriter.toString() + "------\r\n";
            return paramException;
        } catch (Exception paramException) {
        }
        return "bad stackToString";
    }

    static String a(HttpResponse paramHttpResponse, IAdefines.HeaderParamsResponse paramHeaderParamsResponse) {
        paramHttpResponse = paramHttpResponse.getFirstHeader(paramHeaderParamsResponse.j);
        if (paramHttpResponse != null) {
            return paramHttpResponse.getValue();
        }
        return null;
    }

    static void a(Context paramContext, String paramString1, String paramString2) {
        if ((paramContext != null) && (paramString2 != null)) {
        }
        try {
            if (paramContext.getFileStreamPath(paramString1).exists()) {
                paramContext.deleteFile(paramString1);
            }
            InneractiveAdView.Log.v("Inneractive_verbose", "storing: " + paramString2 + " to: " + paramString1);
            paramContext.openFileOutput(paramString1, 0).write(paramString2.getBytes());
            return;
        } catch (Exception paramContext) {
            InneractiveAdView.Log.v("Inneractive_verbose", "failed to store: " + paramString2 + " to: " + paramString1);
        }
    }

    static void a(View paramView) {
        if ((paramView == null) || (paramView.getParent() == null)) {
        }
        while (!(paramView.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) paramView.getParent()).removeView(paramView);
    }

    static void a(Closeable paramCloseable) {
        if (paramCloseable == null) {
            return;
        }
        try {
            paramCloseable.close();
            return;
        } catch (IOException paramCloseable) {
        }
    }

    static void a(InputStream paramInputStream, OutputStream paramOutputStream) {
        if ((paramInputStream == null) || (paramOutputStream == null)) {
            throw new IOException("Unable to copy from or to a null stream.");
        }
        byte[] arrayOfByte = new byte[65536];
        for (; ; ) {
            int j = paramInputStream.read(arrayOfByte);
            if (j == -1) {
                break;
            }
            paramOutputStream.write(arrayOfByte, 0, j);
        }
    }

    private void a(String paramString1, String paramString2) {
        Object localObject1 = null;
        if (paramString2 == null) {
            return;
        }
        try {
            FileOutputStream localFileOutputStream = this.c.openFileOutput(paramString1, 1);
            localObject1 = localFileOutputStream;
            Object localObject2 = localFileOutputStream;
            a((Closeable) localObject2);
        } catch (Exception paramString2) {
            try {
                localFileOutputStream.write(paramString2.getBytes());
                localObject1 = localFileOutputStream;
                localObject2 = localFileOutputStream;
                paramString2 = Uri.fromFile(new File(this.c.getFilesDir() + File.separator + paramString1));
                localObject1 = localFileOutputStream;
                localObject2 = localFileOutputStream;
                this.f.add(paramString2);
                a(localFileOutputStream);
                return;
            } finally {
                for (; ; ) {
                }
            }
            paramString2 = paramString2;
            localObject2 = localObject1;
            InneractiveAdView.Log.d("Inneractive_debug", "Unable to write text attachment to file: " + paramString1);
            a((Closeable) localObject1);
            return;
        } finally {
            paramString1 =finally;
            localObject2 = null;
        }
        throw paramString1;
    }

    private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2) {
        paramStringBuilder.append(paramString1);
        paramStringBuilder.append(" : ");
        paramStringBuilder.append(paramString2);
        paramStringBuilder.append("\n");
    }

    static boolean a(Activity paramActivity) {
        try {
            if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.c)) {
                Window localWindow = paramActivity.getWindow();
                int j;
                if (localWindow != null) {
                    j = localWindow.getAttributes().flags;
                    if ((j & 0x1000000) == 0) {
                    }
                }
                for (; ; ) {
                    return true;
                    try {
                        j = paramActivity.getPackageManager().getActivityInfo(paramActivity.getComponentName(), 0).flags;
                        if ((j & 0x200) != 0) {
                        }
                    } catch (PackageManager.NameNotFoundException paramActivity) {
                        for (; ; ) {
                            InneractiveAdView.Log.v("Inneractive_verbose", "getActivityInfo(self) should not fail");
                        }
                    }
                }
                return false;
            }
        } catch (Exception paramActivity) {
            InneractiveAdView.Log.v("Inneractive_verbose", "hasHardwareAcceleration failed to getWindow. returning false");
        }
        return false;
    }

    static boolean a(Context paramContext, Intent paramIntent) {
        boolean bool = false;
        if (paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).size() > 0) {
            bool = true;
        }
        return bool;
    }

    static int b(Context paramContext, int paramInt) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        return (int) (paramInt * localDisplayMetrics.density + 0.5F);
    }

    static String b() {
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    static boolean b(Context paramContext) {
        if (c(paramContext)) {
        }
        for (; ; ) {
            try {
                bool = ((Boolean) new IAreflectionHandler.a(new IAreflectionHandler.a(Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").newInstance(), "getAdvertisingIdInfo").a(Context.class, paramContext).a(), "isLimitAdTrackingEnabled").a()).booleanValue();
                InneractiveAdView.Log.v("Inneractive_verbose", "Handled Exception:");
            } catch (Exception localException1) {
                try {
                    InneractiveAdView.Log.v("Inneractive_verbose", "limit ad tracking: " + bool);
                    a(paramContext, "LimitAdTrackingFile", Boolean.toString(bool));
                    return bool;
                } catch (Exception localException2) {
                    for (; ; ) {
                    }
                }
                localException1 = localException1;
                bool = false;
            }
            InneractiveAdView.Log.v("Inneractive_verbose", a(localException1));
            InneractiveAdView.Log.d("Inneractive_debug", "Limit Ad Tracking Info is not available. Please add Google Play Services library (v 4.0+) to improve your ad targeting. (relevant for devices running Android API 2.3 and above)");
            continue;
            boolean bool = false;
        }
    }

    static boolean b(Context paramContext, String paramString) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramString.equals("MM")) {
        }
        try {
            paramString = new Intent(paramContext, Class.forName("com.millennialmedia.android.MMActivity"));
            bool1 = bool2;
            if (paramString != null) {
                InneractiveAdView.Log.d("Inneractive_debug", "MMActivity was found in the Manifest? " + a(paramContext, paramString));
                bool1 = a(paramContext, paramString);
            }
            return bool1;
        } catch (ClassNotFoundException paramString) {
            for (; ; ) {
                InneractiveAdView.Log.d("Inneractive_debug", "exception when trying to check if millennial available");
                paramString = null;
            }
        }
    }

    static boolean b(String paramString) {
        if ((paramString == null) || ("null".equals(paramString))) {
        }
        while (paramString.length() == 0) {
            return true;
        }
        return false;
    }

    static String c(String paramString) {
        if (paramString != null) {
            return paramString.replace(" ", "");
        }
        return null;
    }

    static boolean c(Context paramContext) {
        try {
            paramContext = new IAreflectionHandler.a(null, "isGooglePlayServicesAvailable").a(Class.forName(IAdefines.n)).a(Context.class, paramContext).a();
            if ((paramContext != null) && (((Integer) paramContext).intValue() == 0)) {
            }
            for (boolean bool = true; ; bool = false) {
                InneractiveAdView.Log.d("Inneractive_debug", "isGooglePlayServicesAvailable = " + bool);
                return bool;
            }
            return false;
        } catch (Exception paramContext) {
            InneractiveAdView.Log.v("Inneractive_verbose", "Handled Exception:");
            InneractiveAdView.Log.v("Inneractive_verbose", a(paramContext));
            InneractiveAdView.Log.d("Inneractive_debug", "isGooglePlayServicesAvailable = FALSE! :( ");
        }
    }

    static boolean c(Context paramContext, int paramInt) {
        paramInt = (int) TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
        return paramContext.getResources().getDisplayMetrics().widthPixels >= paramInt;
    }

    static String d(Context paramContext) {
        try {
            TelephonyManager localTelephonyManager = (TelephonyManager) paramContext.getSystemService("phone");
            String str = localTelephonyManager.getNetworkOperator();
            if (localTelephonyManager.getPhoneType() == 2) {
                paramContext = (TelephonyManager) paramContext.getSystemService("phone");
                if ((paramContext != null) && (paramContext.getSimState() == 5)) {
                }
                for (int j = 1; j != 0; j = 0) {
                    paramContext = localTelephonyManager.getSimOperator();
                    return paramContext;
                }
            }
            return str;
        } catch (Exception paramContext) {
            return null;
        }
    }

    static String d(String paramString) {
        try {
            Object localObject = MessageDigest.getInstance("SHA-1");
            ((MessageDigest) localObject).update(paramString.getBytes());
            paramString = ((MessageDigest) localObject).digest();
            localObject = new StringBuffer();
            int j = 0;
            while (j < paramString.length) {
                ((StringBuffer) localObject).append(Integer.toHexString(paramString[j] & 0xFF | 0x100).substring(1));
                j += 1;
            }
            paramString = ((StringBuffer) localObject).toString();
            return paramString;
        } catch (NoSuchAlgorithmException paramString) {
            return "";
        } catch (NullPointerException paramString) {
        }
        return "";
    }

    /* Error */
    static Location e(Context paramContext) {
        // Byte code:
        //   0: aload_0
        //   1: ldc_w 685
        //   4: invokevirtual 287	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   7: checkcast 687	android/location/LocationManager
        //   10: astore_0
        //   11: aload_0
        //   12: ldc_w 689
        //   15: invokevirtual 693	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
        //   18: astore_1
        //   19: aload_0
        //   20: ldc_w 695
        //   23: invokevirtual 693	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
        //   26: astore_0
        //   27: aload_1
        //   28: ifnonnull +65 -> 93
        //   31: aload_0
        //   32: ifnonnull +61 -> 93
        //   35: aconst_null
        //   36: areturn
        //   37: astore_1
        //   38: ldc -6
        //   40: ldc_w 697
        //   43: invokestatic 256	com/inneractive/api/ads/sdk/InneractiveAdView$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   46: aconst_null
        //   47: astore_1
        //   48: goto -29 -> 19
        //   51: astore_1
        //   52: ldc -6
        //   54: ldc_w 699
        //   57: invokestatic 256	com/inneractive/api/ads/sdk/InneractiveAdView$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   60: aconst_null
        //   61: astore_1
        //   62: goto -43 -> 19
        //   65: astore_0
        //   66: ldc -6
        //   68: ldc_w 701
        //   71: invokestatic 256	com/inneractive/api/ads/sdk/InneractiveAdView$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   74: aconst_null
        //   75: astore_0
        //   76: goto -49 -> 27
        //   79: astore_0
        //   80: ldc -6
        //   82: ldc_w 703
        //   85: invokestatic 256	com/inneractive/api/ads/sdk/InneractiveAdView$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   88: aconst_null
        //   89: astore_0
        //   90: goto -63 -> 27
        //   93: aload_1
        //   94: ifnull +28 -> 122
        //   97: aload_0
        //   98: ifnull +24 -> 122
        //   101: aload_1
        //   102: invokevirtual 320	android/location/Location:getTime	()J
        //   105: aload_0
        //   106: invokevirtual 320	android/location/Location:getTime	()J
        //   109: lcmp
        //   110: ifle +7 -> 117
        //   113: aload_1
        //   114: astore_2
        //   115: aload_2
        //   116: areturn
        //   117: aload_0
        //   118: astore_2
        //   119: goto -4 -> 115
        //   122: aload_1
        //   123: astore_2
        //   124: aload_1
        //   125: ifnonnull -10 -> 115
        //   128: aload_0
        //   129: astore_2
        //   130: goto -15 -> 115
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	133	0	paramContext	Context
        //   18	10	1	localLocation	Location
        //   37	1	1	localSecurityException	SecurityException
        //   47	1	1	localObject1	Object
        //   51	1	1	localIllegalArgumentException	IllegalArgumentException
        //   61	64	1	localObject2	Object
        //   114	16	2	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   11	19	37	java/lang/SecurityException
        //   11	19	51	java/lang/IllegalArgumentException
        //   19	27	65	java/lang/SecurityException
        //   19	27	79	java/lang/IllegalArgumentException
    }

    static String e(String paramString) {
        try {
            Object localObject = MessageDigest.getInstance("MD5");
            ((MessageDigest) localObject).update(paramString.getBytes());
            paramString = ((MessageDigest) localObject).digest();
            localObject = new StringBuffer();
            int j = 0;
            while (j < paramString.length) {
                ((StringBuffer) localObject).append(Integer.toHexString(paramString[j] & 0xFF | 0x100).substring(1));
                j += 1;
            }
            paramString = ((StringBuffer) localObject).toString();
            return paramString;
        } catch (NoSuchAlgorithmException paramString) {
        }
        return "";
    }

    static String f(Context paramContext) {
        try {
            paramContext = (TelephonyManager) paramContext.getSystemService("phone");
            InneractiveAdView.Log.v("Inneractive_verbose", "device ID =  " + paramContext.getDeviceId());
            paramContext = paramContext.getDeviceId();
            return paramContext;
        } catch (Exception paramContext) {
        }
        return null;
    }

    static String g(Context paramContext) {
        try {
            String str = paramContext.getPackageName();
            paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
            return paramContext;
        } catch (Exception paramContext) {
        }
        return null;
    }

    static String h(Context paramContext) {
        try {
            paramContext = ((TelephonyManager) paramContext.getSystemService("phone")).getNetworkCountryIso();
            return paramContext;
        } catch (Exception paramContext) {
        }
        return null;
    }

    static String i(Context paramContext) {
        try {
            paramContext = ((TelephonyManager) paramContext.getSystemService("phone")).getNetworkOperatorName();
            return paramContext;
        } catch (Exception paramContext) {
        }
        return null;
    }

    static boolean j(Context paramContext) {
        return ("mounted".equals(Environment.getExternalStorageState())) && (paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
    }

    static boolean k(Context paramContext) {
        Intent localIntent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.item/event");
        return (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.e)) && (a(paramContext, localIntent));
    }

    static boolean l(Context paramContext) {
        if ((paramContext.getResources().getConfiguration().screenLayout & 0xF) == 4) {
        }
        for (boolean bool = true; ; bool = false) {
            InneractiveAdView.Log.v("Inneractive_debug", "This device has a tablet resolution? " + bool);
            return bool;
        }
    }

    static boolean m(Context paramContext) {
        if ((paramContext.getResources().getConfiguration().screenLayout & 0xF) == 3) {
        }
        for (boolean bool = true; ; bool = false) {
            InneractiveAdView.Log.d("Inneractive_debug", "This device has a mini tablet resolution? " + bool);
            return bool;
        }
    }

    static int n(Context paramContext) {
        boolean bool = true;
        int j = paramContext.getResources().getConfiguration().orientation;
        paramContext = new StringBuilder("The device orientation: ");
        if (j == 1) {
            if (bool == null) {
                break label57;
            }
        }
        label57:
        for (paramContext = "portait"; ; paramContext = "landscape") {
            InneractiveAdView.Log.d("Inneractive_debug", paramContext);
            return j;
            bool = false;
            break;
        }
    }

    static int o(Context paramContext) {
        Display localDisplay = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay();
        if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.d)) {
            paramContext = new Point();
            try {
                new IAreflectionHandler.a(localDisplay, "getSize").a(Point.class, paramContext).a();
                return paramContext.y;
            } catch (Exception localException) {
                for (; ; ) {
                    InneractiveAdView.Log.d("Inneractive_debug", "Failed to get display size");
                }
            }
        }
        return localException.getHeight();
    }

    static int p(Context paramContext) {
        Display localDisplay = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay();
        if (IAdefines.ApiLevel.a().a(IAdefines.ApiLevel.d)) {
            paramContext = new Point();
            try {
                new IAreflectionHandler.a(localDisplay, "getSize").a(Point.class, paramContext).a();
                return paramContext.x;
            } catch (Exception localException) {
                for (; ; ) {
                    InneractiveAdView.Log.d("Inneractive_debug", "Failed to get display size");
                }
            }
        }
        return localException.getWidth();
    }

    final void a() {
        this.e.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f);
        Intent localIntent = Intent.createChooser(this.e, "Send Email...");
        localIntent.addFlags(268435456);
        this.c.startActivity(localIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */