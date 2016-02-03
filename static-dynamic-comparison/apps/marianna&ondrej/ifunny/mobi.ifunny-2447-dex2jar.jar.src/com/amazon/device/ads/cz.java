package com.amazon.device.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

class cz {
    private static final String a = Build.MANUFACTURER;
    private static final String b = Build.MODEL;
    private static final String c = Build.VERSION.RELEASE;
    private static String d;
    private String e;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private boolean o;
    private String p;
    private float q;
    private String r;
    private String s;
    private String t;
    private hk u;
    private hk v;

    protected cz() {
    }

    public cz(Context paramContext) {
        C();
        a(paramContext);
        B();
        b(paramContext);
    }

    private void A() {
        String str = Settings.Secure.getString(dn.i().h().getContentResolver(), "android_id");
        if ((hu.c(str)) || (str.equalsIgnoreCase("9774d56d682e549c"))) {
            this.k = null;
            this.l = null;
            this.n = true;
        }
        for (; ; ) {
            this.o = true;
            return;
            this.k = hu.b(str);
            this.l = hu.b(hu.a(str));
        }
    }

    private void B() {
        String str = Locale.getDefault().getLanguage();
        if ((str != null) && (str.length() > 0)) {
        }
        for (; ; ) {
            this.t = str;
            return;
            str = null;
        }
    }

    private void C() {
        String str = Locale.getDefault().getCountry();
        if ((str != null) && (str.length() > 0)) {
        }
        for (; ; ) {
            this.s = str;
            return;
            str = null;
        }
    }

    private void a(Context paramContext) {
        paramContext = (TelephonyManager) paramContext.getSystemService("phone");
        if (paramContext != null) {
            paramContext = paramContext.getNetworkOperatorName();
            if ((paramContext == null) || (paramContext.length() <= 0)) {
                break label36;
            }
        }
        for (; ; ) {
            this.r = paramContext;
            return;
            label36:
            paramContext = null;
        }
    }

    public static void a(String paramString) {
        if ((paramString != null) && (!paramString.equals(d))) {
            d = paramString;
        }
    }

    public static String b() {
        return "android";
    }

    private void b(Context paramContext) {
        if ((a.equals("motorola")) && (b.equals("MB502"))) {
        }
        DisplayMetrics localDisplayMetrics;
        for (this.q = 1.0F; ; this.q = localDisplayMetrics.scaledDensity) {
            this.p = Float.toString(this.q);
            return;
            paramContext = (WindowManager) paramContext.getSystemService("window");
            localDisplayMetrics = new DisplayMetrics();
            paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
        }
    }

    public static String c() {
        return a;
    }

    public static String d() {
        return b;
    }

    public static String e() {
        return "Android";
    }

    public static String f() {
        return c;
    }

    public static String t() {
        return d;
    }

    private void w() {
        if (!this.g) {
            a();
        }
    }

    private void x() {
        if (!this.j) {
            y();
        }
    }

    private void y() {
        try {
            String str1 = (String) Build.class.getDeclaredField("SERIAL").get(Build.class);
            if ((str1 == null) || (str1.length() == 0) || (str1.equalsIgnoreCase("unknown"))) {
                this.i = true;
                this.j = true;
                return;
            }
        } catch (Exception localException) {
            for (; ; ) {
                String str2 = null;
                continue;
                this.h = hu.b(hu.a(str2));
            }
        }
    }

    private void z() {
        if (!this.o) {
            A();
        }
    }

    protected void a() {
        Object localObject1 = (WifiManager) dn.i().h().getSystemService("wifi");
        if (localObject1 != null) {
        }
        for (; ; ) {
            try {
                localObject1 = ((WifiManager) localObject1).getConnectionInfo();
                if (localObject1 != null) {
                    break label83;
                }
                this.e = null;
                this.g = true;
                return;
            } catch (SecurityException localSecurityException) {
                dv.a("DeviceInfo", "Unable to get Wifi connection information: %s", new Object[]{localSecurityException});
                Object localObject2 = null;
                continue;
            } catch (ExceptionInInitializerError localExceptionInInitializerError) {
                dv.a("DeviceInfo", "Unable to get Wifi connection information: %s", new Object[]{localExceptionInInitializerError});
            }
            String str = null;
            continue;
            label83:
            str = str.getMacAddress();
            if ((str == null) || (str.length() == 0)) {
                this.e = null;
                this.f = true;
            } else if (!Pattern.compile("((([0-9a-fA-F]){1,2}[-:]){5}([0-9a-fA-F]){1,2})").matcher(str).find()) {
                this.e = null;
                this.f = true;
            } else {
                this.e = hu.b(hu.a(str));
            }
        }
    }

    public hk b(String paramString) {
        if ((paramString.equals("portrait")) && (this.v != null)) {
            return this.v;
        }
        if ((paramString.equals("landscape")) && (this.u != null)) {
            return this.u;
        }
        Object localObject = (WindowManager) dn.i().h().getSystemService("window");
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
        localObject = String.valueOf(localDisplayMetrics.widthPixels) + "x" + String.valueOf(localDisplayMetrics.heightPixels);
        if (paramString.equals("portrait")) {
            this.v = new hk((String) localObject);
            return this.v;
        }
        if (paramString.equals("landscape")) {
            this.u = new hk((String) localObject);
            return this.u;
        }
        return new hk((String) localObject);
    }

    JSONObject c(String paramString) {
        JSONObject localJSONObject = v();
        du.b(localJSONObject, "orientation", paramString);
        du.b(localJSONObject, "screenSize", b(paramString).toString());
        du.b(localJSONObject, "connectionType", n());
        return localJSONObject;
    }

    public String g() {
        w();
        return this.e;
    }

    public boolean h() {
        w();
        return this.f;
    }

    public String i() {
        x();
        return this.h;
    }

    public boolean j() {
        x();
        return this.i;
    }

    public String k() {
        z();
        return this.l;
    }

    public String l() {
        z();
        return this.m;
    }

    public boolean m() {
        z();
        return this.n;
    }

    public String n() {
        Object localObject2 = (ConnectivityManager) dn.i().h().getSystemService("connectivity");
        Object localObject1 = null;
        if (localObject2 != null) {
        }
        for (; ; ) {
            try {
                localObject2 = ((ConnectivityManager) localObject2).getActiveNetworkInfo();
                localObject1 = localObject2;
            } catch (SecurityException localSecurityException) {
                dv.a("DeviceInfo", "Unable to get active network information: %s", new Object[]{localSecurityException});
                continue;
            }
            if (localObject1 != null) {
                if (((NetworkInfo) localObject1).getType() == 1) {
                    return "Wifi";
                }
                return Integer.toString(((NetworkInfo) localObject1).getSubtype());
            }
            return Integer.toString(0);
            localObject1 = null;
        }
    }

    public String o() {
        return this.r;
    }

    public String p() {
        return this.s;
    }

    public String q() {
        return this.t;
    }

    public String r() {
        return this.p;
    }

    public float s() {
        return this.q;
    }

    public String u() {
        switch () {
            default:
                return "unknown";
            case 1:
            case 9:
                return "portrait";
        }
        return "landscape";
    }

    public JSONObject v() {
        JSONObject localJSONObject = new JSONObject();
        du.b(localJSONObject, "make", c());
        du.b(localJSONObject, "model", d());
        du.b(localJSONObject, "os", e());
        du.b(localJSONObject, "osVersion", f());
        du.b(localJSONObject, "scalingFactor", r());
        du.b(localJSONObject, "language", q());
        du.b(localJSONObject, "country", p());
        du.b(localJSONObject, "carrier", o());
        return localJSONObject;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */