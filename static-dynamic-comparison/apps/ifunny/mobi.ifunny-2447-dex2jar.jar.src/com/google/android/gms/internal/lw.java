package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ii
public final class lw {
    private static final Object a = new Object();
    private static final SimpleDateFormat[] b = {new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"), new SimpleDateFormat("yyyyMMdd")};
    private static boolean c = true;
    private static String d;
    private static boolean e = false;

    public static String a(Context paramContext, String paramString) {
        String str;
        synchronized (a) {
            if (d != null) {
                paramContext = d;
                return paramContext;
            }
            int i = Build.VERSION.SDK_INT;
            if (i < 17) {
            }
        }
        if (!mv.b()) {
            mv.a.post(new lx(paramContext));
            for (; ; ) {
                paramContext = d;
                if (paramContext != null) {
                    break;
                }
                try {
                    a.wait();
                } catch (InterruptedException paramContext) {
                    d = d();
                    mx.e("Interrupted, use default user agent: " + d);
                }
            }
        }
        try {
            d = f(paramContext);
            d = d + " (Mobile; " + paramString + ")";
            paramContext = d;
            return paramContext;
        } catch (Exception paramContext) {
            for (; ; ) {
                d = d();
            }
        }
    }

    public static String a(Readable paramReadable) {
        StringBuilder localStringBuilder = new StringBuilder();
        CharBuffer localCharBuffer = CharBuffer.allocate(2048);
        for (; ; ) {
            int i = paramReadable.read(localCharBuffer);
            if (i == -1) {
                break;
            }
            localCharBuffer.flip();
            localStringBuilder.append(localCharBuffer, 0, i);
        }
        return localStringBuilder.toString();
    }

    public static String a(String paramString) {
        return Uri.parse(paramString).buildUpon().query(null).build().toString();
    }

    public static Map<String, String> a(Uri paramUri) {
        if (paramUri == null) {
            return null;
        }
        HashMap localHashMap = new HashMap();
        Object localObject = new UrlQuerySanitizer();
        ((UrlQuerySanitizer) localObject).setAllowUnregisteredParamaters(true);
        ((UrlQuerySanitizer) localObject).setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        ((UrlQuerySanitizer) localObject).parseUrl(paramUri.toString());
        paramUri = ((UrlQuerySanitizer) localObject).getParameterList().iterator();
        while (paramUri.hasNext()) {
            localObject = (UrlQuerySanitizer.ParameterValuePair) paramUri.next();
            localHashMap.put(((UrlQuerySanitizer.ParameterValuePair) localObject).mParameter, ((UrlQuerySanitizer.ParameterValuePair) localObject).mValue);
        }
        return localHashMap;
    }

    private static JSONArray a(Collection<?> paramCollection) {
        JSONArray localJSONArray = new JSONArray();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            a(localJSONArray, paramCollection.next());
        }
        return localJSONArray;
    }

    static JSONArray a(Object[] paramArrayOfObject) {
        JSONArray localJSONArray = new JSONArray();
        int j = paramArrayOfObject.length;
        int i = 0;
        while (i < j) {
            a(localJSONArray, paramArrayOfObject[i]);
            i += 1;
        }
        return localJSONArray;
    }

    private static JSONObject a(Bundle paramBundle) {
        JSONObject localJSONObject = new JSONObject();
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            a(localJSONObject, str, paramBundle.get(str));
        }
        return localJSONObject;
    }

    public static JSONObject a(Map<String, ?> paramMap) {
        try {
            JSONObject localJSONObject = new JSONObject();
            Iterator localIterator = paramMap.keySet().iterator();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                a(localJSONObject, str, paramMap.get(str));
            }
            return localJSONObject;
        } catch (ClassCastException paramMap) {
            throw new JSONException("Could not convert map to JSON: " + paramMap.getMessage());
        }
    }

    public static void a(Context paramContext, String paramString, WebSettings paramWebSettings) {
        paramWebSettings.setUserAgentString(a(paramContext, paramString));
    }

    public static void a(Context paramContext, String paramString1, String paramString2) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString2);
        a(paramContext, paramString1, localArrayList);
    }

    public static void a(Context paramContext, String paramString, List<String> paramList) {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            new mu(paramContext, paramString, (String) paramList.next()).e();
        }
    }

    public static void a(Context paramContext, String paramString1, List<String> paramList, String paramString2) {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            new mu(paramContext, paramString1, (String) paramList.next(), paramString2).e();
        }
    }

    public static void a(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection) {
        a(paramContext, paramString, paramBoolean, paramHttpURLConnection, false);
    }

    public static void a(Context paramContext, String paramString1, boolean paramBoolean, HttpURLConnection paramHttpURLConnection, String paramString2) {
        paramHttpURLConnection.setConnectTimeout(60000);
        paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean);
        paramHttpURLConnection.setReadTimeout(60000);
        paramHttpURLConnection.setRequestProperty("User-Agent", paramString2);
        paramHttpURLConnection.setUseCaches(false);
    }

    public static void a(Context paramContext, String paramString, boolean paramBoolean1, HttpURLConnection paramHttpURLConnection, boolean paramBoolean2) {
        paramHttpURLConnection.setConnectTimeout(60000);
        paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean1);
        paramHttpURLConnection.setReadTimeout(60000);
        paramHttpURLConnection.setRequestProperty("User-Agent", a(paramContext, paramString));
        paramHttpURLConnection.setUseCaches(paramBoolean2);
    }

    public static void a(WebView paramWebView) {
        if (Build.VERSION.SDK_INT >= 11) {
            mj.a(paramWebView);
        }
    }

    private static void a(JSONArray paramJSONArray, Object paramObject) {
        if ((paramObject instanceof Bundle)) {
            paramJSONArray.put(a((Bundle) paramObject));
            return;
        }
        if ((paramObject instanceof Map)) {
            paramJSONArray.put(a((Map) paramObject));
            return;
        }
        if ((paramObject instanceof Collection)) {
            paramJSONArray.put(a((Collection) paramObject));
            return;
        }
        if ((paramObject instanceof Object[])) {
            paramJSONArray.put(a((Object[]) paramObject));
            return;
        }
        paramJSONArray.put(paramObject);
    }

    private static void a(JSONObject paramJSONObject, String paramString, Object paramObject) {
        if ((paramObject instanceof Bundle)) {
            paramJSONObject.put(paramString, a((Bundle) paramObject));
            return;
        }
        if ((paramObject instanceof Map)) {
            paramJSONObject.put(paramString, a((Map) paramObject));
            return;
        }
        if ((paramObject instanceof Collection)) {
            if (paramString != null) {
            }
            for (; ; ) {
                paramJSONObject.put(paramString, a((Collection) paramObject));
                return;
                paramString = "null";
            }
        }
        if ((paramObject instanceof Object[])) {
            paramJSONObject.put(paramString, a(Arrays.asList((Object[]) paramObject)));
            return;
        }
        paramJSONObject.put(paramString, paramObject);
    }

    public static boolean a() {
        return c;
    }

    public static boolean a(Context paramContext) {
        Intent localIntent = new Intent();
        localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
        paramContext = paramContext.getPackageManager().resolveActivity(localIntent, 65536);
        if ((paramContext == null) || (paramContext.activityInfo == null)) {
            mx.e("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        if ((paramContext.activityInfo.configChanges & 0x10) == 0) {
            mx.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboard"}));
        }
        for (boolean bool = false; ; bool = true) {
            if ((paramContext.activityInfo.configChanges & 0x20) == 0) {
                mx.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboardHidden"}));
                bool = false;
            }
            if ((paramContext.activityInfo.configChanges & 0x80) == 0) {
                mx.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"orientation"}));
                bool = false;
            }
            if ((paramContext.activityInfo.configChanges & 0x100) == 0) {
                mx.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenLayout"}));
                bool = false;
            }
            if ((paramContext.activityInfo.configChanges & 0x200) == 0) {
                mx.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"uiMode"}));
                bool = false;
            }
            if ((paramContext.activityInfo.configChanges & 0x400) == 0) {
                mx.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenSize"}));
                bool = false;
            }
            if ((paramContext.activityInfo.configChanges & 0x800) == 0) {
                mx.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"smallestScreenSize"}));
                return false;
            }
            return bool;
        }
    }

    public static boolean a(PackageManager paramPackageManager, String paramString1, String paramString2) {
        return paramPackageManager.checkPermission(paramString2, paramString1) == 0;
    }

    public static boolean a(ClassLoader paramClassLoader, Class<?> paramClass, String paramString) {
        try {
            boolean bool = paramClass.isAssignableFrom(Class.forName(paramString, false, paramClassLoader));
            return bool;
        } catch (Throwable paramClassLoader) {
        }
        return false;
    }

    public static int b() {
        if (Build.VERSION.SDK_INT >= 9) {
            return 6;
        }
        return 0;
    }

    public static int b(String paramString) {
        try {
            int i = Integer.parseInt(paramString);
            return i;
        } catch (NumberFormatException paramString) {
            mx.e("Could not parse value:" + paramString);
        }
        return 0;
    }

    public static void b(Context paramContext) {
        if (e) {
            return;
        }
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        paramContext.getApplicationContext().registerReceiver(new ly(null), localIntentFilter);
        e = true;
    }

    public static void b(WebView paramWebView) {
        if (Build.VERSION.SDK_INT >= 11) {
            mj.b(paramWebView);
        }
    }

    public static int c() {
        if (Build.VERSION.SDK_INT >= 9) {
            return 7;
        }
        return 1;
    }

    public static int c(Context paramContext) {
        int i = 0;
        int j;
        if ((paramContext instanceof Activity)) {
            paramContext = ((Activity) paramContext).getWindow();
            Rect localRect = new Rect();
            paramContext.getDecorView().getWindowVisibleDisplayFrame(localRect);
            j = localRect.top;
            i = paramContext.findViewById(16908290).getTop() - j;
        }
        for (; ; ) {
            return i + j;
            j = 0;
        }
    }

    public static boolean c(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return false;
        }
        return paramString.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static long d(String paramString) {
        int i = 0;
        if (TextUtils.isEmpty(paramString)) {
            return -1L;
        }
        SimpleDateFormat[] arrayOfSimpleDateFormat = b;
        int j = arrayOfSimpleDateFormat.length;
        long l;
        while (i < j) {
            SimpleDateFormat localSimpleDateFormat = arrayOfSimpleDateFormat[i];
            try {
                localSimpleDateFormat.setLenient(false);
                localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                l = localSimpleDateFormat.parse(paramString).getTime();
                return l;
            } catch (ParseException localParseException) {
                i += 1;
            }
        }
        try {
            l = Long.parseLong(paramString);
            return l;
        } catch (NumberFormatException paramString) {
        }
        return -1L;
    }

    static String d() {
        StringBuffer localStringBuffer = new StringBuffer(256);
        localStringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            localStringBuffer.append(" ").append(Build.VERSION.RELEASE);
        }
        localStringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            localStringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                localStringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        localStringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return localStringBuffer.toString();
    }

    public static int[] d(Context paramContext) {
        paramContext = (WindowManager) paramContext.getSystemService("window");
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
        float f = 160.0F / localDisplayMetrics.densityDpi;
        return new int[]{(int) (localDisplayMetrics.widthPixels * f), (int) (f * localDisplayMetrics.heightPixels)};
    }

    public static String e() {
        Object localObject1 = UUID.randomUUID();
        byte[] arrayOfByte1 = BigInteger.valueOf(((UUID) localObject1).getLeastSignificantBits()).toByteArray();
        byte[] arrayOfByte2 = BigInteger.valueOf(((UUID) localObject1).getMostSignificantBits()).toByteArray();
        localObject1 = new BigInteger(1, arrayOfByte1).toString();
        int i = 0;
        while (i < 2) {
            try {
                Object localObject2 = MessageDigest.getInstance("MD5");
                ((MessageDigest) localObject2).update(arrayOfByte1);
                ((MessageDigest) localObject2).update(arrayOfByte2);
                byte[] arrayOfByte3 = new byte[8];
                System.arraycopy(((MessageDigest) localObject2).digest(), 0, arrayOfByte3, 0, 8);
                localObject2 = new BigInteger(1, arrayOfByte3).toString();
                localObject1 = localObject2;
            } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
                for (; ; ) {
                }
            }
            i += 1;
        }
        return (String) localObject1;
    }

    private static String f(Context paramContext) {
        return new WebView(paramContext).getSettings().getUserAgentString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */